package com.example.l2q2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button ad, su, mu, di;
    TextView result;
    double res = 0;
    String rest;
    EditText num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ad = findViewById(R.id.bad);
        su = findViewById(R.id.bsu);
        mu = findViewById(R.id.bmu);
        di = findViewById(R.id.bdi);
        ad.setOnClickListener(v -> performop("+"));
        su.setOnClickListener(v -> performop("-"));
        mu.setOnClickListener(v -> performop("*"));
        di.setOnClickListener(v -> performop("/"));

        result = findViewById(R.id.textView3);


        num1 = findViewById(R.id.editTextNumber);
        num2 = findViewById(R.id.editTextNumber2);
    }

    private void performop(String op) {
        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());

        switch(op){
            case"+":
                res=n1+n2;
                break;
            case"-":
                res=n1-n2;
                break;
            case"*":
                res=n1*n2;
                break;
            case"/":
                res=n1/n2;
                break;
        } rest=n1+op+n2+" = "+res;
        result.setText(rest);
    }

}