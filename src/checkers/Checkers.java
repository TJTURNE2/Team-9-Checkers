package checkers;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Checkers extends JPanel
    implements ActionListener, ItemListener, MouseMotionListener, MouseListener {

  Graphics g;

  JTextArea msg = new JTextArea("Start a new game... Yellow is to move first...");
  // ImageIcon redN=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/red.png")).getImage());//red_normal.jpg //OLD
  ImageIcon redN = new ImageIcon(new ImageIcon("images/red_normal.jpg").getImage());// red_normal.jpg
                                                                                    // //FIXED -
                                                                                    // Terry
  // ImageIcon yellowN=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/blue.png")).getImage());//yellow_normal.jpg //OLD
  ImageIcon yellowN = new ImageIcon(new ImageIcon("images/yellow_normal.jpg").getImage());// yellow_normal.jpg//FIXED
                                                                                          // - Terry
  // ImageIcon redK=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/rs.jpg")).getImage());//red_king.jpg //OLD
  ImageIcon redK = new ImageIcon(new ImageIcon("images/red_king.jpg").getImage());// red_king.jpg
                                                                                  // //FIXED - Terry
  // ImageIcon yellowK=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/bs.jpg")).getImage());//yellow_king.jpg //OLD
  ImageIcon yellowK = new ImageIcon(new ImageIcon("images/yellow_king.jpg").getImage());// yellow_king.jpg
                                                                                        // //FIXED -
                                                                                        // Terry
  // ImageIcon hlp=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/help.jpg")).getImage());//help.jpg //OLD
  ImageIcon hlp = new ImageIcon(new ImageIcon("images/help.jpg").getImage());// help.jpg //FIXED -
                                                                             // Terry
  // ImageIcon snp=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/sound.jpg")).getImage());//sound.jpg //OLD
  ImageIcon snp = new ImageIcon(new ImageIcon("images/sound.jpg").getImage());// sound.jpg //FIXED -
                                                                              // Terry
  // ImageIcon mup=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/mute.jpg")).getImage());//mute.jpg //OLD
  ImageIcon mup = new ImageIcon(new ImageIcon("images/mute.jpg").getImage());// mute.jpg //FIXED -
                                                                             // Terry

  JButton nwB = new JButton("New Game");
  JButton unB = new JButton("Undo");
  JButton hlpB = new JButton(hlp);
  JButton snB = new JButton(snp);

  ButtonGroup players = new ButtonGroup();
  JRadioButton p1 = new JRadioButton("1-Player", true);
  JRadioButton p2 = new JRadioButton("2-Player", false);

  ButtonGroup colors = new ButtonGroup();
  JRadioButton c1 = new JRadioButton("Red", false);
  JRadioButton c2 = new JRadioButton("Yellow", true);

  Help hp = new Help();

  JLabel mode = new JLabel("Mode");
  JLabel col = new JLabel("Colour");
  JLabel diff = new JLabel("Difficulty Level");
  JLabel rp = new JLabel();
  JLabel rpt = new JLabel("Red Piece");
  JLabel bpt = new JLabel("Yellow Piece");
  JLabel bp = new JLabel();
  JLabel rk = new JLabel();
  JLabel rkt = new JLabel("Red King");
  JLabel bkt = new JLabel("Yellow King");
  JLabel bk = new JLabel();

  JComboBox level = new JComboBox();

  String selectedColor;
  int selectedMode;
  int difficulty;

  static final int redNormal = 1;
  static final int yellowNormal = 2;
  static final int redKing = 3;
  static final int yellowKing = 4;
  static final int empty = 0;

  int currType;
  boolean movable;

  int[][] board = new int[8][8];

  int[][] preBoard1 = new int[8][8]; // for undo
  int preToMove1;
  int[][] preBoard2 = new int[8][8];
  int preToMove2;
  int[][] preBoard3 = new int[8][8];
  int preToMove3;

  int startX, startY, endX, endY;
  boolean incomplete = false;
  boolean highlight = false;

  int toMove = redNormal;
  int loser = empty;

  static boolean silent = false;

  int undoCount;

  int won = 0;

  Point winPoint;

  Checkers() {
    setupGUI();
  }

  private void setupGUI() {
    setLayout(null);

    nwB.setFocusPainted(false);
    unB.setFocusPainted(false);
    c1.setFocusPainted(false);
    c2.setFocusPainted(false);
    p1.setFocusPainted(false);
    p2.setFocusPainted(false);
    hlpB.setFocusPainted(false);
    snB.setFocusPainted(false);

    diff.setFont(new Font("SansSerif", Font.PLAIN, 11));
    col.setFont(new Font("SansSerif", Font.PLAIN, 11));
    mode.setFont(new Font("SansSerif", Font.PLAIN, 11));
    c1.setFont(new Font("SansSerif", Font.PLAIN, 11));
    c2.setFont(new Font("SansSerif", Font.PLAIN, 11));
    p1.setFont(new Font("SansSerif", Font.PLAIN, 11));
    p2.setFont(new Font("SansSerif", Font.PLAIN, 11));
    nwB.setFont(new Font("SansSerif", Font.BOLD, 11));
    unB.setFont(new Font("SansSerif", Font.BOLD, 11));
    hlpB.setFont(new Font("SansSerif", Font.PLAIN, 11));
    snB.setFont(new Font("SansSerif", Font.PLAIN, 11));
    msg.setFont(new Font("SansSerif", Font.PLAIN, 11));

    nwB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    unB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    hlpB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    snB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    nwB.addActionListener(this);
    unB.addActionListener(this);
    hlpB.addActionListener(this);
    snB.addActionListener(this);
    nwB.setBounds(405, 70, 95, 25);// 297
    this.add(nwB);
    unB.setBounds(405, 40, 95, 25); // FIXED - Steven
    this.add(unB); // FIXED - Steven
    hlpB.setBounds(415, 10, 25, 25);
    this.add(hlpB);
    snB.setBounds(460, 10, 25, 25);
    this.add(snB);

    mode.setBounds(420, 260, 80, 25);
    this.add(mode);
    p1.addActionListener(this);
    p2.addActionListener(this);
    p1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    p2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    players.add(p1);
    players.add(p2);
    p1.setBounds(415, 290, 80, 25);
    p2.setBounds(415, 318, 80, 25);
    this.add(p1);
    this.add(p2);

    col.setBounds(420, 100, 80, 25); // FIXED - Steven
    this.add(col); // FIXED - Steven
    c1.addActionListener(this);
    c2.addActionListener(this);
    c1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    c2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    colors.add(c1);
    colors.add(c2);
    c1.setBounds(415, 140, 80, 25); // FIXED - Steven
    c2.setBounds(415, 120, 80, 25); // FIXED - Steven
    this.add(c1); // FIXED - Steven
    this.add(c2); // FIXED - Steven

    level.setCursor(new Cursor(Cursor.HAND_CURSOR));
    level.addItemListener(this);
    level.addItem("Easy");
    level.addItem("Fairly Easy");
    level.addItem("Moderate");
    level.addItem("Bit Difficult");
    level.addItem("Tough");
    level.setSelectedIndex(2);
    level.setBounds(415, 200, 80, 25);
    this.add(level);

    diff.setCursor(new Cursor(Cursor.HAND_CURSOR));
    diff.setBounds(415, 170, 100, 25);
    this.add(diff);

    this.addMouseListener(this);
    this.addMouseMotionListener(this);

    msg.setBounds(0, 405, 400, 20);
    msg.setEnabled(false);
    this.add(msg);

    rp.setBounds(10, 440, 50, 50);
    rp.setIcon(redN);
    this.add(rp);
    rpt.setBounds(60, 450, 60, 20);
    this.add(rpt);

    bp.setBounds(110, 440, 50, 50);
    bp.setIcon(yellowN);
    this.add(bp);
    bpt.setBounds(160, 450, 90, 20);
    this.add(bpt);

    rk.setBounds(250, 440, 50, 50);
    rk.setIcon(redK);
    this.add(rk);
    rkt.setBounds(305, 450, 60, 20);
    this.add(rkt);

    bk.setBounds(365, 440, 50, 50);
    bk.setIcon(yellowK);
    this.add(bk);
    bkt.setBounds(420, 450, 100, 20);
    this.add(bkt);

    // g=getGraphics();
    // g.drawImage(redN.getImage(),30,450,this);

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(0, 0, 0));

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        g.fillRect(100 * j, 100 * i, 50, 50);
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        g.fillRect(50 + 100 * j, 50 + 100 * i, 50, 50);
      }
    }
    g.drawLine(0, 400, 400, 400);
    g.drawLine(400, 0, 400, 400);
    drawCheckers();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equalsIgnoreCase("1-Player")) {
      // new PlaySound("src//sounds//option.wav").start(); //OLD
      new PlaySound("sounds//option.wav").start(); // FIXED - Terry
      col.setEnabled(true);
      col.setVisible(true);
      diff.setEnabled(true);
      diff.setVisible(true);
      c1.setEnabled(true);
      c1.setVisible(true);
      c2.setEnabled(true);
      c2.setVisible(true);
      level.setEnabled(true);
      level.setVisible(true);
    }
    if (e.getActionCommand().equalsIgnoreCase("2-Player")) {
      // new PlaySound("src//sounds//option.wav").start(); //OLD
      new PlaySound("sounds//option.wav").start(); // FIXED -Terry
      col.setEnabled(false);
      col.setVisible(false);
      diff.setEnabled(false);
      diff.setVisible(false);
      c1.setEnabled(false);
      c1.setVisible(false);
      c2.setEnabled(false);
      c2.setVisible(false);
      level.setEnabled(false);
      level.setVisible(false);
      c2.setSelected(true);
    }
    if (e.getActionCommand().equalsIgnoreCase("red")) {
      // new PlaySound("src//sounds//option.wav").start(); //OLD
      new PlaySound("sounds//option.wav").start();// FIXED -Terry
    }
    if (e.getActionCommand().equalsIgnoreCase("yellow")) {
      // new PlaySound("src//sounds//option.wav").start(); //OLD
      new PlaySound("sounds//option.wav").start();// FIXED -Terry
    }
    if (e.getActionCommand().equalsIgnoreCase("New Game")) {
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start();// FIXED -Terry
      newGame();
    }
    if (e.getActionCommand().equalsIgnoreCase("Undo") && undoCount > 3) {
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start();// FIXED -Terry
      undo();
    }
    if (e.getSource() == hlpB) {
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start();// FIXED -Terry
      hp.setVisible(true);
    }
    if (e.getSource() == snB) {
      if (silent) {
        snB.setIcon(snp);
        silent = false;
        // new PlaySound("src//sounds//button.wav").start(); //OLD
        new PlaySound("sounds//button.wav").start();// FIXED -Terry
      } else {
        snB.setIcon(mup);
        silent = true;
      }
    }
  }

  public void newGame() { // creates a new game

    // Yellow takes the first move in both modes
    // If someone wants to move secondly, red has to be selected
    // Yellow is always at the bottom of the board

    selectedColor = c1.isSelected() ? "red" : "yellow";
    selectedMode = p1.isSelected() ? 1 : 2;
    difficulty = level.getSelectedIndex();

    unB.setEnabled(false);

    won = 0;

    // undoCount = 0; // OLD - Steven
    undoCount = 2; // FIXED - Steven

    highlight = false;
    incomplete = false;

    loser = empty;

    // Initiates an new board
    for (int i = 0; i < 8; i++)
    {
      for (int j = 0; j < 8; j++)
        board[i][j] = empty;

      for (int j = 0; j < 3; j++)
        if (isPossibleSquare(i, j))
          board[i][j] = redNormal;

      for (int j = 5; j < 8; j++)
        if (isPossibleSquare(i, j))
          board[i][j] = yellowNormal;
    }

    toMove = yellowNormal;

    for (int i = 0; i < 8; i++) {
      System.arraycopy(board[i], 0, preBoard1[i], 0, 8); // for undo
      System.arraycopy(preBoard1[i], 0, preBoard2[i], 0, 8);
      System.arraycopy(preBoard2[i], 0, preBoard3[i], 0, 8);
      preToMove3 = preToMove2 = preToMove1 = toMove;
    }

    if (selectedMode == 1 && selectedColor.equalsIgnoreCase("yellow")) {
      undoCount = 1; // FIXED - Steven
      this.toMove = redNormal;
      play();
    } else if (selectedMode == 1 && selectedColor.equalsIgnoreCase("red")) {
      undoCount = 1; // FIXED - Steven
      this.toMove = redNormal;
      play();
    }

    update(getGraphics());
    drawCheckers();
    showStatus();
  }

  /**
   * Paints the checker pieces on the board.
   * Bug presented: Pieces were not centered horizontally or vertically.
   * Bug fixed by: Cristi DeLeo
   */
  public void drawCheckers() 
  {
    g = getGraphics();

    for (int i = 0; i < 8; i++) 
    {
      for (int j = 0; j < 8; j++) 
      {
        if (board[i][j] == redNormal) // Executes if current space contains a normal red piece
        {
          //g.drawImage(redN.getImage(), i * 50, j * 50, this); // OLD
          // Displays the normal red pieces centered horizontally and vertically in squares
          g.drawImage(redN.getImage(), (i * 50) + 5, (j * 50) + 5, this); // Centered in box - Cristi
        }  
        else if (board[i][j] == yellowNormal) // Executes if current space contains a normal yellow piece
        {
          //g.drawImage(yellowN.getImage(), i * 50, j * 50, this); // OLD
          // Displays the normal yellow pieces centered horizontally and vertically in squares
          g.drawImage(yellowN.getImage(), (i * 50) + 5, (j * 50) + 5, this); // Centered in box - Cristi
        }
        else if (board[i][j] == redKing) // Executes if current space contains a King red piece
        {
          //g.drawImage(redK.getImage(), i * 50, j * 50, this); // OLD
          // Displays the King red pieces centered horizontally and vertically in squares
          g.drawImage(redK.getImage(), (i * 50) + 5, (j * 50) + 5, this); // Centered in box - Cristi
        }
        else if (board[i][j] == yellowKing) // Executes if current space contains a King yellow piece
        {
          //g.drawImage(yellowK.getImage(), i * 50, j * 50, this); // OLD
          // Displays the King yellow pieces centered horizontally and vertically in squares
          g.drawImage(yellowK.getImage(), (i * 50) + 5, (j * 50) + 5, this); // Centered in box - Cristi
        }
      }
    }
  } // End of drawCheckers()

  public void undo() { // undo function
    undoCount = 1;
    for (int i = 0; i < 8; i++) {
      System.arraycopy(preBoard3[i], 0, board[i], 0, 8); // copies previous board
    }
    // toMove = preToMove3; // OLD - Steven
    drawCheckers();
    update(g);

    if (selectedMode == 1) {
      toMove = preToMove3; // FIXED - Steven
      play();
    } else {
      toMove = preToMove2; // FIXED - Steven
    }
  }

  public void play() {

    undoCount++;

    if (undoCount > 3) {
      if (selectedMode == 1 && difficulty != 4)
        unB.setEnabled(true);
      else if (selectedMode == 2)
        unB.setEnabled(true);
    }

    for (int i = 0; i < 8; i++) {
      System.arraycopy(preBoard2[i], 0, preBoard3[i], 0, 8);
      System.arraycopy(preBoard1[i], 0, preBoard2[i], 0, 8);
      System.arraycopy(board[i], 0, preBoard1[i], 0, 8);
    }
    preToMove3 = preToMove2;
    preToMove2 = preToMove1;
    preToMove1 = toMove;
    int tempScore;
    int[] result = new int[4];
    int[] counter = new int[1];

    counter[0] = 0;

    if (this.toMove == yellowNormal && selectedMode == 1
        && selectedColor.equalsIgnoreCase("yellow")) {
      this.toMove = redNormal;
      showStatus();
      tempScore = GameEngine.MinMax(board, 0, difficulty + 2, result, this.toMove, counter);

      if (result[0] == 0 && result[1] == 0)
        loser = redNormal;
      else {
        CheckerMove.moveComputer(board, result);

        if (loser == empty) {
          // new PlaySound("src//sounds//comPlay.wav").start(); //OLD
          new PlaySound("sounds//comPlay.wav").start(); // FIXED -Terry
          play();
        }
        this.toMove = yellowNormal;
      }
    }

    else if (this.toMove == redNormal && selectedMode == 1
        && selectedColor.equalsIgnoreCase("red")) {
      this.toMove = yellowNormal;
      showStatus();
      tempScore = GameEngine.MinMax(board, 0, difficulty + 2, result, this.toMove, counter);

      if (result[0] == 0 && result[1] == 0)
        loser = yellowNormal;
      else {
        CheckerMove.moveComputer(board, result);
        if (loser == empty) {
          // new PlaySound("src//sounds//comPlay.wav").start(); //OLD
          new PlaySound("sounds//comPlay.wav").start(); // FIXED -Terry
          play();
        }

        this.toMove = redNormal;
      }
    } else {
      if (this.toMove == redNormal)
        this.toMove = yellowNormal;
      else
        this.toMove = redNormal;
    }
    if (CheckerMove.noMovesLeft(board, this.toMove)) //
    {
      if (this.toMove == redNormal)
        loser = redNormal;
      else
        loser = yellowNormal;
    }

    showStatus();
  }

  private boolean isPossibleSquare(int i, int j) {
    return (i + j) % 2 == 1;
  }

  public void itemStateChanged(ItemEvent e) {
  }

  public void mousePressed(MouseEvent e) {

    int x = e.getX();
    int y = e.getY();
    int[] square = new int[2];

    if (x >= 0 && x <= 500 && y <= 500 && y >= 0)
      square = CheckerMove.getIndex(x, y);

    if (toMove == Checkers.redNormal
        && (board[square[0]][square[1]] == Checkers.redNormal
            || board[square[0]][square[1]] == Checkers.redKing)
        || toMove == Checkers.yellowNormal && (board[square[0]][square[1]] == Checkers.yellowNormal
            || board[square[0]][square[1]] == Checkers.yellowKing)) {

      // we don't want to lose the incomplete move info:
      // only set new start variables if !incomplete
      if (!incomplete) {
        highlight = true;
        startX = square[0];
        startY = square[1];
        update(g);
        g = getGraphics();
        g.setColor(new Color(255, 100, 30));
        g.fillRect(50 * square[0], 50 * square[1], 50, 50);
        drawCheckers();
        // new PlaySound("src//sounds//clickChecker.wav").start(); //OLD
        new PlaySound("sounds//clickChecker.wav").start(); // FIXED -Terry
      }
    } else if (highlight && (float) (square[0] + square[1]) / 2 != (square[0] + square[1]) / 2) {
      endX = square[0];
      endY = square[1];
      int status = CheckerMove.ApplyMove(board, startX, startY, endX, endY);
      switch (status) {
      case CheckerMove.legalMove:
        incomplete = false;
        highlight = false;
        play();
        update(g);
        drawCheckers();
        break;
      case CheckerMove.incompleteMove:
        incomplete = true;
        highlight = true;
        // the ending square is now starting square for the next capture
        startX = square[0];
        startY = square[1];
        update(g);
        g = getGraphics();
        g.setColor(new Color(255, 100, 30));
        g.fillRect(50 * square[0], 50 * square[1], 50, 50);
        drawCheckers();
        break;
      }
    }
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseDragged(MouseEvent e) {
  }

  public void mouseMoved(MouseEvent e) {
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  /**
   * Displays messages in the status bar and generates the "Winner" window
   * upon the winning/losing of a game.
   * Bug presented:  New game automatically started with the settings of the
   * previous game.  This did not allow the user to change settings for the
   * next game, nor view the ending status of the board.
   * Bug fixed by:  Cristi DeLeo
   */
  private void showStatus() 
  {
    if (this.toMove == redNormal) 
    {
      msg.setText("Red to move");
    } 
    else 
    {
      msg.setText("Yellow to move");
    }

    if (loser == redNormal && won == 0) 
    {
      msg.setText("Yellow Wins!");
      try 
      {
        Thread.sleep(150);
      } 
      catch (InterruptedException e) 
      {
        e.printStackTrace();
      }
      new GameWin("Yellow", this.getLocationOnScreen());
      won = 1;
      undoCount = 0;
      //newGame(); // OLD - Removed to display board after game ends, user should have to click New Game for new game to start - Cristi
    } 
    else if (loser == yellowNormal && won == 0) 
    {
      msg.setText("Red Wins!");
      try 
      {
        Thread.sleep(150);
      } 
      catch (InterruptedException e) 
      {
        e.printStackTrace();
      }
      new GameWin("Red", this.getLocationOnScreen());
      won = 1;
      undoCount = 0;
      //newGame(); // OLD - Removed to display board after game ends, user should have to click New Game for new game to start - Cristi
    }
  } // End of showStatus()

  // The AWT invokes the update() method in response to the repaint() method
  // calls that are made as a checker is dragged. The default implementation
  // of this method, which is inherited from the Container class, clears the
  // applet's drawing area to the background color prior to calling paint().
  // This clearing followed by drawing causes flicker. CheckerDrag overrides
  // update() to prevent the background from being cleared, which eliminates
  // the flicker.
  @Override
  public void update(Graphics g) {
    paint(g);
  }

  //////////// TEST CODE////////////////////
  public boolean getIsPossibleSquare(int i, int j) {
    return isPossibleSquare(i, j);
  }
}
