package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class frameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        String texto = getIntent().getStringExtra("texto");
        TextView textFibo = (TextView)findViewById(R.id.fibotext);
        textFibo.setText(texto);


    }
}