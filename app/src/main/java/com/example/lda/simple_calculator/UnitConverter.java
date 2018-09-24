package com.example.lda.simple_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class UnitConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);

        Spinner beforeSpinner = findViewById(R.id.before);
        Spinner afterSpinner = findViewById(R.id.after);
        final TextView display = findViewById(R.id.resultValue);
        Button convertButton = findViewById(R.id.convert_btn);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(UnitConverter.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.units));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        beforeSpinner.setAdapter(myAdapter);
        afterSpinner.setAdapter(myAdapter);
        EditText entry = findViewById(R.id.enterValue);
        final double value = Double.parseDouble(entry.getText().toString());

        final String beforeUnit = beforeSpinner.getSelectedItem().toString();
        final String afterUnit = afterSpinner.getSelectedItem().toString();






        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double result = mediator(value, beforeUnit);
                result = conversion(result, afterUnit);
                display.setText(result+"");
            }
        });




    }





    private double mediator(double value, String beforeUnit) {
        switch (beforeUnit) {
            case "Centimeters":
                value /= 100;
                break;
            case "Inches":
                value /= 254;
                break;
            case "Kilometers":
                value *= 1000;
                break;
            case "Meters":
                break;
            case "Miles":
                value *= 1609.34;
                break;
            case "Feet":
                value *= 0.3048;
                break;
            case "Yards":
                value *= 0.9144;
                break;

        }

        return value;
    }



    private double conversion(double value, String afterUnit) {
        switch (afterUnit) {
            case "Centimeters":
                value *= 100;
                break;
            case "Inches":
                value *= 254;
                break;
            case "Kilometers":
                value /= 1000;
                break;
            case "Meters":
                break;
            case "Miles":
                value /= 1609.34;
                break;
            case "Feet":
                value /= 0.3048;
                break;
            case "Yards":
                value /= 0.9144;
                break;

        }

        return value;

    }

}
