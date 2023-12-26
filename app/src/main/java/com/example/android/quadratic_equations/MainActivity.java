package com.example.android.quadratic_equations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText A, B, C;
    TextView ResultText;
    Button button;

    final String LIMIT = "#0.000";
    DecimalFormat dF = new DecimalFormat(LIMIT);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.editText1);
        B = findViewById(R.id.editText2);
        C = findViewById(R.id.editText3);
        ResultText = findViewById(R.id.textView6);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        calculate();
    }

    @SuppressLint("SetTextI18n")
    private void calculate() {
        double a, b, c, d, x1, x2, x3, x4;
        String text;
        // проверяю что поле ввода  a,b,c  не пустое
        if (A.length() > 0) {
            a = Double.parseDouble(A.getText().toString());
        } else a = 0;
        if (B.length() > 0) {
            b = Double.parseDouble(B.getText().toString());
        } else b = 0;
        if (C.length() > 0) {
            c = Double.parseDouble(C.getText().toString());
        } else c = 0;

        d = ((b * b) - (4 * a * c));
        if (a == 0 && b == 0 && c == 0) {
            text = ("х-любое число");
        } else if (a == 0 && b == 0) {
            text = (" нет решений уравнения");
        } else if (a == 0) {
            x1 = -(c / b);
            text = ("x=" + dF.format(x1));
        } else if (d > 0) {
            x2 = (-b + Math.sqrt(d)) / (2 * a);
            x3 = (-b - Math.sqrt(d)) / (2 * a);
            text = ("x1= " + dF.format(x2) + "\n" + " x2= " + dF.format(x3));
        } else if (d < 0) {
            text = ("Нет действительных корней уравнения");
        } else {
            x4 = -b / (2 * a);
            text = ("x=" + dF.format(x4));
        }
        ResultText.setText("Дискриминант = " + dF.format(d) + "\n" + " " + text);
    }

}