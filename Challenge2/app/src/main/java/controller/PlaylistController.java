package controller;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.myapplication.Playlist;
import com.google.gson.Gson;

import java.util.ArrayList;

import adapter.PlaylistAdapter;
import model.PlaylistCard;
import model.PlaylistSearchResult;
import model.SongCardM;
import util.Constants;
import util.HTTPSWebUtilDomi;

public class PlaylistController implements HTTPSWebUtilDomi.OnResponseListener{
    private Playlist activity;
    private HTTPSWebUtilDomi httpsUtil;
    private PlaylistAdapter adapter;

    public PlaylistController(Playlist activity) {
        this.activity = activity;

        httpsUtil = new HTTPSWebUtilDomi();
        httpsUtil.setListener(this);
        adapter = new PlaylistAdapter(new ArrayList<>());
        activity.getRecycle().setAdapter(adapter);
        activity.getRecycle().setLayoutManager(new LinearLayoutManager(activity));
        String url = Constants.SEARCH_SPECIFIC_PLAYLIST_URL+ this.activity.getIntent().getExtras().getString("id");
        new Thread(
                ()->{
                    httpsUtil.GETrequest(Constants.SEARCH_CALLBACK,url);
                }
        ).start();

    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                model.Playlist result = gson.fromJson(response, model.Playlist.class);


                activity.runOnUiThread(
                        ()->{
                            activity.getTitleTxt().setText(result.getTitle());
                            activity.getDescriptionTxt().setText(result.getDescription());
                            activity.getQuantTxt().setText(result.getNb_tracks());
                            adapter.getSongs().addAll(result.getTracks().getData());
                            adapter.notifyDataSetChanged();
                            Glide.with(activity).load(
                                    result.getPicture_medium()
                            ).centerCrop().into(activity.getImg());
                        }

                );
                break;
        }
    }
}
