package com.example.fragmentsejemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnDataSubmited{
    private TextView mainTitle;
    private LinearLayout fragmentContainer;
    private ProgressBar progrssBar;

    private Fragment formularioA, formularioB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTitle = findViewById(R.id.mainTitle);
        fragmentContainer = findViewById(R.id.fragmentContainer);
        progrssBar = findViewById(R.id.progressBar);
        progrssBar.setMax(2);
        progrssBar.setProgress(0);
        formularioA = new FormularioA();
        formularioB = new FormularioB();
        ((FormularioA) formularioA).setListener(this);
        ((FormularioB) formularioB).setListener(this);
        loadFragment(formularioA);
    }

    public void loadFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        //el transaction es poner un fragmento en la actividad
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentContainer,fragment);
        transaction.commit();
    }

    @Override
    public void onData(Fragment fragment, String... args) {
        if(fragment.equals(formularioA)){

            loadFragment(formularioB);
            ((FormularioB) formularioB).setDto(new DTOUser(args[0],args[1],args[2]));
            progrssBar.setProgress(1);

        }else if(fragment.equals(formularioB)){
            progrssBar.setProgress(2);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(formularioB);
            transaction.commit();
        }
    }
}
