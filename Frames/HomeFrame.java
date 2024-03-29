package Frames;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeFrame extends JFrame{
  JLabel label = new JLabel();
  HomeFrame(){
        add(label);
        setTitle("WatchmeList");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
  }
}
