package me.cafetorres.tempconvandriod.utils;

/**
 * Created by Carlos on 07/11/2016.
 */

public class Converter {
    double temperature;
    String spinnerIn;
    String spineerOut;

    public double getTemperature() {

       // if(spinnerIn==spineerOut)this.temperature = temperature;
        if(spinnerIn.equals("Celsius")&&spineerOut.equals("Fahrenheit")){ //C to F
            temperature=temperature*1.8+32;}

        if(spinnerIn.equals("Celsius")&&spineerOut.equals("Kelvin")){ //C to K
            temperature=temperature+273.15;}

        if(spinnerIn.equals("Fahrenheit")&&spineerOut.equals("Celsius")){ //F to C
            temperature=(temperature-32)/1.8;}

        if(spinnerIn.equals("Fahrenheit")&&spineerOut.equals("Kelvin")){ //F to K
            temperature=5/9*(temperature-32)+273.15;}

        if(spinnerIn.equals("Kelvin")&&spineerOut.equals("Celsius")){ //K to C
            temperature=temperature-273.15;}

        if(spinnerIn.equals("Kelvin")&&spineerOut.equals("Fahrenheit")){ //K to F
            temperature=1.8*(temperature-273.15)+32;}
        return temperature;
    }

    public void setTemperature(double temperature) {

        this.temperature = temperature;


    }

    public String getSpinnerIn() {
        return spinnerIn;
    }

    public void setSpinnerIn(String spinnerIn) {
        this.spinnerIn = spinnerIn;
    }

    public String getSpineerOut() {
        return spineerOut;
    }

    public void setSpineerOut(String spineerOut) {
        this.spineerOut = spineerOut;
    }
}
