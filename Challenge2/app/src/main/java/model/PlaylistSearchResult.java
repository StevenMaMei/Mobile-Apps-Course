package model;

public class PlaylistSearchResult {
    private PlaylistCard data[];

    public PlaylistSearchResult(PlaylistCard[] data) {
        this.data = data;
    }

    public PlaylistSearchResult() {
    }

    public PlaylistCard[] getData() {
        return data;
    }

    public void setData(PlaylistCard[] data) {
        this.data = data;
    }
}
