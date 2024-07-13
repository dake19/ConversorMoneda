package com.conversor;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void displayMenu () {
        Scanner leer = new Scanner(System.in);
        ExchangeRateApiClient apiClient = new ExchangeRateApiClient();
        JsonObject exchangeRates = null;

        try{
            exchangeRates = apiClient.getExchangeRates();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener los tipos de cambio:" + e.getMessage());
        }



        EXTERNA:
        while (true) {
            System.out.println("CONVERSOR DE MONEDAS");
            System.out.println("1 - Peso Argentino a Dólares (ARS)\n"
                    + "2 - Boliviano a Dólares (BOB)\n"
                    + "3 - Real Brasileño a Dólares (BRL)\n"
                    + "4 - Peso Chileno a Dólares (CLP)\n"
                    + "5 - Peso Colombiano a Dólares (COP)\n"
                    + "6 - Salir");
            System.out.print("INGRESE UNA OPCION: ");
            char opcion = leer.next().charAt(0);

            calculo conversor;
            switch (opcion) {
                case '1':
                    conversor = new calculo("Peso Argentino");
                    conversor.setValorDolar(apiClient.getExchangeRate(exchangeRates, "ARS"));
                    break;
                        
                case '2':
                    conversor = new calculo("Boliviano");
                    conversor.setValorDolar(apiClient.getExchangeRate(exchangeRates, "BOB"));
                    break;

                case '3':
                    conversor = new calculo("Real Brasileño");
                    conversor.setValorDolar(apiClient.getExchangeRate(exchangeRates, "BRL"));
                    break;

                case '4':
                    conversor = new calculo("Peso Chileno");
                    conversor.setValorDolar(apiClient.getExchangeRate(exchangeRates, "CLP"));
                    break;

                case '5':
                    conversor = new calculo("Peso Colombiano");
                    conversor.setValorDolar(apiClient.getExchangeRate(exchangeRates, "COP"));
                    break;

                case '6':
                    System.out.println("CERRANDO PROGRAMA");
                    break EXTERNA;
                default:
                    System.out.println("OPCION INCORRECTA");
                    continue; // Vuelve al inicio del bucle
            }

            System.out.printf("Ingrese la cantidad de %s: ", conversor.getPais());
            double cantidadMoneda = leer.nextDouble();
            double dolares = conversor.convertir(cantidadMoneda);

            System.out.println("---------------------------------------");
            System.out.println("|     Tienes $" + dolares + " dolares       |");
            System.out.println("---------------------------------------");
        }

        leer.close();
    }
}
