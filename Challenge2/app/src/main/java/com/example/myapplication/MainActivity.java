package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import controller.MainController;

public class MainActivity extends AppCompatActivity {
    private EditText searchText;
    private ImageButton searchBtn;
    private ListView playlistTable;
    private MainController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchText = findViewById(R.id.searchText);
        searchBtn = findViewById(R.id.searchBtn);
        playlistTable = findViewById(R.id.playlistTable);

        controller = new MainController(this);

    }


    public EditText getSearchText() {
        return searchText;
    }

    public ImageButton getSearchBtn() {
        return searchBtn;
    }

    public ListView getPlaylistTable() {
        return playlistTable;
    }
}
