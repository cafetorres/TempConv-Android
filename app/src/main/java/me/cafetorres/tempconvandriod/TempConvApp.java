package me.cafetorres.tempconvandriod;

import android.app.Application;

/**
 * Created by Carlos on 12/11/2016.
 */

public class TempConvApp extends Application{
    private final static String ABOUT = "http://juancrg90.me";

    public String getAbout() {
        return ABOUT;
    }
}
