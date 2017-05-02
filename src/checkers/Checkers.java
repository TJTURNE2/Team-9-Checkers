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
  ImageIcon redN = new ImageIcon(new ImageIcon("images/red_normal.png").getImage());// red_normal.jpg
                                                                                    // //FIXED -
                                                                                    // Terry
  // ImageIcon yellowN=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/blue.png")).getImage());//yellow_normal.jpg //OLD
  ImageIcon yellowN = new ImageIcon(new ImageIcon("images/yellow_normal.png").getImage());// yellow_normal.jpg//FIXED
                                                                                          // - Terry
  // ImageIcon redK=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/rs.jpg")).getImage());//red_king.jpg //OLD
  ImageIcon redK = new ImageIcon(new ImageIcon("images/red_king.png").getImage());// red_king.jpg
                                                                                  // //FIXED - Terry
  // ImageIcon yellowK=new ImageIcon(new
  // ImageIcon(getClass().getResource("/images/bs.jpg")).getImage());//yellow_king.jpg //OLD
  ImageIcon yellowK = new ImageIcon(new ImageIcon("images/yellow_king.png").getImage());// yellow_king.jpg
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
  JButton ffB = new JButton("Forfeit");
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
  int[][] preBoard2 = new int[8][8];
  int[][] preBoard3 = new int[8][8];
  
  int preToMove1 = yellowNormal;
  int preToMove2 = yellowNormal;
  int preToMove3 = yellowNormal;

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

  private void setupGUI() 
  {
    setLayout(null);

    nwB.setFocusPainted(false);
    ffB.setFocusPainted(false);
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
    ffB.setFont(new Font("SansSerif", Font.BOLD, 11));
    unB.setFont(new Font("SansSerif", Font.BOLD, 11));
    hlpB.setFont(new Font("SansSerif", Font.PLAIN, 11));
    snB.setFont(new Font("SansSerif", Font.PLAIN, 11));
    msg.setFont(new Font("SansSerif", Font.PLAIN, 11));

    nwB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    ffB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    unB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    hlpB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    snB.setCursor(new Cursor(Cursor.HAND_CURSOR));
    nwB.addActionListener(this);
    ffB.addActionListener(this);
    unB.addActionListener(this);
    hlpB.addActionListener(this);
    snB.addActionListener(this);
    nwB.setBounds(405, 70, 95, 25);// 297
    this.add(nwB);
    ffB.setBounds(405, 350, 95, 25);
    ffB.setEnabled(false);
    this.add(ffB);
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

  /**
   * Graphically creates the Checkers board with the checkers
   * placed on the black squares.
   * Bug presented: the checkers were previously placed in the
   * white squares, and, in the game of Checkers, it is
   * customary for the pieces to be placed on the darker colored
   * squares.
   * Bug fixed by: Cristi DeLeo
   * 
   * Enhancement presented: there were two for-loops to create 
   * the squares for a single color, and only one for-loop was
   * needed (combine both fillRect statements, per color, under
   * one for-loop).
   * Enhanced by: Cristi DeLeo
   */
  public void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    
    // Sets color in-use to white
    g.setColor(Color.white);
    
    // Creates white squares with dimensions of 50 pixels x 50 pixels 
    for (int i = 0; i < 4; i++)
    {
      for (int j = 0; j < 4; j++) 
      {
        g.fillRect(100 * j, 100 * i, 50, 50);
        g.fillRect(50 + 100 * j, 50 + 100 * i, 50, 50);
      }
    }

    // Sets color in-use to black
    g.setColor(Color.black);
    
    // Creates black squares with dimensions of 50 pixels x 50 pixels
    // that alternate in between the white squares, completing the
    // black & white checkered board display
    for (int i = 0; i < 4; i++) 
    {
      for (int j = 0; j < 4; j++) 
      {
        g.fillRect(100 * j, 50 + 100 * i, 50, 50);
        g.fillRect(50 + 100 * j, 100 * i, 50, 50);
      }
    }
    
    g.drawLine(0, 400, 400, 400);
    g.drawLine(400, 0, 400, 400);
    
    // Displays the checkers on the board
    drawCheckers();
  } // End of paintComponent(Graphics g)

  /**
   * Performs the corresponding actions for each click of a 
   * button (or radio button) by the user's mouse.
   * 
   * Enhancement presented: there was not an option for the user
   * to forfeit a game.
   * Enhanced by: Steven Bennett
   * 
   * @param e the ActionEvent that accounts for mouse-clicks
   */
  public void actionPerformed(ActionEvent e) 
  {
    // Executes if the user selects the "1-Player" radio button
    if (e.getActionCommand().equalsIgnoreCase("1-Player")) 
    {
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
    
    // Executes if the user selects the "2-Player" radio button
    if (e.getActionCommand().equalsIgnoreCase("2-Player")) 
    {
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
    
    // Executes if the user selects the "red" radio button
    if (e.getActionCommand().equalsIgnoreCase("red")) 
    {
      // new PlaySound("src//sounds//option.wav").start(); //OLD
      new PlaySound("sounds//option.wav").start();// FIXED -Terry
    }
    
    // Executes if the user selects the "yellow" radio button
    if (e.getActionCommand().equalsIgnoreCase("yellow")) 
    {
      // new PlaySound("src//sounds//option.wav").start(); //OLD
      new PlaySound("sounds//option.wav").start();// FIXED -Terry
    }
    
    // Executes if the user clicks the "New Game" button
    if (e.getActionCommand().equalsIgnoreCase("New Game")) 
    {
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start();// FIXED -Terry
      nwB.setEnabled(false);
      col.setEnabled(false);
      diff.setEnabled(false);
      c1.setEnabled(false);
      c2.setEnabled(false);
      level.setEnabled(false);
      mode.setEnabled(false);
      p1.setEnabled(false);
      p2.setEnabled(false);
      ffB.setEnabled(true);
      newGame();
    }
    
    // Executes if the user clicks the "Forfeit" button during game play
    if(e.getActionCommand().equalsIgnoreCase("Forfeit")) 
    {
        new PlaySound("sounds//button.wav").start();
        loser = toMove;
        showStatus();
    }
    
    // Executes if the user clicks the "Undo" button game play and the
    // the number of "undos" is greater than 3.
    if (e.getActionCommand().equalsIgnoreCase("Undo") && undoCount > 3) 
    {
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start();// FIXED -Terry
      undo();
    }
    
    // Executes if the user clicks the "Help" icon
    if (e.getSource() == hlpB) 
    {
      // new PlaySound("src//sounds//button.wav").start(); //OLD
      new PlaySound("sounds//button.wav").start();// FIXED -Terry
      hp.setVisible(true);
    }
    
    // Executes if the user clicks the "Sound" icon
    if (e.getSource() == snB) 
    {
      if (silent) 
      {
        snB.setIcon(snp);
        silent = false;
        // new PlaySound("src//sounds//button.wav").start(); //OLD
        new PlaySound("sounds//button.wav").start();// FIXED -Terry
      } 
      else 
      {
        snB.setIcon(mup);
        silent = true;
      }
    }
  } // End of ActionPerformed(ActionEvent e)

  /**
   * Creates a new game with the selected game play settings.
   */
  public void newGame() 
  {
    // Yellow takes the first move in both modes
    // If someone wants to move secondly, red has to be selected
    // Yellow is always at the bottom of the board

    // Assigns the selected color to the user (in 1-Player mode),
    // otherwise the selected color is set to default to "yellow"
    // in 2-Player mode
    selectedColor = c1.isSelected() ? "red" : "yellow";
    
    // Instantiates the selectedMode dependent upon the user's selection
    selectedMode = p1.isSelected() ? 1 : 2;
    
    // Instantiates the difficulty dependent upon the user's selection
    difficulty = level.getSelectedIndex();

    // The undo button is disabled prior to the movement of any pieces
    unB.setEnabled(false);

    // Resets the winner variable
    won = 0;

    // undoCount = 0; // OLD - Steven
    // Sets/resets the number of undos to 2
    undoCount = 2; // FIXED - Steven

    // Sets/resets the highlight variable to false, representing that no squares
    // are currently selected
    highlight = false;
    
    // Sets/resets the incomplete variable to false, indicating that the current
    // status of the first move in a new game is not an incomplete move
    incomplete = false;

    // Resets the loser variable
    loser = empty;

    // Initiates an new, blank board
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

    // toMove = yellowNormal; // OLD - toMove only needs to be set to yellow when 2-Player mode is selected

    // For-loop copies the current state of the board to the pre-board
    // to store past data in the event of the user clicking "undo"
    for (int i = 0; i < 8; i++) 
    {
      System.arraycopy(board[i], 0, preBoard1[i], 0, 8); // for undo
      System.arraycopy(preBoard1[i], 0, preBoard2[i], 0, 8);
      System.arraycopy(preBoard2[i], 0, preBoard3[i], 0, 8);
      //preToMove3 = preToMove2 = preToMove1 = toMove; // OLD - Cristi - Variables are initialized at the beginning of the class to yellowNormal.
    }

    // Executes if the user has 1-Player mode selected and chooses Yellow
    if (selectedMode == 1 && selectedColor.equalsIgnoreCase("yellow")) 
    {
      undoCount = 1; // FIXED - Steven
      this.toMove = redNormal;
      play();
    } 
    
    // Executes if the user has 1-Player mode selected and chooses Red
    else if (selectedMode == 1 && selectedColor.equalsIgnoreCase("red")) 
    {
      undoCount = 1; // FIXED - Steven
      this.toMove = redNormal;
      play();
    }
    
    // Executes if the user has 2-Player mode selected
    else if (selectedMode == 2)
    {
      // The first player to make a move is yellow
      toMove = yellowNormal;
    }

    // Updates the GUI to display a new game
    update(getGraphics());
    
    // Draws the black & white checkered board
    drawCheckers();
    
    // Displays the current status of the new game "Yellow to move"
    showStatus();
  } // End of newGame()

  /**
   * Paints the checker pieces on the board.
   * 
   * Enhancement presented: Pieces were not centered horizontally or vertically.
   * Enhanced by: Cristi DeLeo
   */
  public void drawCheckers() 
  {
    g = getGraphics();
    //paintComponent(g);

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

  /**
   * Performs the undo request by the user.
   * 
   * Bug presented: toMove was set to the preToMove3, despite the selected mode
   * (1-Player should result in toMove being set to preToMove3, while 2-Player
   * should result in toMove being set to preToMove2).
   * Bug fixed by: Steven Bennett
   * 
   * Bug presented: drawCheckers() was unnecessarily called (to re-draw the 
   * black & white checker squares).
   * Bug fixed by: Cristi DeLeo
   */
  public void undo() 
  {
    undoCount = 1;
    
    for (int i = 0; i < 8; i++) 
    {
      System.arraycopy(preBoard3[i], 0, board[i], 0, 8); // copies previous board
    }
    
    // toMove = preToMove3; // OLD - Steven
    
    // drawCheckers(); // OLD - Cristi - It is not necessary to draw the checker board here (black & white squares, not pieces)
    
    // Updates the display to represent the undo 
    update(g);

    // Executes if the 1-Player mode is selected
    if (selectedMode == 1) 
    {
      toMove = preToMove3; // FIXED - Steven
      play();
    } 
    
    // Executes if the 2-Player mode is selected
    else 
    {
      toMove = preToMove2; // FIXED - Steven
    }
  } // End of undo()

  /**
   * Performs the necessary steps to successfully play Checkers.
   * 
   * Bug presented: incorrect source for .wav file.
   * Bug fixed by: Terry Turner
   */
  public void play() 
  {
    // Increases the undoCount by 1
    undoCount++;

    // Executes if the undoCount is greater than 3
    if (undoCount > 3) 
    {
      // Executes if 1-Player mode is selected and the difficulty is not
      // set to "tough"
      if (selectedMode == 1 && difficulty != 4)
      {
        // Enables the "undo" button
        unB.setEnabled(true);
      }
      
      // Executes if 2-Player mode is selected
      else if (selectedMode == 2)
      {
        // Enables the "undo" button
        unB.setEnabled(true);
      }
    }

    // For-loop copies the current board to preBoard1, and preBoard1-3 are
    // copied to the next sequential preBoard
    for (int i = 0; i < 8; i++) 
    {
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

    // Sets the counter to 0
    counter[0] = 0;

    // Executes if it is the user's turn and the following options have
    // been selected: 1-Player mode and the user's selected color is yellow
    if (this.toMove == yellowNormal && selectedMode == 1
        && selectedColor.equalsIgnoreCase("yellow")) 
    {
      // Assigns the current move to the red opponent (in this case it is the computer)
      this.toMove = redNormal;
      
      // Displays who's turn it is
      showStatus();
      
      tempScore = GameEngine.MinMax(board, 0, difficulty + 2, result, this.toMove, counter);

      if (result[0] == 0 && result[1] == 0)
      {
        loser = redNormal;
      }
      
      else 
      {
        CheckerMove.moveComputer(board, result);

        if (loser == empty) 
        {
          // new PlaySound("src//sounds//comPlay.wav").start(); //OLD
          new PlaySound("sounds//comPlay.wav").start(); // FIXED -Terry
          play();
        }
        
        // Assigns the current move to the yellow opponent (in this case it is the user)
        this.toMove = yellowNormal;
      }
    }

    // Executes if it is the user's turn and the following options have
    // been selected: 1-Player mode and the user's selected color is red
    else if (this.toMove == redNormal && selectedMode == 1
        && selectedColor.equalsIgnoreCase("red")) 
    {
      // Assigns the current move to the yellow opponent (in this case it is the computer)
      this.toMove = yellowNormal;
      
      // Displays who's turn it is
      showStatus();
      
      tempScore = GameEngine.MinMax(board, 0, difficulty + 2, result, this.toMove, counter);

      if (result[0] == 0 && result[1] == 0)
      {
        loser = yellowNormal;
      }
      
      else 
      {
        CheckerMove.moveComputer(board, result);
        if (loser == empty) 
        {
          // new PlaySound("src//sounds//comPlay.wav").start(); //OLD
          new PlaySound("sounds//comPlay.wav").start(); // FIXED -Terry
          play();
        }
        
        // Assigns the current move to the red opponent (in this case it is the user)
        this.toMove = redNormal;
      }
    } 
    
    // Executes if neither of the two previously accounted for conditions were met
    else 
    {
      if (this.toMove == redNormal)
      {
        this.toMove = yellowNormal;
      }
      
      else
      {
        this.toMove = redNormal;
      }
    }
    
    // Executes if there are no more moves left for the opponent whose turn it is
    // and pronounces them as the loser
    if (CheckerMove.noMovesLeft(board, this.toMove))
    {
      if (this.toMove == redNormal)
      {
        loser = redNormal;
      }
      
      else
      {
        loser = yellowNormal;
      }
    }
    showStatus();
  } // End of play()

  /**
   * Determines whether the specified coordinate is a valid square (pieces
   * may only move to/from black squares.
   * @param i
   * @param j
   * @return true if the coordinate is a valid location, otherwise false
   */
  private boolean isPossibleSquare(int i, int j) 
  {
    return (i + j) % 2 == 1;
  }

  public void itemStateChanged(ItemEvent e) {
  }

  public void mousePressed(MouseEvent e) 
  {
    if (won == 1)
    {
      return;
    }

    int x = e.getX();
    int y = e.getY();
    int[] square = new int[2];

    if (x >= 0 && x <= 500 && y <= 500 && y >= 0)
    {
      square = CheckerMove.getIndex(x, y);
    }

    if (toMove == Checkers.redNormal
        && (board[square[0]][square[1]] == Checkers.redNormal
            || board[square[0]][square[1]] == Checkers.redKing)
        || toMove == Checkers.yellowNormal && (board[square[0]][square[1]] == Checkers.yellowNormal
            || board[square[0]][square[1]] == Checkers.yellowKing)) 
    {
      // we don't want to lose the incomplete move info:
      // only set new start variables if !incomplete
      if (!incomplete) 
      {
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
    } 
    else if (highlight && (float) (square[0] + square[1]) / 2 != (square[0] + square[1]) / 2) 
    {
      endX = square[0];
      endY = square[1];
      int status = CheckerMove.ApplyMove(board, startX, startY, endX, endY);
      switch (status) 
      {
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
      //undoCount = 0;
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
      //undoCount = 0;
      //newGame(); // OLD - Removed to display board after game ends, user should have to click New Game for new game to start - Cristi
    }
    if(won == 1) {
        nwB.setEnabled(true);
        col.setEnabled(true);
        diff.setEnabled(true);
        c1.setEnabled(true);
        c2.setEnabled(true);
        level.setEnabled(true);
        mode.setEnabled(true);
        p1.setEnabled(true);
        p2.setEnabled(true);
        ffB.setEnabled(false);
        undoCount = 0;
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
