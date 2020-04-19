package com.example.clase3actividad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private String col;
    private ConstraintLayout la;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        la = findViewById(R.id.cons);
        btn1.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, CambiadorActivity.class);
                    i.putExtra("color", col);
                    startActivityForResult(i,11);
                }
        );

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 11 && resultCode == RESULT_OK){
            col= (String) data.getExtras().getSerializable("color");
            if(col.equals("black")){
                la.setBackgroundColor(Color.rgb(0,0,0));
            }else if(col.equals("white")){
                la.setBackgroundColor(Color.rgb(255,255,255));
            }else{
                la.setBackgroundColor(Color.rgb(0,4,255));
            }
        }
    }
}
