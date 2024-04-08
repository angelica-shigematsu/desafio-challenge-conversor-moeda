package br.org.convetercoin.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class HttpRequest {

    public double getHttpRequest (String country, double moneyToChange) throws IOException {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/4f8de0a8de7241265c2de558/latest/BRL";

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            String req_result = jsonobj.get("result").getAsString();

            if (req_result.equals("success")) {
                double value = Double.parseDouble(jsonobj.get("conversion_rates").getAsJsonObject().get(country).toString());
                return exchangeRate(value, moneyToChange);
            }
        } catch (Error error) {
            System.out.println("Erro! Tente de novo." + error.getMessage());
        }
        return 0.0;
    }
    private double exchangeRate(double coin, double money) {
        return coin * money;
    }

    public String printOut(double coinConverter) {
        return """
                Resultado: %f
                *********************************************
                """.formatted(coinConverter);
    }

}
