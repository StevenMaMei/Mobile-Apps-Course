package com.example.referenciaviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class TouchActivity extends AppCompatActivity {

    private TextView box,console;
    float Xini,Yini;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        box = findViewById(R.id.box);
        console = findViewById(R.id.console);

        box.setOnTouchListener(
                (v, event) ->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            console.setText("DOWN");
                            Xini = event.getX();
                            Yini = event.getY();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            box.setX(event.getX()+box.getX() - Xini);
                            box.setY(event.getY()+box.getY() - Yini);
                            console.setText("Move");
                            break;
                        case MotionEvent.ACTION_UP:
                            console.setText("UP");
                            break;
                    }
                    console.append("\nX: "+event.getX());
                    console.append("\nX: "+event.getY());
                    return true;
                }
        );
    }
}
