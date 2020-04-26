package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import controller.PlaylistController;

public class Playlist extends AppCompatActivity {
    private TextView titleTxt, descriptionTxt,quantTxt;
    private ImageView img;
    private RecyclerView recycle;
    private PlaylistController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        quantTxt = findViewById(R.id.quantTxt);
        img = findViewById(R.id.img);
        recycle = findViewById(R.id.recycle);
        controller = new PlaylistController(this);
    }

    public TextView getTitleTxt() {
        return titleTxt;
    }

    public void setTitleTxt(TextView titleTxt) {
        this.titleTxt = titleTxt;
    }

    public TextView getDescriptionTxt() {
        return descriptionTxt;
    }

    public void setDescriptionTxt(TextView descriptionTxt) {
        this.descriptionTxt = descriptionTxt;
    }

    public TextView getQuantTxt() {
        return quantTxt;
    }

    public void setQuantTxt(TextView quantTxt) {
        this.quantTxt = quantTxt;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public RecyclerView getRecycle() {
        return recycle;
    }

    public void setRecycle(RecyclerView recycle) {
        this.recycle = recycle;
    }
}
