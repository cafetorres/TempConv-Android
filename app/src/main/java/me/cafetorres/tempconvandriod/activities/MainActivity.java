package me.cafetorres.tempconvandriod.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.cafetorres.tempconvandriod.R;
import me.cafetorres.tempconvandriod.fragments.TempHistoryListFragment;
import me.cafetorres.tempconvandriod.fragments.TempHistoryListFragmentListener;
import me.cafetorres.tempconvandriod.models.Temperature;
import me.cafetorres.tempconvandriod.utils.Converter;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.txtTempIn)
    EditText txtTempIn;
    @Bind(R.id.spinnerIn)
    Spinner spinnerIn;
    @Bind(R.id.spinnerOut)
    Spinner spinnerOut;
    @Bind(R.id.txtTempOut)
    EditText txtTempOut;
    @Bind(R.id.button)
    Button button;

    private TempHistoryListFragmentListener fragmentListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TempHistoryListFragment fragment=(TempHistoryListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentList);
    fragment.setRetainInstance(true);
        fragmentListener= (TempHistoryListFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentList);
    }

    




    private void about() {
    }

    @OnClick(R.id.button)
    public void handleSubmit(){
        hideKeyboard();

        String strTemp= txtTempIn.getText().toString().trim();

        Converter converter=new Converter();



        if(!strTemp.isEmpty()) {
            double temperatureIn =Double.parseDouble(strTemp);
            String text=spinnerIn.getSelectedItem().toString();
            converter.setTemperature(temperatureIn);
            converter.setSpinnerIn(spinnerIn.getSelectedItem().toString());
            converter.setSpineerOut(spinnerOut.getSelectedItem().toString());

            Temperature temperature=new Temperature();
            temperature.setTempIn(converter.getTemperature());
            temperature.setTempOut(temperatureIn);
            temperature.setTimestamp(new Date());


            String strTemp1= String.format(getString(R.string.global_message_temp),temperature.getTempOut());

            txtTempOut.setVisibility(View.VISIBLE);
            txtTempOut.setText(strTemp1);

        }
        
    }

    private void hideKeyboard() {
        InputMethodManager inputManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}
