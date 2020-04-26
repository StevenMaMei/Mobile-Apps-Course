package controller;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.myapplication.PlaySong;
import com.example.myapplication.SongDetail;

import model.SongCardM;

public class SongDetailController {
    private SongDetail activity;

    public SongDetailController(SongDetail activity) {
        this.activity = activity;

        SongCardM song = (SongCardM) activity.getIntent().getExtras().getSerializable("song");

        activity.runOnUiThread(
                ()->{
                    activity.getAlbumNameDetailTxt().setText(song.getAlbum().getTitle());
                    activity.getArtistNameDetailTxt().setText(song.getArtist().getName());
                    activity.getSongDurationDetailTxt().setText(song.getDuration());
                    activity.getSongNameDetailTxt().setText(song.getTitle());

                    Glide.with(activity).load(
                            song.getAlbum().getCover_medium()
                    ).centerCrop().into(activity.getImgDetailSong());

                }
        );
        activity.getListenSongBtn().setOnClickListener(
                v -> {
                    try {
                        String uri = "deezer://www.deezer.com/track/"+song.getLink();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        activity.startActivity(intent);
                    } catch (Exception e) {
                        Intent intent = new Intent(activity, PlaySong.class);
                        intent.putExtra("url",song.getLink());
                        activity.startActivity(intent);
                    }
                }
        );

    }
}
