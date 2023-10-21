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

public class MainActivity2 extends AppCompatActivity {

    EditText getInput;
    TextView fah,kel;
    Button convert;
    Float fahrenheit,celcius,kelvin;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getInput = findViewById(R.id.enterCel);
        fah = findViewById(R.id.fahText);
        kel = findViewById(R.id.kelvinText2);
        convert = findViewById(R.id.convertButton);
        backButton = findViewById(R.id.bacButton);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = getInput.getText().toString();
                celcius = Float.parseFloat(input);
                fahrenheit = (float) ((celcius*(9.0/5.0))+32);
                kelvin = celcius + 273;
                fah.setText(String.valueOf(fahrenheit)+" "+"\u2109");
                kel.setText(String.valueOf(kelvin)+" "+"K");
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }
}