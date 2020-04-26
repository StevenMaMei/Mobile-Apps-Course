package model;

import java.io.Serializable;

public class SongCardM implements Serializable {
    private String id, title,time_add,duration,link;
    private Artist artist;
    private Album album;

    public SongCardM(String id, String title, String time_add, String duration, String link, Artist artist, Album album) {
        this.id = id;
        this.title = title;
        this.time_add = time_add;
        this.duration = duration;
        this.link = link;
        this.artist = artist;
        this.album = album;
    }

    public SongCardM() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime_add() {
        return time_add;
    }

    public void setTime_add(String time_add) {
        this.time_add = time_add;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
