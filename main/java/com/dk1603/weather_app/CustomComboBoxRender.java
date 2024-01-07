package com.dk1603.weather_app;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

	// GUI components of comboBox from UI class
class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {
	private static final long serialVersionUID = 1L;
    private String defaultText;

    public CustomComboBoxRenderer(String defaultText) {
        this.defaultText = defaultText;
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value == null) {
            setText(defaultText);
        } else {
            setText(value.toString());
        }

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}

