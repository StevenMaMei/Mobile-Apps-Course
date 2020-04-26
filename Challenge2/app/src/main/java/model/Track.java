package model;

import java.util.ArrayList;

public class Track {
    private ArrayList<SongCardM> data;

    public Track() {
    }

    public Track(ArrayList<SongCardM> data) {
        this.data = data;
    }

    public ArrayList<SongCardM> getData() {
        return data;
    }

    public void setData(ArrayList<SongCardM> data) {
        this.data = data;
    }
}
