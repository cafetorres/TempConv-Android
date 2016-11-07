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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.cafetorres.tempconvandriod.R;
import me.cafetorres.tempconvandriod.models.Temperature;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void handleSubmit(){
        hideKeyboard();

        String strTemp= txtTempIn.getText().toString().trim();

        if(!strTemp.isEmpty()) {
            double temperatureIn =Double.parseDouble(strTemp);

            Temperature temperature=new Temperature();
            temperature.setTemp(temperatureIn);

            if(spinnerIn.getSelectedItemPosition()==spinnerOut.getSelectedItemPosition()){
            String strTemp1= String.format(getString(R.string.global_message_temp),temperature.getTemp());

            txtTempOut.setVisibility(View.VISIBLE);
            txtTempOut.setText(strTemp1);}

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
