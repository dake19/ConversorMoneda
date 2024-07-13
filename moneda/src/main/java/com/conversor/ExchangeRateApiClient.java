package com.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/81fa9515ae2f7008e47651ac/latest/USD";

    public JsonObject getExchangeRates() throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), JsonObject.class);

    }

    public double getExchangeRate(JsonObject exchangeRates, String currencyCode) {
        JsonObject conversionRates = exchangeRates.getAsJsonObject("conversion_rates");
        return conversionRates.get(currencyCode).getAsDouble();
    }
}
