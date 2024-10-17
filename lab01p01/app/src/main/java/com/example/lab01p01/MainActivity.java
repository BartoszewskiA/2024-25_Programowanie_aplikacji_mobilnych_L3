package com.example.lab01p01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText01, editText02;
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        wynik = findViewById(R.id.textView02);

    }

    public void dodaj(View view) {
//        double a = Double.parseDouble(editText01.getText().toString());
//        double b = Double.parseDouble(editText02.getText().toString());
//        double c = a + b;
//        wynik.setText(String.valueOf(c));
        String a = editText01.getText().toString();
        String b = editText02.getText().toString();
        double x,y;
        try {
            x = Double.parseDouble(a);
        } catch (Exception e) {
            x = 0;
            editText01.setText("0");
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try {
            y = Double.parseDouble(b);
        } catch (Exception e) {
            y=0;
            editText02.setText("0");
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        wynik.setText(String.valueOf(x+y));
    }
}