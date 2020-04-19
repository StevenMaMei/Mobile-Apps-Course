package com.example.referenciaviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private EditText nameET, passwordET;
    private TextView prueba;
    private Button signBTN;
    private NavigationView navv;
    private ConstraintLayout la;
    float Xini,Yini;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prueba = findViewById(R.id.prueba);
        nameET = findViewById(R.id.nameET);
        navv = findViewById(R.id.navv);
        passwordET = findViewById(R.id.passwordET);
        signBTN = findViewById(R.id.signBTN);

        signBTN.setOnClickListener(
                (v) -> {
                    String name = nameET.getText().toString();
                    String password = passwordET.getText().toString();
                    Toast.makeText(this, name+":"+password, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, TouchActivity.class);
                    startActivity(i);
                }
        );

        prueba.setOnTouchListener(
                (v, event) -> {
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            Xini = event.getX();
                            Yini = event.getY();
                            break;
                        case MotionEvent.ACTION_MOVE:

                            break;
                        case MotionEvent.ACTION_UP:
                            float Xfin = event.getX(), Yfin = event.getY();
                            if(Math.abs(Xfin - Xini)>50){
                                if(navv.getVisibility() == View.VISIBLE){
                                    navv.setVisibility(View.INVISIBLE);
                                }else{
                                    navv.setVisibility(View.VISIBLE);
                                }

                            }
                            break;
                    }
                    return true;
                }
        );
    }


}
