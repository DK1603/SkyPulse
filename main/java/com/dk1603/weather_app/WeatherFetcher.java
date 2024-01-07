package com.dk1603.weather_app;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

// Class to get and parse the weather conditions from API using JSON objects

public class WeatherFetcher extends SwingWorker<String, String> {
    private final String location;
    private JLabel weatherField; // UI components that need to be updated
    private JLabel weatherDescLabel;
    private JLabel humidLabel;
    private JLabel windLabel;
    private JLabel weatherIcon;
    private String weatherIconId;

    public WeatherFetcher(String location, JLabel weatherField, JLabel weatherDescLabel, JLabel humidLabel, JLabel windLabel, JLabel weatherIcon) { //Constructor
        this.location = location;
        this.weatherField = weatherField;
        this.weatherDescLabel = weatherDescLabel;
        this.humidLabel = humidLabel;
        this.windLabel = windLabel;
        this.weatherIcon = weatherIcon;
    }
  
	@Override
	protected String doInBackground() {
		try {
			//openweathermap.com API configurations 
			String url = "http://api.openweathermap.org/data/2.5/weather?q=" + location
					+ "&appid=aba6ff9d6de967d5eac6fd79114693cc";
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() == 200) {
				InputStream responseBody = connection.getInputStream();
				String response = new String(responseBody.readAllBytes());
				responseBody.close();

				// Parse response using JSONObject
				JSONObject obj = new JSONObject(response);

				// Extract temperature in Kelvin and convert to Celsius
				double temperatureKelvin = obj.getJSONObject("main").getDouble("temp");
				double temperatureCelsius = temperatureKelvin - 273.15;

				// Extract weather description
				String weatherDescription = obj.getJSONArray("weather").getJSONObject(0).getString("description");
				weatherDescLabel.setText(weatherDescription);

				// Extract humidity
				double weatherHumidity = obj.getJSONObject("main").getDouble("humidity");
				humidLabel.setText("Humidity: " + weatherHumidity + "%");

				// Extract wind speed
				double windSpeed = obj.getJSONObject("wind").getDouble("speed");
				windLabel.setText("Wind Speed: " + windSpeed + " km/h");

				// Extract weather icon
				String weatherIconCode = obj.getJSONArray("weather").getJSONObject(0).getString("icon");
				weatherIconId = weatherIconCode;
				weatherIcon.setIcon(new javax.swing.JLabel() {
					private static final long serialVersionUID = 1L;

					@Override
					public javax.swing.Icon getIcon() {
						try {
							return new javax.swing.ImageIcon(new java.net.URL(
									"https://openweathermap.org/img/wn/" + weatherIconId + "@2x.png"));
						} catch (java.net.MalformedURLException e) {
						}
						return null;
					}
				}.getIcon());

				// Return the formatted temperature
				return String.format("%.2f °C", temperatureCelsius);
			} else {

				publish("HTTP error code: " + connection.getResponseCode() + "\n"+ "Such city does not exist!"); // Use publish to send error message
			
				return null;
			}
		} catch (IOException e) {

			publish("Failed to fetch weather data: " + e.getMessage()); // Use publish to send error message
			return null;
		}
	}

	protected void process(List<String> chunks) {
		// Check if chunks list contains exactly one error message
		if (chunks.size() == 1) {
			JOptionPane.showMessageDialog(null, chunks.get(0), "Error", JOptionPane.ERROR_MESSAGE);
			// After displaying the error message, cancel the SwingWorker task
			this.cancel(true);
		}
	}

	@Override
	protected void done() {
		if (!isCancelled()) {
			try {
				String temperature = get(); // This might be null if an error occurred
				if (temperature != null) {
					weatherField.setText(temperature);
					// Update other UI components if needed
				}
			} catch (InterruptedException | ExecutionException e) {
				// Exceptions thrown from doInBackground are caught here
				
				e.printStackTrace();
			}
		}
	}
}

   
