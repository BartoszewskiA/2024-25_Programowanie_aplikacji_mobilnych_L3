package com.example.lab03p02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] owoce = {
            R.drawable.owoc01,
            R.drawable.owoc02,
            R.drawable.owoc03,
            R.drawable.owoc04
    };

    Random random = new Random();
    int los_1=0, los_2=0, los_3=0;
    int kredyt = 50;
    int licznik =0;

    ImageView ramka_1, ramka_2, ramka_3;
    Button btn_graj, btn_reset;
    TextView tv_kredyt, tv_licznik;

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
        ramka_1 = findViewById(R.id.iv_ramka01);
        ramka_2 = findViewById(R.id.iv_ramka02);
        ramka_3 = findViewById(R.id.iv_ramka03);
        tv_kredyt = findViewById(R.id.tv_kredyt);
        tv_licznik = findViewById(R.id.tv_licznik);
        btn_reset = findViewById(R.id.btn_reset);
        btn_graj = findViewById(R.id.btn_graj);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id == R.id.btn_graj)
                    graj();
                else if(id == R.id.btn_reset)
                    reset();
            }
        };
        btn_graj.setOnClickListener(sluchacz);
        btn_reset.setOnClickListener(sluchacz);

    }

    private void reset() {
        kredyt = 50;
        licznik=0;
        tv_licznik.setText(String.valueOf(licznik));
        tv_kredyt.setText(String.valueOf(kredyt)+" $$");
        btn_graj.setEnabled(true);
        ramka_1.setImageDrawable(null);
        ramka_2.setImageDrawable(null);
        ramka_3.setImageDrawable(null);

    }

    private void graj() {
        licznik++;
        tv_licznik.setText(String.valueOf(licznik));
        los_1 = random.nextInt(owoce.length);
        los_2 = random.nextInt(owoce.length);
        los_3 = random.nextInt(owoce.length);
        ramka_1.setImageResource(owoce[los_1]);
        ramka_2.setImageResource(owoce[los_2]);
        ramka_3.setImageResource(owoce[los_3]);
        if (los_1 == los_2 && los_2 == los_3) {
            kredyt += 20;
        }
        else
            kredyt-=5;
        tv_kredyt.setText(String.valueOf(kredyt)+" $$");
        if(kredyt<=0)
        {
            btn_graj.setEnabled(false);
        }
    }
}