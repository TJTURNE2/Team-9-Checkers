package checkers;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerFrame.
 */
public class CheckerFrame extends JFrame implements ActionListener {


  /** The st B. */
  JButton stB = new JButton("Start Game");

  /** The gm P. */
  JPanel gmP = new StartPanel();

  /**
   * Instantiates a new checker frame.
   */
  CheckerFrame() {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      SwingUtilities.updateComponentTreeUI(this); // changing the
      // appearence of the
      // frame
    } catch (Exception e) {
      // no need to handle exception as it only affect the appearence
    }
    setupGUI();
    // new PlaySound("src//sounds//Start.wav").start(); //OLD
    new PlaySound("sounds//Start.wav").start(); // NEW-Steven
  }

  /**
   * Setup GUI.
   */
  private void setupGUI() {
    setLayout(null);
    gmP.setBounds(0, 0, 508, 401);// 400,401
    // gmP.imageUpdate(ne, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH)
    add(gmP);
    
    stB.setHorizontalAlignment(SwingConstants.LEADING);
    //stB.setIcon(new
    //ImageIcon(getClass().getResource("/images/checkers.png"))); //OLD
    stB.setIcon(new ImageIcon("images/checkers.png")); // Fixed - Terry
    
//    String filename;
//    filename = (getClass().getResource("/images/checkers.png").toString());
//    //File soundFile = new File(filename);
//    JDialog dia = new JDialog(this, filename);
//    dia.setVisible(true);
    
    
    stB.setBackground(Color.LIGHT_GRAY);
    stB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    // stB.setBounds(154,420,200,60); //OLD-Steven
    stB.setBounds(104, 420, 292, 60); // FIXED-Steven
    // stB.setFont(new Font("Times new roman",Font.BOLD,20)); //OLD-Steven
    stB.setFont(new Font("Times new roman", Font.BOLD, 255)); // FIXED-Steven
    stB.addActionListener(this);
    stB.setFocusPainted(false);
    add(stB);

    // this.setIconImage(new
    // ImageIcon(getClass().getResource("/images/icon.jpg")).getImage());
    // /OLD - Terry
    this.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // Fixed - Terry

    setSize(508, 520);
    setLocation((int) getToolkit().getScreenSize().getWidth() / 2 - 254,
        (int) getToolkit().getScreenSize().getHeight() / 2 - 310);
    setResizable(false);
    setVisible(true);
    setTitle("Play Checkers");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /*
   * Action for starting the new game
   * 
   * @
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equalsIgnoreCase("Start Game")) {
      ((JButton) e.getSource()).setText("New Game");
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start(); // Fixed - Terry
      gmP = new Checkers();
      gmP.setBounds(0, 0, 508, 401);
      this.setContentPane(gmP);
    }
  }
}
