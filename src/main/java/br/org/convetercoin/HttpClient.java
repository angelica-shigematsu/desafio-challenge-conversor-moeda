package br.org.convetercoin;

import br.org.convetercoin.services.HttpRequest;
import br.org.convetercoin.views.MenuView;
import java.io.IOException;
import java.util.Scanner;

public class HttpClient {
    public static void main(String[] args) throws IOException {
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

                HttpRequest request = new HttpRequest();
                double valueChanged = request.getHttpRequest(country, moneyToChange);
                System.out.println(request.printOut(valueChanged));
            }

        } while (optionMenu != 7);
    }
}