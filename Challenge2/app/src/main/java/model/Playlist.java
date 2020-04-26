package model;

public class Playlist {
    private String id,title,description, nb_tracks,picture_medium;
    private Track tracks;

    public Playlist(String id, String title, String description, String nb_tracks, String picture_medium, Track tracks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.nb_tracks = nb_tracks;
        this.picture_medium = picture_medium;
        this.tracks = tracks;
    }

    public Playlist() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(String nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public Track getTracks() {
        return tracks;
    }

    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }
}
