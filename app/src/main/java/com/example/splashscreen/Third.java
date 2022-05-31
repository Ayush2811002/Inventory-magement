package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Third extends AppCompatActivity {
    private Button button1;
    private ImageButton Addp;
    private ImageButton hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button1=findViewById(R.id.button1);
        Addp=findViewById(R.id.Addp);
        hello=findViewById(R.id.hello);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Third.this,"Hello how are you",Toast.LENGTH_SHORT).show();
                    Intent splash=new Intent(Third.this,Addp.class);
                    startActivity(splash);


            }
        });


        Addp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Third.this,"Hello how are you",Toast.LENGTH_SHORT).show();
                Intent splash=new Intent(Third.this,invet.class);
                startActivity(splash);



            }
        });

        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Third.this,"Hello how are you",Toast.LENGTH_SHORT).show();
                Intent splash=new Intent(Third.this,mange.class);
                startActivity(splash);

            }
        });

    }
}