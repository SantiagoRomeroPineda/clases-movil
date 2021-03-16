package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class window3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window3);
        Button frame = (Button) findViewById(R.id.frame);
        Button web =(Button) findViewById(R.id.web);
        EditText texto= (EditText) findViewById(R.id.usuario);
        Spinner nivelEducativo = (Spinner) findViewById(R.id.nivelEducativo);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(),frameActivity.class);
                intent.putExtra("texto", texto.getText().toString()+" "+ (String)nivelEducativo.getSelectedItem());
                startActivity(intent);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), webActivity.class);
                startActivity(intent);
            }
        });
    }
}