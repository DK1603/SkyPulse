package com.dk1603.weather_app;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Class to synchronize the user data 
public class AccountManager {
    private Map<String, User> users = new HashMap<>();
    private static final String USER_DATA_FILE = "users.txt";

    public AccountManager() {
        loadUsers(); // Load users from the file when the AccountManager is instantiated
    }
   
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        User newUser = new User(username, password);
        users.put(username, newUser);
        saveUsers(); // Save the new user to the file
        return true;
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
    public User getUser(String username) {
        return users.get(username);
    }
    
    // Methods to save and load users from the file
    public void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        File file = new File(USER_DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object readObject = ois.readObject();
                if (readObject instanceof Map) {
                    users = (Map<String, User>) readObject;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void addFavoriteCity(String username, String city) {
        User user = getUser(username);
        if (user != null) {
            user.addFavoriteCity(city);
            saveUsers(); // Save changes
        }
    }

    // Method to remove a city from a user's favorite list
    public void removeFavoriteCity(String username, String city) {
        User user = getUser(username);
        if (user != null) {
            user.removeFavoriteCity(city);
            saveUsers(); // Save changes
        }
    }

    // Method to get a list of favorite cities for a user
    public List<String> getFavoriteCities(String username) {
        User user = getUser(username);
        return user != null ? user.getFavoriteCities() : null;
    }
    
    
}


