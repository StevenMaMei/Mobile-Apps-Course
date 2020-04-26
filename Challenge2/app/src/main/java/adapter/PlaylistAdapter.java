package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.SongDetail;

import java.util.ArrayList;
import java.util.Date;

import model.SongCardM;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    private ArrayList<SongCardM> songs;

    public PlaylistAdapter(ArrayList<SongCardM> songs) {
        this.songs = songs;
    }


    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.activity_song_card, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHolder holder, int position) {
        SongCardM song = songs.get(position);

        TextView songName = holder.songNameTxt;
        TextView songArtist = holder.songArtistTxt;
        TextView songDate = holder.songDatetxt;
        ImageView img = holder.img;

        songName.setText(song.getTitle());
        songArtist.setText(song.getArtist().getName());
        songDate.setText(new Date(Long.parseLong(song.getTime_add())).toString());
        if(song.getAlbum()!= null)
        Glide.with(holder.itemView).load(
                song.getAlbum().getCover_small()
        ).centerCrop().into(img);
        holder.itemView.setOnClickListener(
                (v)->{
                    Intent i = new Intent(holder.itemView.getContext(), SongDetail.class);
                    i.putExtra("song",song);
                    holder.itemView.getContext().startActivity(i);
                }
        );


    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView songNameTxt, songArtistTxt,songDatetxt;
        public ImageView img;

        public ViewHolder(View itemView) {

            super(itemView);

            songNameTxt = (TextView) itemView.findViewById(R.id.songNameTxt);
            songArtistTxt = (TextView) itemView.findViewById(R.id.songArtistTxt);
            songDatetxt = itemView.findViewById(R.id.songDateTxt);
            img = itemView.findViewById(R.id.img);


        }
    }

    public ArrayList<SongCardM> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongCardM> songs) {
        this.songs = songs;
    }
}
