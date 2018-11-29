package com.ibagroup.DTO;

import java.util.List;

/**
 * @author bulbum
 */
public class Travel {
    private Long id;
    private String username;
    private List<String> places;

    public Travel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPlaces() {
        return places;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }
}
