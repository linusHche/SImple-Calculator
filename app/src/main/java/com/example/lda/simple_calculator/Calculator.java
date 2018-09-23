package com.example.lda.simple_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private Boolean equalPressed = false;
    private Boolean functionPressed = false;
    private Function currentFunction = Function.NON;

    private String screenMsg1 = new String();
    private String screenMsg2 = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final TextView screen = findViewById(R.id.screenDisplay);

        Button onebtn = findViewById(R.id.one);
        Button secondbtn = findViewById(R.id.two);
        Button threebtn = findViewById(R.id.three);
        Button fourbtn = findViewById(R.id.four);
        Button fivebtn = findViewById(R.id.five);
        Button sixbtn = findViewById(R.id.six);
        Button sevenbtn = findViewById(R.id.seven);
        Button eightbtn = findViewById(R.id.eight);
        Button ninebtn = findViewById(R.id.nine);
        Button addbtn = findViewById(R.id.add_btn);
        Button subbtn = findViewById(R.id.sub_btn);
        Button mulbtn = findViewById(R.id.multiplication_btn);
        Button divbtn = findViewById(R.id.division_btn);
        Button rembtn = findViewById(R.id.remainderDivision_btn);
        Button equalbtn = findViewById(R.id.equal_btn);
        Button clearbtn = findViewById(R.id.clear_btn);

        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(1, screen);
            }
        });

        secondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(2, screen);
            }
        });

        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(3, screen);
            }
        });

        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(4, screen);
            }
        });

        fivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(5, screen);
            }
        });

        sixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(6, screen);
            }
        });

        sevenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(7, screen);
            }
        });

        eightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(8, screen);
            }
        });

        ninebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClicked1(9, screen);
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionPressed = true;
                currentFunction = Function.ADD;
                equalPressed = false;

            }
        });

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionPressed = true;
                currentFunction = Function.SUB;
                equalPressed = false;

            }
        });

        mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionPressed = true;
                currentFunction = Function.MUL;
                equalPressed = false;

            }
        });

        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionPressed = true;
                currentFunction = Function.DIV;
                equalPressed = false;

            }
        });

        rembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionPressed = true;
                currentFunction = Function.REM;
                equalPressed = false;

            }
        });

        equalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equalPressed = true;
                String textString = "";

                switch (currentFunction) {
                    case ADD:
                        textString = Calculations.addition(Double.parseDouble(screenMsg1), Double.parseDouble(screenMsg2));
                        break;
                    case SUB:
                        textString = Calculations.subtraction(Double.parseDouble(screenMsg1), Double.parseDouble(screenMsg2));
                        break;
                    case MUL:
                        textString = Calculations.multiplication(Double.parseDouble(screenMsg1), Double.parseDouble(screenMsg2));
                        break;
                    case DIV:
                        textString = Calculations.regularDivision(Double.parseDouble(screenMsg1), Double.parseDouble(screenMsg2));
                        break;
                    case REM:
                        textString = Calculations.divisionWithRemainder(Double.parseDouble(screenMsg1), Double.parseDouble(screenMsg2));
                        break;
                }
                screen.setText(textString);
                screenMsg1 = textString;
                screenMsg2 = "";

                functionPressed = false;
                currentFunction = Function.NON;

            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenMsg1 = "";
                screenMsg2 = "";
                screen.setText("0");
                equalPressed = false;
                functionPressed = false;
            }
        });
    }

    private void whenClicked1(int x, TextView t) {
        if (equalPressed) {
            screenMsg1 = String.valueOf(x);
            t.setText(screenMsg1);
            equalPressed = false;
        } else if (functionPressed){
            if (screenMsg2.length() < 15) {
                screenMsg2 = screenMsg2.concat(String.valueOf(x));
                equalPressed = false;
            }
            t.setText(screenMsg2);
        } else {
            if (screenMsg1.length() < 15) {
                screenMsg1 = screenMsg1.concat(String.valueOf(x));
            }
            t.setText(screenMsg1);
        }
    }
}