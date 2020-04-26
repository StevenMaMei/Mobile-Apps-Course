package controller;

import android.view.View;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.gson.Gson;

import adapter.PlaylistCardAdapter;
import model.PlaylistCard;
import model.PlaylistSearchResult;
import util.Constants;
import util.HTTPSWebUtilDomi;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {
    private MainActivity activity;
    private HTTPSWebUtilDomi httpsUtil;
    private PlaylistCardAdapter adapter;
    public MainController(MainActivity activity) {
        this.activity = activity;
        activity.getSearchBtn().setOnClickListener(this);
        httpsUtil = new HTTPSWebUtilDomi();
        httpsUtil.setListener(this);

        adapter = new PlaylistCardAdapter();
        activity.getPlaylistTable().setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.searchBtn:
                String url = Constants.SEARCH_PLAYLISTS_URL +activity.getSearchText().getText().toString();
                new Thread(
                        ()->{
                            httpsUtil.GETrequest(Constants.SEARCH_CALLBACK,url);
                        }
                ).start();
                break;
        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                adapter.clearList();
                Gson gson = new Gson();
                PlaylistSearchResult result = gson.fromJson(response, PlaylistSearchResult.class);
                for(PlaylistCard p : result.getData()){
                    activity.runOnUiThread(
                            ()->{
                                adapter.addPlaylist(p);
                            }
                    );
                }
                break;
        }
    }
}
