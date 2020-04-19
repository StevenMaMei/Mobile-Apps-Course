package com.example.clase3actividad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import java.io.Serializable;
import java.util.UUID;

public class CambiadorActivity extends AppCompatActivity {
    private Button black,white,blue;
    private ConstraintLayout la;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiador);
        la = findViewById(R.id.cons1);
        black = findViewById(R.id.black);
        white = findViewById(R.id.white);
        blue = findViewById(R.id.blue);
        Serializable serializable = getIntent().getExtras().getSerializable("color");


        if(serializable == null){

        }else{
            String col = (String) serializable;
            if(col.equals("black")){
                la.setBackgroundColor(Color.rgb(0,0,0));
            }else if(col.equals("white")){
                la.setBackgroundColor(Color.rgb(255,255,255));
            }else{
                la.setBackgroundColor(Color.rgb(0,4,255));
            }
        }
        black.setOnClickListener(
                (v) ->{
                    Intent i = new Intent();
                    la.setBackgroundColor(Color.rgb(0,0,0));
                    i.putExtra("color","black");
                    setResult(RESULT_OK,i);
                    finish();
                }
        );
        white.setOnClickListener(
                (v) ->{
                    Intent i = new Intent();
                    la.setBackgroundColor(Color.rgb(255,255,255));
                    i.putExtra("color","white");
                    setResult(RESULT_OK,i);
                    finish();
                }
        );
        blue.setOnClickListener(
                (v) ->{
                    Intent i = new Intent();
                    la.setBackgroundColor(Color.rgb(0,4,255));
                    i.putExtra("color","blue");
                    setResult(RESULT_OK,i);
                    finish();
                }
        );
    }
}
