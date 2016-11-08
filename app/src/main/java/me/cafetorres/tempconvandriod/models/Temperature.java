package me.cafetorres.tempconvandriod.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Carlos on 05/11/2016.
 */

public class Temperature {
    private double Temp;
    private Date timestamp;


    public double getTemp() {
        return Temp;
    }



    public void setTemp(double temp) {
        Temp = temp;
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
}
