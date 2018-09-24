package com.example.lda.simple_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculator = findViewById(R.id.Calculator);
        Button unitConverter = findViewById(R.id.unit_conversion);


        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculatorIntent = new Intent(getApplicationContext(), Calculator.class);
                startActivity(calculatorIntent);
            }
        });

        unitConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unitConverterIntent = new Intent(getApplicationContext(), UnitConverter.class);
                startActivity(unitConverterIntent);
            }
        });


    }
}