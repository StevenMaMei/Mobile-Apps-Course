package controller;

import com.example.myapplication.PlaySong;

public class PlaySongController {

    private PlaySong activity;

    public PlaySongController(PlaySong activity) {
        this.activity = activity;

        String url = activity.getIntent().getExtras().getString("url");
        activity.runOnUiThread(
                ()->{
                    activity.getWebView().loadUrl(url);
                    activity.finish();
                }
        );

    }
}
