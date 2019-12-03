package com.dauntlessdev.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<Integer> arrayList = new ArrayList<>();
        final ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 1 ; i<=10; i++){
            arrayList.add(i);
            arrayList2.add(i);
        }


        final ListView listView = findViewById(R.id.listView);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);


        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(0);
        seekBar.setMax(19);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                for (int i = 0; i <10; i++){
                    arrayList2.set(i, arrayList.get(i)*(progress+1));
                }
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, arrayList2);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
