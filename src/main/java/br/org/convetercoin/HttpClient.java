package br.org.convetercoin;

import br.org.convetercoin.models.Log;
import br.org.convetercoin.services.HttpRequest;
import br.org.convetercoin.views.MenuView;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HttpClient {
    public static void main(String[] args) throws IOException {

        ArrayList<Log> list = new ArrayList();
        int optionMenu = 0;
        String country = "";
        double moneyToChange = 0.0;

        Scanner scanner = new Scanner(System.in);

        do {
            MenuView menu = new MenuView();
            System.out.println(menu.menu());

            //choose option of menu
            optionMenu = scanner.nextInt();

            country = menu.choiceCodeCountry(optionMenu);

            if ((optionMenu > 0 || optionMenu < 7) && String.valueOf(optionMenu).matches("[1-6]*")) {

                System.out.println("Digite o valor para o que quer converter:");
                moneyToChange = scanner.nextDouble();

                Date data = new Date();

                Log newLog = new Log(new Date(), optionMenu);
                list.add(newLog);

                HttpRequest request = new HttpRequest();
                double valueChanged = request.getHttpRequest(country, moneyToChange);
                System.out.println(request.printOut(valueChanged));
            }

            if (optionMenu == 7) {
                MenuView newView = new MenuView();
                System.out.println("*************************************");
                System.out.println("Registros de log");
                if (list.isEmpty()) {
                    System.out.println("Nenhuma atividade registrada");
                }
                for (Log show : list) {
                    String formattedDate = new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(show.getDataLog());
                    System.out.println(formattedDate+  " " + newView.choiceCodeCountry(show.getEscolha()));
                }
            }

        } while (optionMenu != 8);
    }
}