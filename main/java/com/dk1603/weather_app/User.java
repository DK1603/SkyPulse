package com.dk1603.weather_app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Class to handle user data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private List<String> favoriteCities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.favoriteCities = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public List<String> getFavoriteCities() {
        return new ArrayList<>(favoriteCities);
    }

    public void addFavoriteCity(String city) {
        if (!favoriteCities.contains(city)) {
            favoriteCities.add(city);
        }
    }

    public void removeFavoriteCity(String city) {
        favoriteCities.remove(city);
    }
}

