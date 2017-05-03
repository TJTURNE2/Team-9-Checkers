package checkers;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

  StartPanel() {
    setupGUI();
  }

  private void setupGUI() {
    this.setLayout(null);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
            g.drawLine(0,400,508,400);
        ///////////////////////////////////////////////////////////////////////
        g.setColor(Color.RED);
        g.setFont(new Font("Times new roman",Font.BOLD,30));
        g.drawString("CHECKERS",180,100);
        /////////////////////////////////////////////////////////////////////////
        g.setColor(Color.BLUE);
        g.setFont(new Font("Times new roman",Font.BOLD,14));
        g.drawString("SER 216: Testing and Quality",160,130); //fixed ben
        //////////////////////////////////////////////////////////////////////
        g.setFont(new Font("Times new roman",Font.BOLD,12));
        g.setColor(Color.BLACK);
        g.drawString("S. Bennett",180,180);  //fixed - ben
       // g.drawString("070002V",320,180);
        g.drawString("C. Deleo",180,200);   //fixed - ben
        //g.drawString("070123R",320,200);
        g.drawString("B. Jansen",180,220);   //fixed - ben
        //g.drawString("070125B",320,220);
        g.drawString("T. Turner",180,240);   //fixed - ben
        //g.drawString("070137M",320,240);
    ////////////////////////////////////////////////////////////////////////
    // g.drawImage(new
    // ImageIcon(getClass().getResource("/images/checkersIcon.jpg")).getImage(),350,280,this);//checkersIcon.jpg
    // //OLD
    g.drawImage(new ImageIcon("images/checkersIcon.jpg").getImage(), 350, 280, this);// checkersIcon.jpg
    // //FIXED - Terry

    g.setColor(new Color(0, 0, 0));
    // g.drawLine(0,200,200,400);
    // g.draw3DRect(0, 0, 50, 400, true);

    for (int i = 0; i < 8; i++) {
      if (i % 2 == 0) {
        g.fill3DRect(0, i * 50, 50, 50, true);
        g.fill3DRect(100, i * 50, 50, 50, true);
      } else {
        g.fill3DRect(50, i * 50, 50, 50, true);
      }
      // g.fillPolygon(new int[]{80 * i, 40+80*i, 80 * i, -40+80*i},new
      // int[]{200+80*i, 240+80*i,280+80*i, 240+80*i},4);
      // g.fillPolygon(new int[]{80 * i, 40+80*i, 80 * i, -40+80*i},new
      // int[]{280+80*i, 320+80*i,360+80*i, 320+80*i},4);
      // g.fillPolygon(new int[]{80 * i, 40+80*i, 80 * i, -40+80*i},new
      // int[]{360+80*i, 400+80*i,420+80*i, 400+80*i},4);
    }
    g.drawLine(150, 0, 150, 400);
  }
}
