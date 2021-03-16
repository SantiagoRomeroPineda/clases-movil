package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text= (EditText) findViewById(R.id.text);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.button);
        Button submit = (Button) findViewById(R.id.submit);
        Button logginButton = (Button) findViewById(R.id.logginButton);
        Button lista = (Button) findViewById(R.id.listView);
        Button contacts_camera = (Button) findViewById(R.id.contacts_camera);
        Button maps_button = (Button) findViewById(R.id.localization_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), text.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        contacts_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),
                        PermissionsActivity.class));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(),SecondActivity.class);
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);
            }
        });

        logginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(),login.class);
                startActivity(intent);
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), Lista.class);
                startActivity(intent);
            }
        });

        maps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });


    }
}