package Frames;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UpdateMovie extends JFrame{
  JLabel label = new JLabel();

  UpdateMovie(){
    //frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
  }

}

