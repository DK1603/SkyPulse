package com.dk1603.weather_app;

import javax.swing.JOptionPane;

// Class to handle the logout and saving the data to the user's account
public class LogoutHandler {
    private AccountManager accountManager;
    private UI ui;
    private String username;

    public LogoutHandler(AccountManager accountManager, UI ui, String username) {
        this.accountManager = accountManager;
        this.ui = ui;
        this.username = username;
    }

    public void handleLogout() {
        int response = JOptionPane.showConfirmDialog(ui, "Are you sure you want to log out?", "Confirm Logout",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            saveFavorites();
            ui.dispose(); // Close the current window
            // Open the login frame
            LoginFrame loginFrame = new LoginFrame(accountManager);
            loginFrame.setVisible(true);
        }
    }

    public void saveFavorites() {
        User currentUser = accountManager.getUser(username);
        if (currentUser != null) {
            // Clear existing favorites
            currentUser.getFavoriteCities().clear();

            // Add all cities from comboBox to the user's favorites
            for (int i = 0; i < ui.getComboBox().getItemCount(); i++) {
                String city = ui.getComboBox().getItemAt(i);
                currentUser.addFavoriteCity(city);
            }

            // Save the updated user data
            accountManager.saveUsers();
        }
    }
}
