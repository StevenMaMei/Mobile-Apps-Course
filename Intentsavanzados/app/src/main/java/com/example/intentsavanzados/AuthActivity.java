package com.example.intentsavanzados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.UUID;

import javax.xml.transform.Result;

public class AuthActivity extends AppCompatActivity {
    private EditText nameUser;
    private Button authUser;
    private TextView idUser;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        nameUser = findViewById(R.id.nameUser);
        authUser = findViewById(R.id.authUser);
        idUser = findViewById(R.id.idUser);



        Serializable serializable = getIntent().getExtras().getSerializable("user");


        if(serializable == null){
            idUser.setText(UUID.randomUUID().toString());
        }else{
            user = (User) serializable;
            idUser.setText(user.getId());
            nameUser.setText(user.getName());
        }
        authUser.setOnClickListener(

                (v) ->{
                    User user = new User(idUser.getText().toString(), nameUser.getText().toString());
                    Intent i = new Intent();
                    i.putExtra("user",user);
                    setResult(RESULT_OK,i);
                    finish();
                }
        );
    }
}
