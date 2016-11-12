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
}
