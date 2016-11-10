package me.cafetorres.tempconvandriod.fragments;
import me.cafetorres.tempconvandriod.models.Temperature;

/**
 * Created by Carlos on 10/11/2016.
 */

public interface TempHistoryListFragmentListener {
    void addToList(Temperature temperatute);
    void clearList();
}
