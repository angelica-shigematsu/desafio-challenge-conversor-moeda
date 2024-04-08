package br.org.convetercoin.views;

public class MenuView {

    public String menu() {
        return """
                ************************************************
                Seja bem-vindo(a) ao Conversor de Moeda
                                
                1) Moeda Brasileira -> Dólar Americano
                2) Moeda Brasileira -> Euro
                3) Moeda Brasileira -> Iene
                4) Moeda Brasileira -> Dólar Australiano
                5) Moeda Brasileira -> Moeda Coreana
                6) Moeda Brasileira -> Moeda Briânica
                7) Sair
                ************************************************
                Escolha moeda que quer conveter:
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
