package com.example.fragmentsejemplo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioA extends Fragment implements View.OnClickListener {

    private EditText nameField, cityField, careerField;
    private TextView codeField, phoneField, emailField;
    private OnDataSubmited listener;
    public FormularioA() {
        // Required empty public constructor
    }
    public void setListener(OnDataSubmited listener){
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // quitamos el retorno y colocamos View
        View view =inflater.inflate(R.layout.fragment_formulario, container, false);
        nameField = view.findViewById(R.id.nameField);
        cityField = view.findViewById(R.id.cityField);
        careerField = view.findViewById(R.id.careerField);
        codeField = view.findViewById(R.id.nameField);
        phoneField = view.findViewById(R.id.cityField);
        emailField = view.findViewById(R.id.careerField);

        view.findViewById(R.id.nextButton).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nextButton:
                if(listener != null){
                    listener.onData(this,nameField.getText().toString(),cityField.getText().toString(),careerField.getText().toString());
                }
                break;
        }
    }
}
