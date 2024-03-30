package Frames;

import javax.swing.*;
import java.awt.*;

public class SaveButton extends JPanel {
    public SaveButton() {
        setLayout(new BorderLayout());
        displaySaveResult(); // Call a method to handle the save operation
    }

    private void displaySaveResult() {
        // Create a label with the message
        JLabel messageLabel;
        try {
            // For demonstration purposes, let's simulate a successful save
            
            messageLabel = new JLabel("Watchlist data saved successfully.");
        } catch (Exception ex) {
            // If an error occurs during the save operation, display error message
            messageLabel = new JLabel("Failed to save watchlist data: " + ex.getMessage());
            messageLabel.setForeground(Color.RED); // Set color to red for error message
        }
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the label to the panel
        add(messageLabel, BorderLayout.CENTER);
    }
}
