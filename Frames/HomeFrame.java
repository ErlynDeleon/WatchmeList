package Frames;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame implements ActionListener{
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

        //navigation panel components
        //add button settings
        addButton.setBounds(32, 170, 50, 50);
        addButton.addActionListener(this);
        navigationPanel.add(addButton); 

        //remove button settings
        removeButton.setBounds(32, 270, 50, 50);
        removeButton.addActionListener(this);
        navigationPanel.add(removeButton);

        //update button settings
        updateButton.setBounds(32, 370, 50, 50);
        updateButton.addActionListener(this);
        navigationPanel.add(updateButton);

        //save button settings
        saveButton.setBounds(5, 530, 105, 40);
        saveButton.addActionListener(this);
        navigationPanel.add(saveButton);

        //continue button settings
        exitButton.setBounds(5, 580, 105, 40);
        exitButton.addActionListener(this);
        navigationPanel.add(exitButton);

        //menu bar settings
        menuBar.setBackground(new Color(255, 199, 199));
        menuBar.setBounds(0, 0, 970, 60);

        //menu bar components
        //search text field settings
        searchTextField.setBounds(450, 10, 430, 40);
        menuBar.add(searchTextField);

        //search button settings
        searchButton.setBounds(900, 5, 50, 50);
        searchButton.addActionListener(this);
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
  @Override
          public void actionPerformed(ActionEvent e) {
            //for navigation buttons
            if (e.getSource() == addButton) {
              AddMovie add= new AddMovie();
              add.setVisible(true);
              add.setLocationRelativeTo(null);
            }
            else if(e.getSource() == removeButton){
            }
            else if(e.getSource() == updateButton){
              UpdateMovie update= new UpdateMovie();
              update.setVisible(true);
              update.setLocationRelativeTo(null);
            }
            else if(e.getSource() == saveButton){
            }
            else if(e.getSource() == exitButton){
              ProgrammersProfileExit profileExit= new ProgrammersProfileExit();
              profileExit.setVisible(true);
              profileExit.setLocationRelativeTo(null);
              this.dispose();
            }
            //for menu bar button
            else if(e.getSource() == searchButton){
              SearchMovie searchMovie= new SearchMovie();
              searchMovie.setVisible(true);
              searchMovie.setLocationRelativeTo(null);
            }
          };
}
