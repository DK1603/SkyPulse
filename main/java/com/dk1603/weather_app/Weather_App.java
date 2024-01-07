
package com.dk1603.weather_app;


public class Weather_App extends javax.swing.JFrame {
	
  
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	//create and instance of accountManager and a login frame object
	            AccountManager accountManager = new AccountManager();
	            LoginFrame loginFrame = new LoginFrame(accountManager);
	            loginFrame.setVisible(true);
	        }
	    });
	}
          
}
