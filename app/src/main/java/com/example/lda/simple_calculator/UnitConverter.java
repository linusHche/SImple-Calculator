package com.example.lda.simple_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class UnitConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);


        final Spinner beforeSpinner = findViewById(R.id.before);
        final Spinner afterSpinner = findViewById(R.id.after);
        final TextView display = findViewById(R.id.resultValue);
        Button convertButton = findViewById(R.id.convert_btn);
        Button swapButton = findViewById(R.id.swap_btn);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(UnitConverter.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.units));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(UnitConverter.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.units));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        beforeSpinner.setAdapter(myAdapter);
        afterSpinner.setAdapter(myAdapter2);
        final EditText entry = findViewById(R.id.enterValue);





        convertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String beforeUnit = beforeSpinner.getSelectedItem().toString();
                    String afterUnit = afterSpinner.getSelectedItem().toString();
                    double value = Double.parseDouble(entry.getText().toString());
                    double result = mediator(value, beforeUnit);
                    result = conversion(result, afterUnit);
                    DecimalFormat numberFormat = new DecimalFormat("#.00000");
                    display.setText(numberFormat.format(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), " Please enter a valid input ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int beforePos = beforeSpinner.getSelectedItemPosition();
                int afterPos = afterSpinner.getSelectedItemPosition();
                beforeSpinner.setSelection(afterPos);
                afterSpinner.setSelection(beforePos);

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
