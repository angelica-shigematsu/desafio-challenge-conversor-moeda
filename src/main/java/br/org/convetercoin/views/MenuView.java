package br.org.convetercoin.views;

public class MenuView {

    public String menu() {
        return """
                ************************************************
                Seja bem-vindo(a) ao Conversor de Moeda
                                
                1) Real -> Dólar Americano
                2) Real -> Euro
                3) Real -> Iene
                4) Real -> Dólar Australiano
                5) Real -> Moeda Coreana
                6) Real -> Moeda Britânica
                7) Verificar registro de logs
                8) Sair
                ************************************************
                Escolha uma opção:
                """;
    }

    public String choiceCodeCountry(int option) {
        String country = "";
        switch (option) {
            case 1:
                country = "USD";
                break;
            case 2:
                country = "EUR";
                break;
            case 3:
                country = "JPY";
                break;
            case 4:
                country = "AUD";
                break;
            case 5:
                country = "KRW";
                break;
            case 6:
                country = "GBP";
                break;
            case 7:
                break;
            default:
                return "Não existe essa opção tente novamente!";
        }
        return country;
    }
}
