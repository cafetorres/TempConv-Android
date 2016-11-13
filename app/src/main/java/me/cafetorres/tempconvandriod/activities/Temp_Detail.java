package me.cafetorres.tempconvandriod.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.tempconvandriod.R;

/**
 * Created by Carlos on 12/11/2016.
 */

public class Temp_Detail extends AppCompatActivity {
    @Bind(R.id.txtTempd)
    TextView txtTempd;
    @Bind(R.id.txtDated)
    TextView txtDated;

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        txtTempd.setText(intent.getStringExtra("Temperature"));
        txtDated.setText(intent.getStringExtra("Date"));
    }
}
