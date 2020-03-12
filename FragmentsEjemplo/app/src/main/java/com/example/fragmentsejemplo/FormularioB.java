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
public class FormularioB extends Fragment implements View.OnClickListener {
    private TextView nameField, cityField, careerField;
    private OnDataSubmited listener;
    private DTOUser dto;
    public void setCityField(TextView cityField) {
        this.cityField = cityField;
    }

    public void setInfo(DTOUser U){

        nameField.setText(U.name);
        cityField.setText(U.city);
        careerField.setText(U.career);

    }

    public void setCareerField(TextView careerField) {
        this.careerField = careerField;
    }

    public FormularioB() {

    }
    public void setListener(OnDataSubmited listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_formulario_b, container, false);
        nameField = view.findViewById(R.id.nameField);
        cityField = view.findViewById(R.id.cityField);
        careerField = view.findViewById(R.id.careerField);
        setInfo(dto);
        view.findViewById(R.id.nextButton).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextButton:
                if(listener != null){
                    listener.onData(this);

                }
                break;
        }
    }

    public void setNameField(TextView nameField) {
        this.nameField = nameField;
    }

    public void setDto(DTOUser dto) {
        this.dto = dto;
    }
}
