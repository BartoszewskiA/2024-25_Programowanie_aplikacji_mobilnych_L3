package com.example.lab02p02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String male_litery = "qwertyuiopasdfghjklzxcvbnm";
    String duze_litery = "QWERTYUIOPASDFGHJKLZXCVBNM";
    String cyfry = "1234567890";
    String znaki = "!@#$%";
    Random random;

    Button bt_generuj;
    EditText et_dlugosc;
    EditText et_haslo;

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
        random = new Random();
        bt_generuj = findViewById(R.id.bt_generuj);
        et_dlugosc = findViewById(R.id.et_dlugosc);
        et_haslo = findViewById(R.id.et_haslo);
        bt_generuj.setOnClickListener(v -> {
            try {
                int dlugosc = Integer.parseInt(et_dlugosc.getText().toString());
                if(dlugosc >=5 && dlugosc <= 20)
                    et_haslo.setText(generuj_haslo(dlugosc));
                else {
                    Toast.makeText(this, "Długość hasła musi być z przedziału 5-20", Toast.LENGTH_SHORT).show();
                    return;
                }
            }catch (Exception e)
            {
                Toast.makeText(this, "Wpisz właściwą liczbę", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    private String generuj_haslo(int dlugosc) {
        StringBuilder haslo = new StringBuilder("");
        String s;
        for (int i = 0; i < dlugosc - 3; i++) {
            //s = male_litery.substring(random.nextInt(male_litery.length()-1), 1);
            s = String.valueOf(male_litery.charAt(random.nextInt(male_litery.length())));
            haslo.append(s);
        }
        s = String.valueOf(duze_litery.charAt(random.nextInt(duze_litery.length())));
        haslo.insert(random.nextInt(dlugosc), s);
        s = String.valueOf(cyfry.charAt(random.nextInt(cyfry.length())));
        haslo.insert(random.nextInt(dlugosc), s);
        s = String.valueOf(znaki.charAt(random.nextInt(znaki.length())));
        haslo.insert(random.nextInt(dlugosc), s);
        return haslo.toString();
    }
}