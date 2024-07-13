package com.conversor;

public class calculo {
    private double valorDolar;
    private String pais;

    public calculo(String pais) {
        this.pais = pais;
    }

    public void setValorDolar(double valorDolar){
        this.valorDolar = valorDolar;
    }

    public String getPais(){
        return pais;
    }

    public double convertir(double cantidadMoneda){
        double dolares = cantidadMoneda / valorDolar;
        dolares = (double) Math.round(dolares * 100) / 100;
        return dolares; 
    }

    /*public void convertir(Scanner leer) {
        System.out.printf("Ingrese la cantidad de %s: ", pais);
        double cantidadMoneda = leer.nextDouble();

        double dolares = cantidadMoneda / valorDolar;
        dolares = (double) Math.round(dolares * 100d) / 100;

        System.out.println("---------------------------------------");
        System.out.println("|     Tienes $" + dolares + " dolares       |");
        System.out.println("---------------------------------------");
    }*/
    
}
