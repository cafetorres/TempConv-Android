package me.cafetorres.tempconvandriod.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Carlos on 05/11/2016.
 */

public class Temperature {
    private double TempIn;
    private double TempOut;
    private Date timestamp;
    String spinnerIn;
    String spineerOut;

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


    public double getTempIn() {
        return TempIn;
    }



    public void setTempIn(double temp) {
        TempIn = temp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestap) {
        this.timestamp = timestap;
    }
    public String getDateFormated() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd, yyyy HH:mm");

        return simpleDateFormat.format(timestamp);
    }

    public double getTempOut() {
        return TempOut;
    }

    public void setTempOut(double tempOut) {
        TempOut = tempOut;
    }
    public String showTemp()
    {
        String sI=spinnerIn.substring(0,1);
        String sO=spineerOut.substring(0,1);
        String temp= String.format("%,.1f °%s >> %,.1f °%s",TempIn,sI, TempOut,sO);
        return temp;
    }
}
