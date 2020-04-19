package adapter;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.PlaylistCard;
import com.example.myapplication.R;

import java.util.ArrayList;

import model.Playlist;

public class PlaylistAdapter extends BaseAdapter {
    private ArrayList<Playlist> playlists;

    public PlaylistAdapter() {
        this.playlists = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return playlists.size();
    }

    @Override
    public Object getItem(int position) {
        return playlists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void addPlaylist(Playlist p){
        playlists.add(p);
        //el notify es como un observer ya implementado que le hace saber que se añadieron datos
        notifyDataSetChanged();
    }
    public void clearList(){
        playlists.clear();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View card = inflater.inflate(R.layout.activity_playlist_card, null,false);

        TextView name = card.findViewById(R.id.name);
        TextView username = card.findViewById(R.id.userName);
        TextView size = card.findViewById(R.id.size);
        ImageView img = card.findViewById(R.id.image);

        name.setText(playlists.get(position).getTitle());
        username.setText(playlists.get(position).getUser().getName());
        size.setText(playlists.get(position).getNb_tracks());
        Glide.with(card).load(
                playlists.get(position).getPicture_small()
        ).centerCrop().into(img);

        card.setOnClickListener(
                (v) ->{
                    Log.e("jejej","jjejje");
                }
        );
        return card;
    }
}
