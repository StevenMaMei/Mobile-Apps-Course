package model;

public class PlaylistSearchResult {
    private Playlist data[];

    public PlaylistSearchResult(Playlist[] data) {
        this.data = data;
    }

    public PlaylistSearchResult() {
    }

    public Playlist[] getData() {
        return data;
    }

    public void setData(Playlist[] data) {
        this.data = data;
    }
}
