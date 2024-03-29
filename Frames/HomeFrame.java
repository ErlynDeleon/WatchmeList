package Frames;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame{
  JLabel label = new JLabel();

    //for navigation panel
    JPanel navigationPanel = new JPanel(null);
    ImageIcon addImageIcon = new ImageIcon("Frames\\pictures\\plus.png");
    JButton addButton = new CircleButton(addImageIcon);
    ImageIcon removeImageIcon = new ImageIcon("Frames\\pictures\\trash.png");
    JButton removeButton = new CircleButton(removeImageIcon);
    ImageIcon updateImageIcon = new ImageIcon("Frames\\pictures\\refresh.png");
    JButton updateButton = new CircleButton(updateImageIcon);
    JButton saveButton = new RoundButton("Save");
    JButton exitButton = new RoundButton("Continue");

    //for menu bar
    JPanel menuBar = new JPanel(null);
    ImageIcon searchImageIcon = new ImageIcon("Frames\\pictures\\search.png");
    JButton searchButton = new CircleButton(searchImageIcon);
    JTextField searchTextField =  new JTextField();
    ImageIcon logoImageIcon = new ImageIcon();

    //for main panel
    JPanel mainPanel = new JPanel(null);

  HomeFrame(){
        //navigation panel settings
        navigationPanel.setBackground(new Color(135, 133, 162));
        navigationPanel.setBounds(970, 0, 120, 700);

        //add button settings
        addButton.setBounds(32, 170, 50, 50); 
        navigationPanel.add(addButton); 

        //remove button settings
        removeButton.setBounds(32, 270, 50, 50);
        navigationPanel.add(removeButton);

        //update button settings
        updateButton.setBounds(32, 370, 50, 50);
        navigationPanel.add(updateButton);

        //save button settings
        saveButton.setBounds(5, 530, 105, 40);
        navigationPanel.add(saveButton);

        //continue button settings
        exitButton.setBounds(5, 580, 105, 40);
        navigationPanel.add(exitButton);

        //menu bar settings
        menuBar.setBackground(new Color(255, 199, 199));
        menuBar.setBounds(0, 0, 970, 60);

        //search text field settings
        searchTextField.setBounds(450, 10, 430, 40);
        menuBar.add(searchTextField);

        //search button settings
        searchButton.setBounds(900, 5, 50, 50);
        menuBar.add(searchButton);

        //main panel settings
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBounds(0, 60, 970, 660);

        //frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        //ImageIcon icon = new ImageIcon("");
        //setIconImage(icon.getImage());
        add(navigationPanel);
        add(menuBar);
        add(mainPanel);
  }
}
