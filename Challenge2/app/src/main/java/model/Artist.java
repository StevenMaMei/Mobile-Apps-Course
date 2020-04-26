package model;

import java.io.Serializable;

public class Artist implements Serializable {

    private String id,name;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
