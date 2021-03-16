package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutSecond);
        TextView textView1 =  new TextView(this);
        textView1.setText("mi email es:"+ email);
        TextView textView2 =  new TextView(this);
        textView2.setText("mi contraseña es:"+ password);
        ll.addView(textView1);
        ll.addView(textView2);



        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(),window3.class);

                startActivity(intent);
            }
        });
    }



}