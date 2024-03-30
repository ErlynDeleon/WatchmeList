package Frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SearchMovie extends JFrame{
  JLabel label = new JLabel();

  SearchMovie(){
    //frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        ImageIcon icon = new ImageIcon("Frames\\pictures\\photo_2024-03-30_23-39-13.jpg");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
  }

}
