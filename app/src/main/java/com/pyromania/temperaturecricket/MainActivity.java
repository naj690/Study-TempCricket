package com.pyromania.temperaturecricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirp;
    Button btnCalculate;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirp = findViewById(R.id.etChirp);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etChirp.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the above field!", Toast.LENGTH_SHORT).show();
                } else {

                    String sChirp = etChirp.getText().toString().trim();
                    int qtyChirp = Integer.parseInt(sChirp);
                    double temp = qtyChirp / 3.0 + 4;

                    tvResult.setText(getString(R.string.resulttext1) + formatter.format(temp) + getString(R.string.resulttext2));

                    tvResult.setVisibility(View.VISIBLE);

                }
            }
        });
    }
}
