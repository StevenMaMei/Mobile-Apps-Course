package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import controller.SongDetailController;

public class SongDetail extends AppCompatActivity {
    private ImageView imgDetailSong;
    private TextView songNameDetailTxt, artistNameDetailTxt, albumNameDetailTxt,songDurationDetailTxt;
    private Button listenSongBtn;
    private SongDetailController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        imgDetailSong = findViewById(R.id.imgDetailSong);
        songNameDetailTxt = findViewById(R.id.songNameDetailTxt);
        artistNameDetailTxt = findViewById(R.id.artistNameDetailTxt);
        albumNameDetailTxt = findViewById(R.id.albumNameDetailTxt);
        songDurationDetailTxt = findViewById(R.id.songDurationDetailTxt);
        listenSongBtn = findViewById(R.id.listenSongBtn);

        controller = new SongDetailController(this);

    }

    public ImageView getImgDetailSong() {
        return imgDetailSong;
    }

    public void setImgDetailSong(ImageView imgDetailSong) {
        this.imgDetailSong = imgDetailSong;
    }

    public TextView getSongNameDetailTxt() {
        return songNameDetailTxt;
    }

    public void setSongNameDetailTxt(TextView songNameDetailTxt) {
        this.songNameDetailTxt = songNameDetailTxt;
    }

    public TextView getArtistNameDetailTxt() {
        return artistNameDetailTxt;
    }

    public void setArtistNameDetailTxt(TextView artistNameDetailTxt) {
        this.artistNameDetailTxt = artistNameDetailTxt;
    }

    public TextView getAlbumNameDetailTxt() {
        return albumNameDetailTxt;
    }

    public void setAlbumNameDetailTxt(TextView albumNameDetailTxt) {
        this.albumNameDetailTxt = albumNameDetailTxt;
    }

    public TextView getSongDurationDetailTxt() {
        return songDurationDetailTxt;
    }

    public void setSongDurationDetailTxt(TextView songDurationDetailTxt) {
        this.songDurationDetailTxt = songDurationDetailTxt;
    }

    public Button getListenSongBtn() {
        return listenSongBtn;
    }

    public void setListenSongBtn(Button listenSongBtn) {
        this.listenSongBtn = listenSongBtn;
    }
}
