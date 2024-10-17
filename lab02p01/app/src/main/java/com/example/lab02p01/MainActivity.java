package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button plus, minus;
    TextView licznik;
    int l = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        plus = findViewById(R.id.button_plus);
        minus = findViewById(R.id.button_minus);
        licznik = findViewById(R.id.tv_licznik);
        licznik.setText(String.valueOf(l));

        dodaj_sluchacze();
    }

    private void dodaj_sluchacze() {
        View.OnClickListener sluchacz_przyciskow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = v.getId();
                if (Id == R.id.button_plus) {
                    l++;
                } else if (Id == R.id.button_minus) {
                    l--;
                }
                licznik.setText(String.valueOf(l));
            }
        };
        plus.setOnClickListener(sluchacz_przyciskow);
        minus.setOnClickListener(sluchacz_przyciskow);

        licznik.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                l = 0;
                licznik.setText(String.valueOf(l));
                return false;
            }
        });
        
    }
}