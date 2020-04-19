package model;

public class Playlist {
    private String id,title,picture_small;
    private String nb_tracks;
    private User user;
    public Playlist() {
    }

    public Playlist(String id, String title, String picture_small, String nb_tracks, User user) {
        this.id = id;
        this.title = title;
        this.picture_small = picture_small;
        this.nb_tracks = nb_tracks;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }
}
