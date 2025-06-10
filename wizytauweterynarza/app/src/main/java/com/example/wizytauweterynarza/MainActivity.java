package com.example.wizytauweterynarza;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] gat = {"pies", "kot", "świnka morska"};

        ListView list = findViewById(R.id.list);
        EditText name = findViewById(R.id.name);
        TextView lat = findViewById(R.id.lat);
        EditText cel = findViewById(R.id.cel);
        SeekBar seekBar = findViewById(R.id.seekBar);
        TimePicker czas = findViewById(R.id.czas);
        Button ok = findViewById(R.id.ok);
        TextView wynik = findViewById(R.id.wynik);

        String wyn_rasa;
        int wyn_wiek;


        czas.setHour(16);
        czas.setMinute(0);

        int godz = czas.getHour();
        int min = czas.getMinute();


        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, gat);
        list.setAdapter(arr);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int val = seekBar.getProgress();
                String vals = String.valueOf(val);
                lat.setText(vals);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String temp_rasa = (String) adapterView.getItemAtPosition(i);
                if (temp_rasa == "pies") {
                    seekBar.setMax(18);
                } else if (temp_rasa == "kot") {
                    seekBar.setMax(20);
                } else {
                    seekBar.setMax(8);
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int godz = czas.getHour();
                int min = czas.getMinute();
                wynik.setText(name.getText() + ", " + lat.getText() + ", " + cel.getText() + ", " + godz + ":" + min);
            }
        });


    }
}