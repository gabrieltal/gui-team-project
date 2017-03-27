
/**
 * *************************************************************
 * file: Sudoku.java
 * authors: Garrick Lee, Paul Chiou, Gabriel Talavera
 * class: CS 245 – Programming Graphical User Interfaces
 *
 * assignment: Quarter Project
 * date last modified: 03/2/2016
 *
 * purpose: JPanel for the Sudoku game, displays date and time,
 * 
 *
 ***************************************************************
 */
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.text.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sudoku extends javax.swing.JPanel {

    private BufferedImage sudokuBoard = null;
    private int points = 540;
    private Timer swTimer;

    private static int X_ORGIN = 168;
    private static int Y_ORGIN = 62;
    private static int TEXTBOX_OFFSET = 32;

    private int posX = -1;
    private int posY = -1;

    private int solution[][] = new int[][]{
        {8, 3, 5, 4, 1, 6, 9, 2, 7},
        {2, 9, 6, 8, 5, 7, 4, 3, 1},
        {4, 1, 7, 2, 9, 3, 6, 5, 8},
        {5, 6, 9, 1, 3, 4, 7, 8, 2},
        {1, 2, 3, 6, 7, 8, 5, 4, 9},
        {7, 4, 8, 5, 2, 9, 1, 6, 3},
        {6, 5, 2, 7, 8, 1, 3, 9, 4},
        {9, 8, 1, 3, 4, 5, 2, 7, 6},
        {3, 7, 4, 9, 6, 2, 8, 1, 5}};

    private int startBoard[][] = new int[][]{
        {8, 0, 0, 4, 0, 6, 0, 0, 7},
        {0, 0, 0, 0, 0, 0, 4, 0, 0},
        {0, 1, 0, 0, 0, 0, 6, 5, 0},
        {5, 0, 9, 0, 3, 0, 7, 8, 0},
        {0, 0, 0, 0, 7, 0, 0, 0, 0},
        {0, 4, 8, 0, 2, 0, 1, 0, 3},
        {0, 5, 2, 0, 0, 0, 0, 9, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 0},
        {3, 0, 0, 9, 0, 2, 0, 0, 5}};

    private boolean pointsTaken[][] = new boolean[9][9];

    /**
     * Creates new form Sudoku
     */
    public Sudoku() {
        swTimer = new Timer(1000, timerAL);
        swTimer.start();
        initComponents();
        jTextField_0_1.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_0_2.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_0_4.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_0_6.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_0_7.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_0.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_1.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_2.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_4.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_7.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_1_8.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_2_0.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_2_2.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_2_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_2_4.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_2_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_2_8.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_3_1.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_3_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_3_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_3_8.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_0.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_1.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_2.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_6.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_7.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_4_8.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_5_0.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_5_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_5_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_5_7.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_6_0.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_6_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_6_4.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_6_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_6_6.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_6_8.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_0.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_1.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_3.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_4.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_5.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_6.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_7.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_7_8.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_8_1.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_8_2.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_8_4.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_8_6.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        jTextField_8_7.setToolTipText("<html>Enter a number from 1 - 9.</html>");
        quit.setToolTipText("<html>Click to Quit.</html>");
        submit.setToolTipText("<html>Click to Submit Solution</html>");

        initializeTextboxKeyListeners();

        initializeTextboxPositions();

        initializeTextboxFilters();
    }

        // method: keyPressed
    // purpose: enter value to array
    KeyListener keyListener = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
            startBoard[posX][posY] = Character.getNumericValue(keyEvent.getKeyChar());
        }

        public void keyReleased(KeyEvent keyEvent) {
        }

        public void keyTyped(KeyEvent keyEvent) {
            if (!validateKeyPressed(keyEvent)) {
                keyEvent.consume();
                JOptionPane.showMessageDialog(null, "Invalid input! Should be 1-9 numeric");
            }
        }
    };

    public void initializeTextboxKeyListeners() {
        jTextField_0_1.addKeyListener(keyListener);
        jTextField_0_2.addKeyListener(keyListener);
        jTextField_0_4.addKeyListener(keyListener);
        jTextField_0_6.addKeyListener(keyListener);
        jTextField_0_7.addKeyListener(keyListener);

        jTextField_1_0.addKeyListener(keyListener);
        jTextField_1_1.addKeyListener(keyListener);
        jTextField_1_2.addKeyListener(keyListener);
        jTextField_1_3.addKeyListener(keyListener);
        jTextField_1_4.addKeyListener(keyListener);
        jTextField_1_5.addKeyListener(keyListener);
        jTextField_1_7.addKeyListener(keyListener);
        jTextField_1_8.addKeyListener(keyListener);

        jTextField_2_0.addKeyListener(keyListener);
        jTextField_2_2.addKeyListener(keyListener);
        jTextField_2_3.addKeyListener(keyListener);
        jTextField_2_4.addKeyListener(keyListener);
        jTextField_2_5.addKeyListener(keyListener);
        jTextField_2_8.addKeyListener(keyListener);

        jTextField_3_1.addKeyListener(keyListener);
        jTextField_3_3.addKeyListener(keyListener);
        jTextField_3_5.addKeyListener(keyListener);
        jTextField_3_8.addKeyListener(keyListener);

        jTextField_4_0.addKeyListener(keyListener);
        jTextField_4_1.addKeyListener(keyListener);
        jTextField_4_2.addKeyListener(keyListener);
        jTextField_4_3.addKeyListener(keyListener);
        jTextField_4_5.addKeyListener(keyListener);
        jTextField_4_6.addKeyListener(keyListener);
        jTextField_4_7.addKeyListener(keyListener);
        jTextField_4_8.addKeyListener(keyListener);

        jTextField_5_0.addKeyListener(keyListener);
        jTextField_5_3.addKeyListener(keyListener);
        jTextField_5_5.addKeyListener(keyListener);
        jTextField_5_7.addKeyListener(keyListener);

        jTextField_6_0.addKeyListener(keyListener);
        jTextField_6_3.addKeyListener(keyListener);
        jTextField_6_4.addKeyListener(keyListener);
        jTextField_6_5.addKeyListener(keyListener);
        jTextField_6_6.addKeyListener(keyListener);
        jTextField_6_8.addKeyListener(keyListener);

        jTextField_7_0.addKeyListener(keyListener);
        jTextField_7_1.addKeyListener(keyListener);
        jTextField_7_3.addKeyListener(keyListener);
        jTextField_7_4.addKeyListener(keyListener);
        jTextField_7_5.addKeyListener(keyListener);
        jTextField_7_6.addKeyListener(keyListener);
        jTextField_7_7.addKeyListener(keyListener);
        jTextField_7_8.addKeyListener(keyListener);

        jTextField_8_1.addKeyListener(keyListener);
        jTextField_8_2.addKeyListener(keyListener);
        jTextField_8_4.addKeyListener(keyListener);
        jTextField_8_6.addKeyListener(keyListener);
        jTextField_8_7.addKeyListener(keyListener);
    }

    public void initializeTextboxFilters() {
        ((AbstractDocument) jTextField_0_1.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_0_2.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_0_4.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_0_6.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_0_7.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_1_0.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_1.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_2.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_4.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_7.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_1_8.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_2_0.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_2_2.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_2_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_2_4.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_2_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_2_8.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_3_1.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_3_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_3_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_3_8.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_4_0.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_1.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_2.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_6.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_7.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_4_8.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_5_0.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_5_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_5_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_5_7.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_6_0.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_6_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_6_4.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_6_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_6_6.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_6_8.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_7_0.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_1.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_3.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_4.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_5.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_7.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_7_8.getDocument()).setDocumentFilter(new LengthFilter(1));

        ((AbstractDocument) jTextField_8_1.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_8_2.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_8_4.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_8_6.getDocument()).setDocumentFilter(new LengthFilter(1));
        ((AbstractDocument) jTextField_8_7.getDocument()).setDocumentFilter(new LengthFilter(1));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            sudokuBoard = ImageIO.read(new File("src\\sudoku.png"));
        } catch (IOException e) {
        }
        g.drawImage(sudokuBoard, 80, 10, 450, 380, this);
        initializeTextboxPositions();
    }

    public void initializeTextboxPositions() {
        jTextField_0_1.setLocation(X_ORGIN + (1 * TEXTBOX_OFFSET), Y_ORGIN + (0 * TEXTBOX_OFFSET));
        jTextField_0_2.setLocation(X_ORGIN + (2 * TEXTBOX_OFFSET), Y_ORGIN + (0 * TEXTBOX_OFFSET));
        jTextField_0_4.setLocation(X_ORGIN + (4 * TEXTBOX_OFFSET), Y_ORGIN + (0 * TEXTBOX_OFFSET));
        jTextField_0_6.setLocation(X_ORGIN + (6 * TEXTBOX_OFFSET), Y_ORGIN + (0 * TEXTBOX_OFFSET));
        jTextField_0_7.setLocation(X_ORGIN + (7 * TEXTBOX_OFFSET), Y_ORGIN + (0 * TEXTBOX_OFFSET));

        jTextField_1_0.setLocation(X_ORGIN + (0 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_1.setLocation(X_ORGIN + (1 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_2.setLocation(X_ORGIN + (2 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_4.setLocation(X_ORGIN + (4 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_7.setLocation(X_ORGIN + (7 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));
        jTextField_1_8.setLocation(X_ORGIN + (8 * TEXTBOX_OFFSET), Y_ORGIN + (1 * TEXTBOX_OFFSET));

        jTextField_2_0.setLocation(X_ORGIN + (0 * TEXTBOX_OFFSET), Y_ORGIN + (2 * TEXTBOX_OFFSET));
        jTextField_2_2.setLocation(X_ORGIN + (2 * TEXTBOX_OFFSET), Y_ORGIN + (2 * TEXTBOX_OFFSET));
        jTextField_2_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (2 * TEXTBOX_OFFSET));
        jTextField_2_4.setLocation(X_ORGIN + (4 * TEXTBOX_OFFSET), Y_ORGIN + (2 * TEXTBOX_OFFSET));
        jTextField_2_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (2 * TEXTBOX_OFFSET));
        jTextField_2_8.setLocation(X_ORGIN + (8 * TEXTBOX_OFFSET), Y_ORGIN + (2 * TEXTBOX_OFFSET));

        jTextField_3_1.setLocation(X_ORGIN + (1 * TEXTBOX_OFFSET), Y_ORGIN + (3 * TEXTBOX_OFFSET));
        jTextField_3_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (3 * TEXTBOX_OFFSET));
        jTextField_3_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (3 * TEXTBOX_OFFSET));
        jTextField_3_8.setLocation(X_ORGIN + (8 * TEXTBOX_OFFSET), Y_ORGIN + (3 * TEXTBOX_OFFSET));

        jTextField_4_0.setLocation(X_ORGIN + (0 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_1.setLocation(X_ORGIN + (1 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_2.setLocation(X_ORGIN + (2 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_6.setLocation(X_ORGIN + (6 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_7.setLocation(X_ORGIN + (7 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));
        jTextField_4_8.setLocation(X_ORGIN + (8 * TEXTBOX_OFFSET), Y_ORGIN + (4 * TEXTBOX_OFFSET));

        jTextField_5_0.setLocation(X_ORGIN + (0 * TEXTBOX_OFFSET), Y_ORGIN + (5 * TEXTBOX_OFFSET));
        jTextField_5_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (5 * TEXTBOX_OFFSET));
        jTextField_5_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (5 * TEXTBOX_OFFSET));
        jTextField_5_7.setLocation(X_ORGIN + (7 * TEXTBOX_OFFSET), Y_ORGIN + (5 * TEXTBOX_OFFSET));

        jTextField_6_0.setLocation(X_ORGIN + (0 * TEXTBOX_OFFSET), Y_ORGIN + (6 * TEXTBOX_OFFSET));
        jTextField_6_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (6 * TEXTBOX_OFFSET));
        jTextField_6_4.setLocation(X_ORGIN + (4 * TEXTBOX_OFFSET), Y_ORGIN + (6 * TEXTBOX_OFFSET));
        jTextField_6_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (6 * TEXTBOX_OFFSET));
        jTextField_6_6.setLocation(X_ORGIN + (6 * TEXTBOX_OFFSET), Y_ORGIN + (6 * TEXTBOX_OFFSET));
        jTextField_6_8.setLocation(X_ORGIN + (8 * TEXTBOX_OFFSET), Y_ORGIN + (6 * TEXTBOX_OFFSET));

        jTextField_7_0.setLocation(X_ORGIN + (0 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_1.setLocation(X_ORGIN + (1 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_3.setLocation(X_ORGIN + (3 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_4.setLocation(X_ORGIN + (4 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_5.setLocation(X_ORGIN + (5 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_6.setLocation(X_ORGIN + (6 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_7.setLocation(X_ORGIN + (7 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));
        jTextField_7_8.setLocation(X_ORGIN + (8 * TEXTBOX_OFFSET), Y_ORGIN + (7 * TEXTBOX_OFFSET));

        jTextField_8_1.setLocation(X_ORGIN + (1 * TEXTBOX_OFFSET), Y_ORGIN + (8 * TEXTBOX_OFFSET));
        jTextField_8_2.setLocation(X_ORGIN + (2 * TEXTBOX_OFFSET), Y_ORGIN + (8 * TEXTBOX_OFFSET));
        jTextField_8_4.setLocation(X_ORGIN + (4 * TEXTBOX_OFFSET), Y_ORGIN + (8 * TEXTBOX_OFFSET));
        jTextField_8_6.setLocation(X_ORGIN + (6 * TEXTBOX_OFFSET), Y_ORGIN + (8 * TEXTBOX_OFFSET));
        jTextField_8_7.setLocation(X_ORGIN + (7 * TEXTBOX_OFFSET), Y_ORGIN + (8 * TEXTBOX_OFFSET));
    }

    //method: changePositions(int x, int y)
    //purpose: changes the positions of posX and posY for use later
    //x and y are based on the position of the textfield location and will
    //be used to input the integer inputted into the textfield at location posX, posY into the array
    public void changePositions(int x, int y) {
        System.out.println("Position (" + x + ", " + y + ")");
        posX = x;
        posY = y;
    }

    //method: checkAnswer
    //purpose: checks the user's array to that of the correct answer to make sure they match
    public boolean checkAnswer() {
        boolean correct = true;
        points = 540;
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                if (startBoard[i][j] != solution[i][j]) {
                    correct = false;
                    //Points can only be removed once per game for each box
                    // if (pointsTaken[i][j] == false) {
                    points -= 10;
                    //    pointsTaken[i][j] = true;
                    // }
                }
            }
        }

        System.out.println("Points: " + points);
        return correct;
    }

    //method: validatedKeyPressed
    //purpose: checks to make sure the key entered is a valid number 1 -> 9
    public static boolean validateKeyPressed(KeyEvent e) {
        if ((e.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (e.getKeyChar() == KeyEvent.VK_ESCAPE) || (e.getKeyChar() >= '1' && e.getKeyChar() <= '9')) {
            return true;
        }
        return false;
    }

    //method: actionListener for timerAL
    //purpose: Displays the time and date
    ActionListener timerAL = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy    HH:mm:ss");
            //get current date time with Date()
            Date date = new Date();
            //get current date time with Calendar()
            Calendar cal = Calendar.getInstance();

            datetime.setText(dateFormat.format(cal.getTime()));
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headline = new javax.swing.JLabel();
        datetime = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        jTextField_0_1 = new javax.swing.JTextField();
        jTextField_0_2 = new javax.swing.JTextField();
        jTextField_0_6 = new javax.swing.JTextField();
        jTextField_0_4 = new javax.swing.JTextField();
        jTextField_0_7 = new javax.swing.JTextField();
        jTextField_1_0 = new javax.swing.JTextField();
        jTextField_1_1 = new javax.swing.JTextField();
        jTextField_1_2 = new javax.swing.JTextField();
        jTextField_1_3 = new javax.swing.JTextField();
        jTextField_1_4 = new javax.swing.JTextField();
        jTextField_1_5 = new javax.swing.JTextField();
        jTextField_1_7 = new javax.swing.JTextField();
        jTextField_2_0 = new javax.swing.JTextField();
        jTextField_1_8 = new javax.swing.JTextField();
        jTextField_2_2 = new javax.swing.JTextField();
        jTextField_2_3 = new javax.swing.JTextField();
        jTextField_2_4 = new javax.swing.JTextField();
        jTextField_2_5 = new javax.swing.JTextField();
        jTextField_2_8 = new javax.swing.JTextField();
        jTextField_3_1 = new javax.swing.JTextField();
        jTextField_3_3 = new javax.swing.JTextField();
        jTextField_3_5 = new javax.swing.JTextField();
        jTextField_3_8 = new javax.swing.JTextField();
        jTextField_4_0 = new javax.swing.JTextField();
        jTextField_4_1 = new javax.swing.JTextField();
        jTextField_4_2 = new javax.swing.JTextField();
        jTextField_4_3 = new javax.swing.JTextField();
        jTextField_4_5 = new javax.swing.JTextField();
        jTextField_4_6 = new javax.swing.JTextField();
        jTextField_4_7 = new javax.swing.JTextField();
        jTextField_4_8 = new javax.swing.JTextField();
        jTextField_5_0 = new javax.swing.JTextField();
        jTextField_5_3 = new javax.swing.JTextField();
        jTextField_5_5 = new javax.swing.JTextField();
        jTextField_5_7 = new javax.swing.JTextField();
        jTextField_6_0 = new javax.swing.JTextField();
        jTextField_6_3 = new javax.swing.JTextField();
        jTextField_6_4 = new javax.swing.JTextField();
        jTextField_6_5 = new javax.swing.JTextField();
        jTextField_6_8 = new javax.swing.JTextField();
        jTextField_7_0 = new javax.swing.JTextField();
        jTextField_7_1 = new javax.swing.JTextField();
        jTextField_7_3 = new javax.swing.JTextField();
        jTextField_7_4 = new javax.swing.JTextField();
        jTextField_7_5 = new javax.swing.JTextField();
        jTextField_7_6 = new javax.swing.JTextField();
        jTextField_7_7 = new javax.swing.JTextField();
        jTextField_7_8 = new javax.swing.JTextField();
        jTextField_8_2 = new javax.swing.JTextField();
        jTextField_8_1 = new javax.swing.JTextField();
        jTextField_8_6 = new javax.swing.JTextField();
        jTextField_8_7 = new javax.swing.JTextField();
        jTextField_6_6 = new javax.swing.JTextField();
        jTextField_8_4 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        headline.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        headline.setForeground(new java.awt.Color(222, 0, 0));
        headline.setText("SUDOKU");

        datetime.setEditable(false);
        datetime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        datetime.setText("Date Time");
        datetime.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        jTextField_0_1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_0_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_0_1.setAutoscrolls(false);
        jTextField_0_1.setBorder(null);
        jTextField_0_1.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_0_1.setOpaque(false);
        jTextField_0_1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_0_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_0_1FocusGained(evt);
            }
        });

        jTextField_0_2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_0_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_0_2.setAutoscrolls(false);
        jTextField_0_2.setBorder(null);
        jTextField_0_2.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_0_2.setOpaque(false);
        jTextField_0_2.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_0_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_0_2FocusGained(evt);
            }
        });

        jTextField_0_6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_0_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_0_6.setAutoscrolls(false);
        jTextField_0_6.setBorder(null);
        jTextField_0_6.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_0_6.setOpaque(false);
        jTextField_0_6.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_0_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_0_6FocusGained(evt);
            }
        });

        jTextField_0_4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_0_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_0_4.setAutoscrolls(false);
        jTextField_0_4.setBorder(null);
        jTextField_0_4.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_0_4.setOpaque(false);
        jTextField_0_4.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_0_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_0_4FocusGained(evt);
            }
        });

        jTextField_0_7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_0_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_0_7.setAutoscrolls(false);
        jTextField_0_7.setBorder(null);
        jTextField_0_7.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_0_7.setOpaque(false);
        jTextField_0_7.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_0_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_0_7FocusGained(evt);
            }
        });

        jTextField_1_0.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_0.setAutoscrolls(false);
        jTextField_1_0.setBorder(null);
        jTextField_1_0.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_0.setOpaque(false);
        jTextField_1_0.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_0FocusGained(evt);
            }
        });

        jTextField_1_1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_1.setAutoscrolls(false);
        jTextField_1_1.setBorder(null);
        jTextField_1_1.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_1.setOpaque(false);
        jTextField_1_1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_1FocusGained(evt);
            }
        });

        jTextField_1_2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_2.setAutoscrolls(false);
        jTextField_1_2.setBorder(null);
        jTextField_1_2.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_2.setOpaque(false);
        jTextField_1_2.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_2FocusGained(evt);
            }
        });

        jTextField_1_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_3.setAutoscrolls(false);
        jTextField_1_3.setBorder(null);
        jTextField_1_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_3.setOpaque(false);
        jTextField_1_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_3FocusGained(evt);
            }
        });

        jTextField_1_4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_4.setAutoscrolls(false);
        jTextField_1_4.setBorder(null);
        jTextField_1_4.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_4.setOpaque(false);
        jTextField_1_4.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_4FocusGained(evt);
            }
        });

        jTextField_1_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_5.setAutoscrolls(false);
        jTextField_1_5.setBorder(null);
        jTextField_1_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_5.setOpaque(false);
        jTextField_1_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_5FocusGained(evt);
            }
        });

        jTextField_1_7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_7.setAutoscrolls(false);
        jTextField_1_7.setBorder(null);
        jTextField_1_7.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_7.setOpaque(false);
        jTextField_1_7.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_7FocusGained(evt);
            }
        });

        jTextField_2_0.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_2_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_2_0.setAutoscrolls(false);
        jTextField_2_0.setBorder(null);
        jTextField_2_0.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_2_0.setOpaque(false);
        jTextField_2_0.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_2_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_2_0FocusGained(evt);
            }
        });

        jTextField_1_8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_1_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_1_8.setAutoscrolls(false);
        jTextField_1_8.setBorder(null);
        jTextField_1_8.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_1_8.setOpaque(false);
        jTextField_1_8.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_1_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_1_8FocusGained(evt);
            }
        });

        jTextField_2_2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_2_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_2_2.setAutoscrolls(false);
        jTextField_2_2.setBorder(null);
        jTextField_2_2.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_2_2.setOpaque(false);
        jTextField_2_2.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_2_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_2_2FocusGained(evt);
            }
        });

        jTextField_2_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_2_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_2_3.setAutoscrolls(false);
        jTextField_2_3.setBorder(null);
        jTextField_2_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_2_3.setOpaque(false);
        jTextField_2_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_2_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_2_3FocusGained(evt);
            }
        });

        jTextField_2_4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_2_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_2_4.setAutoscrolls(false);
        jTextField_2_4.setBorder(null);
        jTextField_2_4.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_2_4.setOpaque(false);
        jTextField_2_4.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_2_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_2_4FocusGained(evt);
            }
        });

        jTextField_2_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_2_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_2_5.setAutoscrolls(false);
        jTextField_2_5.setBorder(null);
        jTextField_2_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_2_5.setOpaque(false);
        jTextField_2_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_2_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_2_5FocusGained(evt);
            }
        });

        jTextField_2_8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_2_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_2_8.setAutoscrolls(false);
        jTextField_2_8.setBorder(null);
        jTextField_2_8.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_2_8.setOpaque(false);
        jTextField_2_8.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_2_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_2_8FocusGained(evt);
            }
        });

        jTextField_3_1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_3_1.setAutoscrolls(false);
        jTextField_3_1.setBorder(null);
        jTextField_3_1.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_3_1.setOpaque(false);
        jTextField_3_1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_3_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_3_1FocusGained(evt);
            }
        });

        jTextField_3_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_3_3.setAutoscrolls(false);
        jTextField_3_3.setBorder(null);
        jTextField_3_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_3_3.setOpaque(false);
        jTextField_3_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_3_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_3_3FocusGained(evt);
            }
        });

        jTextField_3_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_3_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_3_5.setAutoscrolls(false);
        jTextField_3_5.setBorder(null);
        jTextField_3_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_3_5.setOpaque(false);
        jTextField_3_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_3_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_3_5FocusGained(evt);
            }
        });

        jTextField_3_8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_3_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_3_8.setAutoscrolls(false);
        jTextField_3_8.setBorder(null);
        jTextField_3_8.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_3_8.setOpaque(false);
        jTextField_3_8.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_3_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_3_8FocusGained(evt);
            }
        });

        jTextField_4_0.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_0.setAutoscrolls(false);
        jTextField_4_0.setBorder(null);
        jTextField_4_0.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_0.setOpaque(false);
        jTextField_4_0.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_0FocusGained(evt);
            }
        });

        jTextField_4_1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_1.setAutoscrolls(false);
        jTextField_4_1.setBorder(null);
        jTextField_4_1.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_1.setOpaque(false);
        jTextField_4_1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_1FocusGained(evt);
            }
        });

        jTextField_4_2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_2.setAutoscrolls(false);
        jTextField_4_2.setBorder(null);
        jTextField_4_2.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_2.setOpaque(false);
        jTextField_4_2.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_2FocusGained(evt);
            }
        });

        jTextField_4_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_3.setAutoscrolls(false);
        jTextField_4_3.setBorder(null);
        jTextField_4_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_3.setOpaque(false);
        jTextField_4_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_3FocusGained(evt);
            }
        });

        jTextField_4_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_5.setAutoscrolls(false);
        jTextField_4_5.setBorder(null);
        jTextField_4_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_5.setOpaque(false);
        jTextField_4_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_5FocusGained(evt);
            }
        });

        jTextField_4_6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_6.setAutoscrolls(false);
        jTextField_4_6.setBorder(null);
        jTextField_4_6.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_6.setOpaque(false);
        jTextField_4_6.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_6FocusGained(evt);
            }
        });

        jTextField_4_7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_7.setAutoscrolls(false);
        jTextField_4_7.setBorder(null);
        jTextField_4_7.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_7.setOpaque(false);
        jTextField_4_7.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_7FocusGained(evt);
            }
        });

        jTextField_4_8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_4_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_4_8.setAutoscrolls(false);
        jTextField_4_8.setBorder(null);
        jTextField_4_8.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_4_8.setOpaque(false);
        jTextField_4_8.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_4_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_4_8FocusGained(evt);
            }
        });

        jTextField_5_0.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_5_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_5_0.setAutoscrolls(false);
        jTextField_5_0.setBorder(null);
        jTextField_5_0.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_5_0.setOpaque(false);
        jTextField_5_0.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_5_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_5_0FocusGained(evt);
            }
        });

        jTextField_5_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_5_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_5_3.setAutoscrolls(false);
        jTextField_5_3.setBorder(null);
        jTextField_5_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_5_3.setOpaque(false);
        jTextField_5_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_5_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_5_3FocusGained(evt);
            }
        });

        jTextField_5_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_5_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_5_5.setAutoscrolls(false);
        jTextField_5_5.setBorder(null);
        jTextField_5_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_5_5.setOpaque(false);
        jTextField_5_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_5_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_5_5FocusGained(evt);
            }
        });

        jTextField_5_7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_5_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_5_7.setAutoscrolls(false);
        jTextField_5_7.setBorder(null);
        jTextField_5_7.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_5_7.setOpaque(false);
        jTextField_5_7.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_5_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_5_7FocusGained(evt);
            }
        });

        jTextField_6_0.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_6_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_6_0.setAutoscrolls(false);
        jTextField_6_0.setBorder(null);
        jTextField_6_0.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_6_0.setOpaque(false);
        jTextField_6_0.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_6_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_6_0FocusGained(evt);
            }
        });

        jTextField_6_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_6_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_6_3.setAutoscrolls(false);
        jTextField_6_3.setBorder(null);
        jTextField_6_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_6_3.setOpaque(false);
        jTextField_6_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_6_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_6_3FocusGained(evt);
            }
        });

        jTextField_6_4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_6_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_6_4.setAutoscrolls(false);
        jTextField_6_4.setBorder(null);
        jTextField_6_4.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_6_4.setOpaque(false);
        jTextField_6_4.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_6_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_6_4FocusGained(evt);
            }
        });

        jTextField_6_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_6_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_6_5.setAutoscrolls(false);
        jTextField_6_5.setBorder(null);
        jTextField_6_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_6_5.setOpaque(false);
        jTextField_6_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_6_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_6_5FocusGained(evt);
            }
        });

        jTextField_6_8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_6_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_6_8.setAutoscrolls(false);
        jTextField_6_8.setBorder(null);
        jTextField_6_8.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_6_8.setOpaque(false);
        jTextField_6_8.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_6_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_6_8FocusGained(evt);
            }
        });

        jTextField_7_0.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_0.setAutoscrolls(false);
        jTextField_7_0.setBorder(null);
        jTextField_7_0.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_0.setOpaque(false);
        jTextField_7_0.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_0FocusGained(evt);
            }
        });

        jTextField_7_1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_1.setAutoscrolls(false);
        jTextField_7_1.setBorder(null);
        jTextField_7_1.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_1.setOpaque(false);
        jTextField_7_1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_1FocusGained(evt);
            }
        });

        jTextField_7_3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_3.setAutoscrolls(false);
        jTextField_7_3.setBorder(null);
        jTextField_7_3.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_3.setOpaque(false);
        jTextField_7_3.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_3FocusGained(evt);
            }
        });

        jTextField_7_4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_4.setAutoscrolls(false);
        jTextField_7_4.setBorder(null);
        jTextField_7_4.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_4.setOpaque(false);
        jTextField_7_4.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_4FocusGained(evt);
            }
        });

        jTextField_7_5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_5.setAutoscrolls(false);
        jTextField_7_5.setBorder(null);
        jTextField_7_5.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_5.setOpaque(false);
        jTextField_7_5.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_5FocusGained(evt);
            }
        });

        jTextField_7_6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_6.setAutoscrolls(false);
        jTextField_7_6.setBorder(null);
        jTextField_7_6.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_6.setOpaque(false);
        jTextField_7_6.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_6FocusGained(evt);
            }
        });

        jTextField_7_7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_7.setAutoscrolls(false);
        jTextField_7_7.setBorder(null);
        jTextField_7_7.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_7.setOpaque(false);
        jTextField_7_7.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_7FocusGained(evt);
            }
        });

        jTextField_7_8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_7_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_7_8.setAutoscrolls(false);
        jTextField_7_8.setBorder(null);
        jTextField_7_8.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_7_8.setOpaque(false);
        jTextField_7_8.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_7_8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_7_8FocusGained(evt);
            }
        });

        jTextField_8_2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_8_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_8_2.setAutoscrolls(false);
        jTextField_8_2.setBorder(null);
        jTextField_8_2.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_8_2.setOpaque(false);
        jTextField_8_2.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_8_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_8_2FocusGained(evt);
            }
        });

        jTextField_8_1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_8_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_8_1.setAutoscrolls(false);
        jTextField_8_1.setBorder(null);
        jTextField_8_1.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_8_1.setOpaque(false);
        jTextField_8_1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_8_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_8_1FocusGained(evt);
            }
        });

        jTextField_8_6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_8_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_8_6.setAutoscrolls(false);
        jTextField_8_6.setBorder(null);
        jTextField_8_6.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_8_6.setOpaque(false);
        jTextField_8_6.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_8_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_8_6FocusGained(evt);
            }
        });

        jTextField_8_7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_8_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_8_7.setAutoscrolls(false);
        jTextField_8_7.setBorder(null);
        jTextField_8_7.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_8_7.setOpaque(false);
        jTextField_8_7.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_8_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_8_7FocusGained(evt);
            }
        });

        jTextField_6_6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_6_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_6_6.setAutoscrolls(false);
        jTextField_6_6.setBorder(null);
        jTextField_6_6.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_6_6.setOpaque(false);
        jTextField_6_6.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_6_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_6_6FocusGained(evt);
            }
        });

        jTextField_8_4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jTextField_8_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_8_4.setAutoscrolls(false);
        jTextField_8_4.setBorder(null);
        jTextField_8_4.setMaximumSize(new java.awt.Dimension(30, 30));
        jTextField_8_4.setOpaque(false);
        jTextField_8_4.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField_8_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_8_4FocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headline, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jTextField_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jTextField_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(jTextField_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(jTextField_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField_0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jTextField_5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jTextField_1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jTextField_4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jTextField_7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jTextField_7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jTextField_6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextField_8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datetime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headline, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(quit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        this.setVisible(false);
        MainFrm.setScore(0 + MainFrm.getScore());
        MainFrm.displayFinalScore();
    }//GEN-LAST:event_quitActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        boolean correct = checkAnswer();
        if (correct) {
            this.setVisible(false);
            MainFrm.setScore(points + MainFrm.getScore());
            MainFrm.displayFinalScore();
        } else {
            //JOptionPane.showMessageDialog(null, "Solution is incorrect", "Incorrect Solution", JOptionPane.OK_CANCEL_OPTION);
            int choice = JOptionPane.showConfirmDialog(null, "Solution is incorrect,\nClick 'OK' to end game.", "Incorrect Solution", JOptionPane.OK_CANCEL_OPTION);
            if (choice == 0) {
                this.setVisible(false);
                MainFrm.setScore(points + MainFrm.getScore());
                MainFrm.displayFinalScore();
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void jTextField_0_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_0_1KeyPressed
        changePositions(0, 1);
    }//GEN-LAST:event_jTextField_0_1KeyPressed

    private void jTextField_0_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_0_2KeyPressed
        changePositions(0, 2);
    }//GEN-LAST:event_jTextField_0_2KeyPressed

    private void jTextField_0_6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_0_6KeyPressed
        changePositions(0, 6);
    }//GEN-LAST:event_jTextField_0_6KeyPressed

    private void jTextField_0_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_0_4KeyPressed
        changePositions(0, 4);
    }//GEN-LAST:event_jTextField_0_4KeyPressed

    private void jTextField_0_7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_0_7KeyPressed
        changePositions(0, 7);
    }//GEN-LAST:event_jTextField_0_7KeyPressed

    private void jTextField_1_0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_0KeyPressed
        changePositions(1, 0);
    }//GEN-LAST:event_jTextField_1_0KeyPressed

    private void jTextField_1_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_1KeyPressed
        changePositions(1, 1);
    }//GEN-LAST:event_jTextField_1_1KeyPressed

    private void jTextField_1_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_2KeyPressed
        changePositions(1, 2);
    }//GEN-LAST:event_jTextField_1_2KeyPressed

    private void jTextField_1_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_3KeyPressed
        changePositions(1, 3);
    }//GEN-LAST:event_jTextField_1_3KeyPressed

    private void jTextField_1_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_4KeyPressed
        changePositions(1, 4);
    }//GEN-LAST:event_jTextField_1_4KeyPressed

    private void jTextField_1_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_5KeyPressed
        changePositions(1, 5);
    }//GEN-LAST:event_jTextField_1_5KeyPressed

    private void jTextField_1_7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_7KeyPressed
        changePositions(1, 7);
    }//GEN-LAST:event_jTextField_1_7KeyPressed

    private void jTextField_2_0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_2_0KeyPressed
        changePositions(2, 0);
    }//GEN-LAST:event_jTextField_2_0KeyPressed

    private void jTextField_1_8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_1_8KeyPressed
        changePositions(1, 8);
    }//GEN-LAST:event_jTextField_1_8KeyPressed

    private void jTextField_2_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_2_2KeyPressed
        changePositions(2, 2);
    }//GEN-LAST:event_jTextField_2_2KeyPressed

    private void jTextField_2_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_2_3KeyPressed
        changePositions(2, 3);
    }//GEN-LAST:event_jTextField_2_3KeyPressed

    private void jTextField_2_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_2_4KeyPressed
        changePositions(2, 4);
    }//GEN-LAST:event_jTextField_2_4KeyPressed

    private void jTextField_2_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_2_5KeyPressed
        changePositions(2, 5);
    }//GEN-LAST:event_jTextField_2_5KeyPressed

    private void jTextField_2_8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_2_8KeyPressed
        changePositions(2, 8);
    }//GEN-LAST:event_jTextField_2_8KeyPressed

    private void jTextField_3_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_3_1KeyPressed
        changePositions(3, 1);
    }//GEN-LAST:event_jTextField_3_1KeyPressed

    private void jTextField_3_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_3_3KeyPressed
        changePositions(3, 3);
    }//GEN-LAST:event_jTextField_3_3KeyPressed

    private void jTextField_3_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_3_5KeyPressed
        changePositions(3, 5);
    }//GEN-LAST:event_jTextField_3_5KeyPressed

    private void jTextField_3_8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_3_8KeyPressed
        changePositions(3, 8);
    }//GEN-LAST:event_jTextField_3_8KeyPressed

    private void jTextField_4_0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_0KeyPressed
        changePositions(4, 0);
    }//GEN-LAST:event_jTextField_4_0KeyPressed

    private void jTextField_4_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_1KeyPressed
        changePositions(4, 1);
    }//GEN-LAST:event_jTextField_4_1KeyPressed

    private void jTextField_4_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_2KeyPressed
        changePositions(4, 2);
    }//GEN-LAST:event_jTextField_4_2KeyPressed

    private void jTextField_4_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_3KeyPressed
        changePositions(4, 3);
    }//GEN-LAST:event_jTextField_4_3KeyPressed

    private void jTextField_4_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_5KeyPressed
        changePositions(4, 5);
    }//GEN-LAST:event_jTextField_4_5KeyPressed

    private void jTextField_4_6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_6KeyPressed
        changePositions(4, 6);
    }//GEN-LAST:event_jTextField_4_6KeyPressed

    private void jTextField_4_7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_7KeyPressed
        changePositions(4, 7);
    }//GEN-LAST:event_jTextField_4_7KeyPressed

    private void jTextField_4_8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_4_8KeyPressed
        changePositions(4, 8);
    }//GEN-LAST:event_jTextField_4_8KeyPressed

    private void jTextField_5_0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_5_0KeyPressed
        changePositions(5, 0);
    }//GEN-LAST:event_jTextField_5_0KeyPressed

    private void jTextField_5_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_5_3KeyPressed
        changePositions(5, 3);
    }//GEN-LAST:event_jTextField_5_3KeyPressed

    private void jTextField_5_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_5_5KeyPressed
        changePositions(5, 5);
    }//GEN-LAST:event_jTextField_5_5KeyPressed

    private void jTextField_5_7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_5_7KeyPressed
        changePositions(5, 7);
    }//GEN-LAST:event_jTextField_5_7KeyPressed

    private void jTextField_6_0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_6_0KeyPressed
        changePositions(6, 0);
    }//GEN-LAST:event_jTextField_6_0KeyPressed

    private void jTextField_6_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_6_3KeyPressed
        changePositions(6, 3);
    }//GEN-LAST:event_jTextField_6_3KeyPressed

    private void jTextField_6_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_6_4KeyPressed
        changePositions(6, 4);
    }//GEN-LAST:event_jTextField_6_4KeyPressed

    private void jTextField_6_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_6_5KeyPressed
        changePositions(6, 5);
    }//GEN-LAST:event_jTextField_6_5KeyPressed

    private void jTextField_6_8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_6_8KeyPressed
        changePositions(6, 8);
    }//GEN-LAST:event_jTextField_6_8KeyPressed

    private void jTextField_7_0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_0KeyPressed
        changePositions(7, 0);
    }//GEN-LAST:event_jTextField_7_0KeyPressed

    private void jTextField_7_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_1KeyPressed
        changePositions(7, 1);
    }//GEN-LAST:event_jTextField_7_1KeyPressed

    private void jTextField_7_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_3KeyPressed
        changePositions(7, 3);
    }//GEN-LAST:event_jTextField_7_3KeyPressed

    private void jTextField_7_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_4KeyPressed
        changePositions(7, 4);
    }//GEN-LAST:event_jTextField_7_4KeyPressed

    private void jTextField_7_5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_5KeyPressed
        changePositions(7, 5);
    }//GEN-LAST:event_jTextField_7_5KeyPressed

    private void jTextField_7_6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_6KeyPressed
        changePositions(7, 6);
    }//GEN-LAST:event_jTextField_7_6KeyPressed

    private void jTextField_7_7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_7KeyPressed
        changePositions(7, 7);
    }//GEN-LAST:event_jTextField_7_7KeyPressed

    private void jTextField_7_8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_7_8KeyPressed
        changePositions(7, 8);
    }//GEN-LAST:event_jTextField_7_8KeyPressed

    private void jTextField_8_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_8_2KeyPressed
        changePositions(8, 2);
    }//GEN-LAST:event_jTextField_8_2KeyPressed

    private void jTextField_8_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_8_1KeyPressed
        changePositions(8, 1);
    }//GEN-LAST:event_jTextField_8_1KeyPressed

    private void jTextField_8_6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_8_6KeyPressed
        changePositions(8, 6);
    }//GEN-LAST:event_jTextField_8_6KeyPressed

    private void jTextField_8_7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_8_7KeyPressed
        changePositions(8, 7);
    }//GEN-LAST:event_jTextField_8_7KeyPressed

    private void jTextField_6_6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_6_6KeyPressed
        changePositions(6, 6);
    }//GEN-LAST:event_jTextField_6_6KeyPressed

    private void jTextField_8_4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_8_4KeyPressed
        changePositions(8, 4);
    }//GEN-LAST:event_jTextField_8_4KeyPressed

    private void jTextField_0_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_0_1FocusGained
        changePositions(0, 1);
    }//GEN-LAST:event_jTextField_0_1FocusGained

    private void jTextField_0_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_0_2FocusGained
        changePositions(0, 2);
    }//GEN-LAST:event_jTextField_0_2FocusGained

    private void jTextField_0_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_0_6FocusGained
        changePositions(0, 6);
    }//GEN-LAST:event_jTextField_0_6FocusGained

    private void jTextField_0_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_0_4FocusGained
        changePositions(0, 4);
    }//GEN-LAST:event_jTextField_0_4FocusGained

    private void jTextField_0_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_0_7FocusGained
        changePositions(0, 7);
    }//GEN-LAST:event_jTextField_0_7FocusGained

    private void jTextField_1_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_0FocusGained
        changePositions(1, 0);
    }//GEN-LAST:event_jTextField_1_0FocusGained

    private void jTextField_1_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_1FocusGained
        changePositions(1, 1);
    }//GEN-LAST:event_jTextField_1_1FocusGained

    private void jTextField_1_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_2FocusGained

        changePositions(1, 2);
    }//GEN-LAST:event_jTextField_1_2FocusGained

    private void jTextField_1_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_3FocusGained

        changePositions(1, 3);
    }//GEN-LAST:event_jTextField_1_3FocusGained

    private void jTextField_1_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_4FocusGained
        changePositions(1, 4);
    }//GEN-LAST:event_jTextField_1_4FocusGained

    private void jTextField_1_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_5FocusGained
        changePositions(1, 5);
    }//GEN-LAST:event_jTextField_1_5FocusGained

    private void jTextField_1_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_7FocusGained
        changePositions(1, 7);
    }//GEN-LAST:event_jTextField_1_7FocusGained

    private void jTextField_2_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_2_0FocusGained
        changePositions(2, 0);
    }//GEN-LAST:event_jTextField_2_0FocusGained

    private void jTextField_1_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_1_8FocusGained
        changePositions(1, 8);
    }//GEN-LAST:event_jTextField_1_8FocusGained

    private void jTextField_2_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_2_2FocusGained
        changePositions(2, 2);
    }//GEN-LAST:event_jTextField_2_2FocusGained

    private void jTextField_2_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_2_3FocusGained
        changePositions(2, 3);
    }//GEN-LAST:event_jTextField_2_3FocusGained

    private void jTextField_2_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_2_4FocusGained
        changePositions(2, 4);
    }//GEN-LAST:event_jTextField_2_4FocusGained

    private void jTextField_2_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_2_5FocusGained
        // TODO add your handling code here:
        changePositions(2, 5);
    }//GEN-LAST:event_jTextField_2_5FocusGained

    private void jTextField_2_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_2_8FocusGained
        // TODO add your handling code here:
        changePositions(2, 8);
    }//GEN-LAST:event_jTextField_2_8FocusGained

    private void jTextField_3_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_3_1FocusGained
        // TODO add your handling code here:
        changePositions(3, 1);
    }//GEN-LAST:event_jTextField_3_1FocusGained

    private void jTextField_3_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_3_3FocusGained
        // TODO add your handling code here:
        changePositions(3, 3);
    }//GEN-LAST:event_jTextField_3_3FocusGained

    private void jTextField_3_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_3_5FocusGained
        // TODO add your handling code here:
        changePositions(3, 5);
    }//GEN-LAST:event_jTextField_3_5FocusGained

    private void jTextField_3_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_3_8FocusGained
        // TODO add your handling code here:
        changePositions(3, 8);
    }//GEN-LAST:event_jTextField_3_8FocusGained

    private void jTextField_4_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_0FocusGained
        // TODO add your handling code here:
        changePositions(4, 0);
    }//GEN-LAST:event_jTextField_4_0FocusGained

    private void jTextField_4_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_1FocusGained
        // TODO add your handling code here:
        changePositions(4, 1);
    }//GEN-LAST:event_jTextField_4_1FocusGained

    private void jTextField_4_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_2FocusGained
        // TODO add your handling code here:
        changePositions(4, 2);
    }//GEN-LAST:event_jTextField_4_2FocusGained

    private void jTextField_4_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_3FocusGained
        // TODO add your handling code here:
        changePositions(4, 3);
    }//GEN-LAST:event_jTextField_4_3FocusGained

    private void jTextField_4_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_5FocusGained
        // TODO add your handling code here:
        changePositions(4, 5);
    }//GEN-LAST:event_jTextField_4_5FocusGained

    private void jTextField_4_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_6FocusGained
        // TODO add your handling code here:
        changePositions(4, 6);
    }//GEN-LAST:event_jTextField_4_6FocusGained

    private void jTextField_4_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_7FocusGained
        // TODO add your handling code here:
        changePositions(4, 7);
    }//GEN-LAST:event_jTextField_4_7FocusGained

    private void jTextField_4_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_4_8FocusGained
        // TODO add your handling code here:
        changePositions(4, 8);
    }//GEN-LAST:event_jTextField_4_8FocusGained

    private void jTextField_5_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_5_0FocusGained
        // TODO add your handling code here:
        changePositions(5, 0);
    }//GEN-LAST:event_jTextField_5_0FocusGained

    private void jTextField_5_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_5_3FocusGained
        // TODO add your handling code here:
        changePositions(5, 3);
    }//GEN-LAST:event_jTextField_5_3FocusGained

    private void jTextField_5_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_5_5FocusGained
        // TODO add your handling code here:
        changePositions(5, 5);
    }//GEN-LAST:event_jTextField_5_5FocusGained

    private void jTextField_5_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_5_7FocusGained
        // TODO add your handling code here:
        changePositions(5, 7);
    }//GEN-LAST:event_jTextField_5_7FocusGained

    private void jTextField_6_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_6_0FocusGained
        // TODO add your handling code here:
        changePositions(6, 0);
    }//GEN-LAST:event_jTextField_6_0FocusGained

    private void jTextField_6_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_6_3FocusGained
        // TODO add your handling code here:
        changePositions(6, 3);
    }//GEN-LAST:event_jTextField_6_3FocusGained

    private void jTextField_6_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_6_4FocusGained
        // TODO add your handling code here:
        changePositions(6, 4);
    }//GEN-LAST:event_jTextField_6_4FocusGained

    private void jTextField_6_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_6_5FocusGained
        // TODO add your handling code here:
        changePositions(6, 5);
    }//GEN-LAST:event_jTextField_6_5FocusGained

    private void jTextField_6_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_6_8FocusGained
        // TODO add your handling code here:
        changePositions(6, 8);
    }//GEN-LAST:event_jTextField_6_8FocusGained

    private void jTextField_7_0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_0FocusGained
        // TODO add your handling code here:
        changePositions(7, 0);
    }//GEN-LAST:event_jTextField_7_0FocusGained

    private void jTextField_7_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_1FocusGained
        // TODO add your handling code here:
        changePositions(7, 1);
    }//GEN-LAST:event_jTextField_7_1FocusGained

    private void jTextField_7_3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_3FocusGained
        // TODO add your handling code here:
        changePositions(7, 3);
    }//GEN-LAST:event_jTextField_7_3FocusGained

    private void jTextField_7_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_4FocusGained
        // TODO add your handling code here:
        changePositions(7, 4);
    }//GEN-LAST:event_jTextField_7_4FocusGained

    private void jTextField_7_5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_5FocusGained
        // TODO add your handling code here:
        changePositions(7, 5);
    }//GEN-LAST:event_jTextField_7_5FocusGained

    private void jTextField_7_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_6FocusGained
        // TODO add your handling code here:
        changePositions(7, 6);
    }//GEN-LAST:event_jTextField_7_6FocusGained

    private void jTextField_7_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_7FocusGained
        // TODO add your handling code here:
        changePositions(7, 7);
    }//GEN-LAST:event_jTextField_7_7FocusGained

    private void jTextField_7_8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_7_8FocusGained
        // TODO add your handling code here:
        changePositions(7, 8);
    }//GEN-LAST:event_jTextField_7_8FocusGained

    private void jTextField_8_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_8_2FocusGained
        // TODO add your handling code here:
        changePositions(8, 2);
    }//GEN-LAST:event_jTextField_8_2FocusGained

    private void jTextField_8_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_8_1FocusGained
        // TODO add your handling code here:
        changePositions(8, 1);
    }//GEN-LAST:event_jTextField_8_1FocusGained

    private void jTextField_8_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_8_6FocusGained
        // TODO add your handling code here:
        changePositions(8, 6);
    }//GEN-LAST:event_jTextField_8_6FocusGained

    private void jTextField_8_7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_8_7FocusGained
        // TODO add your handling code here:
        changePositions(8, 7);
    }//GEN-LAST:event_jTextField_8_7FocusGained

    private void jTextField_6_6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_6_6FocusGained
        // TODO add your handling code here:
        changePositions(6, 6);
    }//GEN-LAST:event_jTextField_6_6FocusGained

    private void jTextField_8_4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_8_4FocusGained
        // TODO add your handling code here:
        changePositions(8, 4);
    }//GEN-LAST:event_jTextField_8_4FocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datetime;
    private javax.swing.JLabel headline;
    private javax.swing.JTextField jTextField_0_1;
    private javax.swing.JTextField jTextField_0_2;
    private javax.swing.JTextField jTextField_0_4;
    private javax.swing.JTextField jTextField_0_6;
    private javax.swing.JTextField jTextField_0_7;
    private javax.swing.JTextField jTextField_1_0;
    private javax.swing.JTextField jTextField_1_1;
    private javax.swing.JTextField jTextField_1_2;
    private javax.swing.JTextField jTextField_1_3;
    private javax.swing.JTextField jTextField_1_4;
    private javax.swing.JTextField jTextField_1_5;
    private javax.swing.JTextField jTextField_1_7;
    private javax.swing.JTextField jTextField_1_8;
    private javax.swing.JTextField jTextField_2_0;
    private javax.swing.JTextField jTextField_2_2;
    private javax.swing.JTextField jTextField_2_3;
    private javax.swing.JTextField jTextField_2_4;
    private javax.swing.JTextField jTextField_2_5;
    private javax.swing.JTextField jTextField_2_8;
    private javax.swing.JTextField jTextField_3_1;
    private javax.swing.JTextField jTextField_3_3;
    private javax.swing.JTextField jTextField_3_5;
    private javax.swing.JTextField jTextField_3_8;
    private javax.swing.JTextField jTextField_4_0;
    private javax.swing.JTextField jTextField_4_1;
    private javax.swing.JTextField jTextField_4_2;
    private javax.swing.JTextField jTextField_4_3;
    private javax.swing.JTextField jTextField_4_5;
    private javax.swing.JTextField jTextField_4_6;
    private javax.swing.JTextField jTextField_4_7;
    private javax.swing.JTextField jTextField_4_8;
    private javax.swing.JTextField jTextField_5_0;
    private javax.swing.JTextField jTextField_5_3;
    private javax.swing.JTextField jTextField_5_5;
    private javax.swing.JTextField jTextField_5_7;
    private javax.swing.JTextField jTextField_6_0;
    private javax.swing.JTextField jTextField_6_3;
    private javax.swing.JTextField jTextField_6_4;
    private javax.swing.JTextField jTextField_6_5;
    private javax.swing.JTextField jTextField_6_6;
    private javax.swing.JTextField jTextField_6_8;
    private javax.swing.JTextField jTextField_7_0;
    private javax.swing.JTextField jTextField_7_1;
    private javax.swing.JTextField jTextField_7_3;
    private javax.swing.JTextField jTextField_7_4;
    private javax.swing.JTextField jTextField_7_5;
    private javax.swing.JTextField jTextField_7_6;
    private javax.swing.JTextField jTextField_7_7;
    private javax.swing.JTextField jTextField_7_8;
    private javax.swing.JTextField jTextField_8_1;
    private javax.swing.JTextField jTextField_8_2;
    private javax.swing.JTextField jTextField_8_4;
    private javax.swing.JTextField jTextField_8_6;
    private javax.swing.JTextField jTextField_8_7;
    private javax.swing.JButton quit;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
