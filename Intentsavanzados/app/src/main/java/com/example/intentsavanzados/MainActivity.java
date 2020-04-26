package com.example.intentsavanzados;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainTitle;
    private Button authButton;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTitle = findViewById(R.id.mainTitle);
        authButton = findViewById(R.id.authButton);

        authButton.setOnClickListener(
                (v) ->{
                    Intent in = new Intent(this,AuthActivity.class
                    Intent i = new Intent(this, AuthActivity.class);
                    i.putExtra("user", user);
                    startActivityForResult(i,11);
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 11 && resultCode == RESULT_OK){
            user= (User) data.getExtras().getSerializable("user");
            mainTitle.setText("Bienvenido "+ user.getName());
            authButton.setText("Editar");
        }
    }
}
