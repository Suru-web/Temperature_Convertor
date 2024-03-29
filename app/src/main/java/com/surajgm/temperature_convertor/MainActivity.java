package com.surajgm.temperature_convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText getInput;
    TextView cel,kel;
    Button convert;
    Float fahrenheit,celcius,kelvin;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getInput = findViewById(R.id.enterFahren);
        cel = findViewById(R.id.celciusText);
        kel = findViewById(R.id.kelvinText);
        convert = findViewById(R.id.convertButton);
        next = findViewById(R.id.nextButton);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = getInput.getText().toString();
                fahrenheit = Float.parseFloat(input);
                celcius = (float) ((fahrenheit-32.0)*(5.0/9.0));
                kelvin = celcius + 273;
                cel.setText(celcius+" "+"\u2103");
                kel.setText(kelvin+" "+"K");
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
    }
}