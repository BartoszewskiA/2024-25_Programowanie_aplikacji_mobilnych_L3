package com.example.lab03p01;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar_R, seekBar_G, seekBar_B;
    TextView textView_R, textView_G, textView_B;
    View panel;
    CheckBox checkBox;

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
        seekBar_R = findViewById(R.id.seekBar_R);
        seekBar_G = findViewById(R.id.seekBar_G);
        seekBar_B = findViewById(R.id.seekBar_B);
        textView_R = findViewById(R.id.textView_R);
        textView_G = findViewById(R.id.textView_G);
        textView_B = findViewById(R.id.textView_B);
        panel = findViewById(R.id.panel);
        checkBox = findViewById(R.id.checkBox);
        kolor();
        SeekBar.OnSeekBarChangeListener sluchacz = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                kolor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        seekBar_R.setOnSeekBarChangeListener(sluchacz);
        seekBar_G.setOnSeekBarChangeListener(sluchacz);
        seekBar_B.setOnSeekBarChangeListener(sluchacz);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                kolor();
            }
        });
    }
    private void kolor() {
        int kolor;
        if(!checkBox.isChecked())
        {
            kolor = Color.rgb(
                    seekBar_R.getProgress(),
                    seekBar_G.getProgress(),
                    seekBar_B.getProgress());
        } else
        {
            int srednia = (seekBar_R.getProgress()+ seekBar_G.getProgress()+ seekBar_B.getProgress())/3;
            kolor = Color.rgb(srednia, srednia, srednia);
        }

        panel.setBackgroundColor(kolor);
    }
}