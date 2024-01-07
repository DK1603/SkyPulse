package com.dk1603.weather_app;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToolBar;
import javax.swing.JLabel;

public class UI extends javax.swing.JFrame {
	
	// Class variables representing buttons, fields or instances 
	private static final long serialVersionUID = 1L;
	public String weatherIconId = "";
	private boolean initializing = true;
	private JButton favBtn;
	public JComboBox<String> comboBox;
	private boolean isFavorite = false;
	private AccountManager accountManager;
	private User currentUser;
	private String username;

	public JComboBox<String> getComboBox() { //constructor of comboBox
		return comboBox;
	}

	private void resetFavoriteButton() { // Method to make favBtn reset
		favBtn.setIcon(new ImageIcon(UI.class.getResource("/com/dk1603/weather_app/star1.png")));
	}

	public UI(String username, AccountManager accountManager) { //Constructor for UI objects
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		initComponents();

		this.username = username;
		this.accountManager = accountManager;
		setCurrentUser(username);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}

	// This method sets up the UI based on the current user's data
	private void setCurrentUser(String username) {
		this.currentUser = accountManager.getUser(username);
		resetFields();
		if (this.currentUser != null) {
			loadFavoriteCities(); // Load and display favorite cities for the user

		}
	}

	// Load favorite cities into the comboBox
	private void loadFavoriteCities() {
		// Temporarily remove the item listener
		ItemListener[] itemListeners = comboBox.getItemListeners();
		for (ItemListener listener : itemListeners) {
			comboBox.removeItemListener(listener);
		}

		comboBox.removeAllItems();
		// Add the cities from the user
		for (String city : currentUser.getFavoriteCities()) {
			comboBox.addItem(city);
		}

		// Re-add the item listener
		for (ItemListener listener : itemListeners) {
			comboBox.addItemListener(listener);
		}
		

	}

	// Method to reset other fields like LocationField, weather information, etc.
	private void resetFields() {
		LocationField.setText("");
		weatherField.setText("--");
		humidLabel.setText("--");
		windLabel.setText("--");
		comboBox.setSelectedItem("Favorite Cities");

	}

	
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() { // Method to initialize UI components

		kGradientPanel1 = new keeptoo.KGradientPanel();
		LocationLabel = new javax.swing.JLabel();
		WeatherLabel = new javax.swing.JLabel();
		GetWeatherBtn = new javax.swing.JButton();
		LocationField = new javax.swing.JTextField();
		weatherField = new javax.swing.JLabel();
		jPanel1 = new RoundedPanel(20);
		weatherDescLabel = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new RoundedPanel(20);
		humidLabel = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel3 = new RoundedPanel(20);
		windLabel = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPanel4 = new RoundedPanel(20, new Color(185, 180, 199));
		weatherIcon = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("SkyPulse");
		setBackground(new java.awt.Color(255, 153, 153));

		kGradientPanel1.setkEndColor(new java.awt.Color(53, 47, 68));
		kGradientPanel1.setkStartColor(new java.awt.Color(53, 47, 68));
		kGradientPanel1.setMaximumSize(new java.awt.Dimension(400, 641));
		kGradientPanel1.setMinimumSize(new java.awt.Dimension(400, 641));

		LocationLabel.setBackground(new java.awt.Color(255, 255, 255));
		LocationLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		LocationLabel.setForeground(new java.awt.Color(250, 240, 230));
		LocationLabel.setText("Location");
		LocationLabel.setToolTipText("Enter name of the City to look up the weather");

		WeatherLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		WeatherLabel.setForeground(new java.awt.Color(250, 240, 230));
		WeatherLabel.setText("Weather:");

		GetWeatherBtn.setBackground(new java.awt.Color(250, 240, 230));
		GetWeatherBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		GetWeatherBtn.setForeground(new Color(255, 255, 255));
		GetWeatherBtn.setText("Get Weather");
		GetWeatherBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		GetWeatherBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				GetWeatherBtnActionPerformed(evt);
				performWeatherAction();
			}
		});
		// Method to make get Weather button be responsive, so User knows when it is actually pressed 
		GetWeatherBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GetWeatherBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Thicker border when
																								// pressed
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				GetWeatherBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)); // Original
																													// border
			}
		});
		GetWeatherBtn.setContentAreaFilled(true);

		LocationField.setBackground(new java.awt.Color(92, 84, 112));
		LocationField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		LocationField.setForeground(new java.awt.Color(250, 240, 230));
		LocationField.setToolTipText("search");
		LocationField.setActionCommand("<Not Set>");
		LocationField.setBorder(null);
		LocationField.setCaretColor(new java.awt.Color(255, 51, 102));
		LocationField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				LocationFieldKeyPressed(evt);
			}
		});

		weatherField.setFont(new Font("Dialog", Font.PLAIN, 45)); // NOI18N
		weatherField.setForeground(new java.awt.Color(250, 240, 230));
		weatherField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		weatherField.setText("--");

		jPanel1.setBackground(new java.awt.Color(53, 47, 68));

		weatherDescLabel.setBackground(new java.awt.Color(92, 84, 112));
		weatherDescLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		weatherDescLabel.setForeground(new java.awt.Color(250, 240, 230));
		weatherDescLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		weatherDescLabel.setText("---");

		jLabel1.setBackground(new java.awt.Color(255, 255, 255));
		jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(185, 180, 199));
		jLabel1.setText("Weather Description:");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(weatherDescLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0,
										Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(weatherDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		jPanel2.setBackground(new java.awt.Color(53, 47, 68));

		humidLabel.setBackground(new java.awt.Color(92, 84, 112));
		humidLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		humidLabel.setForeground(new java.awt.Color(250, 240, 230));
		humidLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		humidLabel.setText("--");

		jLabel3.setBackground(new java.awt.Color(255, 255, 255));
		jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(185, 180, 199));
		jLabel3.setText("Humidity:");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(humidLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel3).addGap(0, 0,
										Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(humidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		jPanel3.setBackground(new java.awt.Color(53, 47, 68));

		windLabel.setBackground(new java.awt.Color(92, 84, 112));
		windLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		windLabel.setForeground(new java.awt.Color(250, 240, 230));
		windLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		windLabel.setText("--");

		jLabel2.setBackground(new java.awt.Color(255, 255, 255));
		jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(185, 180, 199));
		jLabel2.setText("Wind Speed:");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel2)
								.addComponent(windLabel, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel2)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(windLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBackground(new java.awt.Color(53, 47, 68));

		weatherIcon.setBackground(new java.awt.Color(185, 180, 199));
		weatherIcon.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		weatherIcon.setForeground(new java.awt.Color(255, 255, 255));
		weatherIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		weatherIcon.setIcon(new javax.swing.JLabel() {
			private static final long serialVersionUID = 1L;

			public javax.swing.Icon getIcon() {
				try {
					return new javax.swing.ImageIcon(
							new java.net.URL("https://openweathermap.org/img/wn/" + weatherIconId + "@2x.png"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup()
						.addGap(12).addComponent(weatherIcon, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(weatherIcon,
						GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)));
		jPanel4.setLayout(jPanel4Layout);

		favBtn = new JButton("");
		favBtn.setOpaque(false); // Make the button non-opaque
		favBtn.setContentAreaFilled(false); 
		favBtn.setBorderPainted(false); // border
		favBtn.setForeground(new Color(255, 212, 120)); 
		favBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		favBtn.setIcon(new ImageIcon(UI.class.getResource("/com/dk1603/weather_app/star1.png")));
		
		
		
		// Adding comboBox to store the favorite cities
		comboBox = new JComboBox<>();
		comboBox.setRenderer(new CustomComboBoxRenderer("Favorite Cities"));

		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (comboBox.getSelectedItem() == null) {
					comboBox.setPopupVisible(true);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				comboBox.setSelectedItem(null);
			}

		});

		// Add some sample cities for debugging purposes
		comboBox.addItem("New York");
		// comboBox.addItem("Los Angeles");
		comboBox.addItem("Tashkent");
		// comboBox.addItem("Moscow");
		comboBox.addItem("Seoul");
		// comboBox.addItem("Suwon");

		comboBox.setSelectedItem(null);
		initializing = false;
		
		// Method to update the favBtn and invoke "GetWeather" on the selected city
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (!initializing && e.getStateChange() == ItemEvent.SELECTED) {
					String selectedCity = (String) comboBox.getSelectedItem();
					if (selectedCity != null && !selectedCity.equals("Favorite Cities")) {
						LocationField.setText(selectedCity);
						GetWeather();
						updateFavoriteButton(selectedCity);

					}
				}
			}
		});

		favBtn.addActionListener(new ActionListener() {

			@Override
			// Adding cities if they are not yet in the comboBox
			public void actionPerformed(ActionEvent e) {
				String currentCity = LocationField.getText().trim();
				if (!currentCity.isEmpty()) {
					if (isFavorite) {
						// If currently a favorite, change to not favorite
						
						isFavorite = false;
						comboBox.removeItem(currentCity);
					} else {
						// If currently not a favorite, change to favorite
						
						isFavorite = true;
						// Add city to comboBox if it's not already there
						if (!isCityInComboBox(currentCity, comboBox)) {
							comboBox.addItem(currentCity);
						}
					}
					resetFavoriteButtonIcon(isFavorite);
				}
			}

			// This method updates the icon based on the favorite status
			private void resetFavoriteButtonIcon(boolean isFavorite) {
				if (isFavorite) {
					favBtn.setIcon(new ImageIcon(UI.class.getResource("/com/dk1603/weather_app/star2.png")));
				} else {
					favBtn.setIcon(new ImageIcon(UI.class.getResource("/com/dk1603/weather_app/star1.png")));
				}
			}

		});

		// Label to represent the current date
		JLabel dateLabel = new JLabel();
		dateLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		dateLabel.setForeground(Color.WHITE);

		// Format the current date
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, EEE");
		String formattedDate = currentDate.format(formatter);

		// Set the formatted date as the text for the dateLabel
		dateLabel.setText(formattedDate);

		javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
		kGradientPanel1Layout.setHorizontalGroup(kGradientPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(kGradientPanel1Layout.createSequentialGroup().addGroup(kGradientPanel1Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(kGradientPanel1Layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 619,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(kGradientPanel1Layout.createSequentialGroup()
												.addGroup(kGradientPanel1Layout.createParallelGroup(Alignment.TRAILING)
														.addGroup(kGradientPanel1Layout.createSequentialGroup()
																.addGroup(kGradientPanel1Layout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(WeatherLabel).addComponent(
																				dateLabel, GroupLayout.PREFERRED_SIZE,
																				114, GroupLayout.PREFERRED_SIZE))
																.addGap(40)
																.addComponent(LocationField, GroupLayout.PREFERRED_SIZE,
																		278, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(kGradientPanel1Layout
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(kGradientPanel1Layout
																				.createSequentialGroup()
																				.addComponent(favBtn,
																						GroupLayout.PREFERRED_SIZE, 37,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(GetWeatherBtn,
																						GroupLayout.PREFERRED_SIZE, 116,
																						GroupLayout.PREFERRED_SIZE))
																		.addComponent(comboBox,
																				GroupLayout.PREFERRED_SIZE, 130,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(kGradientPanel1Layout.createSequentialGroup()
																.addGap(6)
																.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 348,
																		Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(weatherField, GroupLayout.PREFERRED_SIZE,
																		247, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGap(20))))
						.addGroup(Alignment.TRAILING,
								kGradientPanel1Layout.createSequentialGroup().addGap(14).addComponent(jPanel2,
										GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING,
								kGradientPanel1Layout.createSequentialGroup().addGap(14).addComponent(jPanel3,
										GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
						.addGroup(
								kGradientPanel1Layout.createSequentialGroup().addGap(264).addComponent(LocationLabel)))
						.addContainerGap()));
		kGradientPanel1Layout.setVerticalGroup(kGradientPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(kGradientPanel1Layout.createSequentialGroup().addContainerGap().addComponent(LocationLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(kGradientPanel1Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(favBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(GetWeatherBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(kGradientPanel1Layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dateLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(LocationField, Alignment.TRAILING)))
						.addGroup(kGradientPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(kGradientPanel1Layout.createSequentialGroup().addGap(26)
										.addComponent(WeatherLabel))
								.addGroup(kGradientPanel1Layout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(comboBox,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(kGradientPanel1Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE).addComponent(
										weatherField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(13)));
		kGradientPanel1.setLayout(kGradientPanel1Layout);

		toolBar = new JToolBar();
		toolBar.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		toolBar.setFloatable(false);
		toolBar.setForeground(Color.WHITE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(kGradientPanel1, GroupLayout.DEFAULT_SIZE, 639,
								Short.MAX_VALUE)
						.addGroup(Alignment.LEADING,
								layout.createSequentialGroup().addGap(6)
										.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(kGradientPanel1, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)));
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				handleWindowClosing();
			}
		});

//////////////////////////////////////		Info button initialization 
		InfoBtn = new JButton("About");
		InfoBtn.setForeground(Color.BLACK);
		InfoBtn.setBackground(Color.BLACK);
		toolBar.add(InfoBtn);
		InfoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAuthorInfo();
			}
		});

////////////////////////////////////////     Logout button handling 

		logOutBtn = new JButton("LogOut");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LogoutHandler logoutHandler = new LogoutHandler(accountManager, UI.this, username);
				logoutHandler.handleLogout();
			}
		});
		toolBar.add(logOutBtn);

		getContentPane().setLayout(layout);
		LocationField.setText("");

		pack();
	}// </editor-fold>//GEN-END:initComponents

////////////////////////////////////////////////////////////////////////////  
//Info button content
	private void showAuthorInfo() {
		String authorInfo = "<html><body>" + "<h2>SkyPulse</h2>" + "<p>Author: Daler Kim</p>"
				+ "<p>Description: An application to check the current weather conditions of any city.</p>"
				+ "<p>Contact: dalerk2003@gmail.com</p>" + "<p>© 2023 Daler Kim</p>" + "</body></html>";

		JOptionPane.showMessageDialog(this, authorInfo, "About the App", JOptionPane.INFORMATION_MESSAGE);
	}

////////////////////////////////////////////////////////////////////////////
// Window closing handling
	private void handleWindowClosing() {
		int choice = JOptionPane.showConfirmDialog(this, "Do you want to save changes before exiting?", "Confirm Exit",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (choice == JOptionPane.YES_OPTION) {
			LogoutHandler logoutHandler = new LogoutHandler(accountManager, UI.this, username);
			logoutHandler.saveFavorites();
			// Call the method to save favorites and handle logout
			System.exit(0); // Exit the application after saving
		} else if (choice == JOptionPane.NO_OPTION) {
			System.exit(0); // Exit the application without saving
		}
		// If the choice is CANCEL_OPTION or closed dialog, do nothing
	}

////////////////////////////////////////////////////////////////////////////  
	// Methods to perform the weather actions by creating an instance of class "WeatherFetcher"
	
	private void GetWeather() {
		String location = LocationField.getText();
		if (!location.isEmpty()) {
			WeatherFetcher weatherFetcher = new WeatherFetcher(location, weatherField, weatherDescLabel, humidLabel,
					windLabel, weatherIcon);
			weatherFetcher.execute();
		}
	}

	private void GetWeatherBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_GetWeatherBtnActionPerformed
		GetWeather();
	}// GEN-LAST:event_GetWeatherBtnActionPerformed

	private void LocationFieldKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_LocationFieldKeyPressed
		// TODO add your handling code here:
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

			performWeatherAction();
		}
	}// GEN-LAST:event_LocationFieldKeyPressed

	private void performWeatherAction() {
		// GetWeather();
		String currentCity = LocationField.getText().trim();
		if (!isCityInComboBox(currentCity, comboBox)) {
			GetWeather();

			resetFavoriteButton();
		}
	}
/////////////////////////////////////////////////////////////////////  Extra methods to check and reset components
	
	private void updateFavoriteButton(String selectedCity) {
		if (isCityInComboBox(selectedCity, comboBox)) {
			favBtn.setIcon(new ImageIcon(UI.class.getResource("/com/dk1603/weather_app/star2.png"))); // Set to favorite
																										// icon
			isFavorite = true;
		} else {
			favBtn.setIcon(new ImageIcon(UI.class.getResource("/com/dk1603/weather_app/star1.png"))); // Set to
																										// non-favorite
																										// icon
			isFavorite = false;
		}
	}

	// Function to check if a city is already in the comboBox
	private boolean isCityInComboBox(String city, JComboBox<String> comboBox) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (city.equalsIgnoreCase(comboBox.getItemAt(i))) {
				return true;
			}
		}
		return false;
	}
	//////////////////////////////////////////////////////

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				UI ui = new UI(null, null);
				ui.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton GetWeatherBtn;
	private javax.swing.JTextField LocationField;
	private javax.swing.JLabel LocationLabel;
	private javax.swing.JLabel WeatherLabel;
	private javax.swing.JLabel humidLabel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private keeptoo.KGradientPanel kGradientPanel1;
	private javax.swing.JLabel weatherDescLabel;
	private javax.swing.JLabel weatherField;
	private javax.swing.JLabel weatherIcon;
	private javax.swing.JLabel windLabel;
	private JToolBar toolBar;
	private JButton InfoBtn;
	private JButton logOutBtn;
	// End of variables declaration//GEN-END:variables
}
