package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista extends AppCompatActivity {

    String[] arreglo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        initArray();
        ArrayAdapter<String>adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private void initArray(){
        arreglo = new  String[15];
        for(int i=0; i<arreglo.length; ++i){
            arreglo[i]= ((i%2==0) ? "hola" : "mundo");
        }
    }
}