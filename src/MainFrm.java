
/**
 * *************************************************************
 * file: MainFrm.java authors: Garrick Lee, Paul Chiou, Gabriel Talavera class:
 * CS 245 â€“ Programming Graphical User Interfaces
 *
 * assignment: Quarter Project date last modified: 02/27/2016
 *
 * purpose: JFrame for Project, 600x400, displays JPanels
 *
 ***************************************************************
 */
import java.awt.Color;
import javax.swing.*;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.awt.event.KeyEvent;

public class MainFrm {

    private static MainFrm instance = null;
    private static JFrame f;
    private static Splash splashScreen;
    private static Menu menu;
    private static Credits credits;
    private static HighScores scores;
    private static HangMan hangMan;
    private static FinalScore finalScore;
    private static Colors colors;
    private static Sudoku sudoku;
    private static int score;
    private static String userName = "abc";
    public static int[] highScoresList = new int[5];
    public static String[] highScoreNames = new String[]{"ABC", "ABC", "ABC", "ABC", "ABC"};
    public static boolean isHighScore = false;

    // method: MainFrm
    // purpose: used for Singleton
    protected MainFrm() {
    }

    // method: getInstance
    // purpose: Singleton
    public static MainFrm getInstance() {
        if (instance == null) {
            instance = new MainFrm();
        }
        return instance;
    }

    // method: start
    // purpose: this method creates the JFrame and displays the Splash screen
    //          then displays the main menu.
    private static void start() {
        createJFrame();
        displaySplash(3000);
        displayMenu();
    }

        // method: formKeyPressed
    // purpose: if f1 or esc is pressed do something
    private static void formKeyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F1) {
            System.out.println("F1 Pressed");
            JOptionPane.showMessageDialog(null, "Garrick Lee, 010418018\nPaul Chiou, 010944960\nGabriel Talavera, 010005164"
                    + "\nCS 245 Project \nWinter 2016", "Credits", JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("ESCAPE Pressed");
            dispose();
        }
    }
    
    // method: dispose
    // purpose: close program
    public static void dispose() {
        f.dispose();
        System.exit(0);
    }

    // method: createJFrame
    // purpose: this method sets the settings for the JFrame
    private static void createJFrame() {
        f.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        f.setFocusable(true);
        f.setSize(600, 400);
        f.setBackground(Color.BLACK);
        f.setLocationRelativeTo(null); // place JFrame in middle of screen
        f.setResizable(false);
        //f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    // method: displaySplash
    // purpose: this sets visibility for the JPanel to true,
    //          and adds this JPanel to the JFrame.
    //          Only displays for 3 seconds
    public static void displaySplash(int delay) {
        splashScreen.setVisible(true);
        f.add(splashScreen);
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
        }
        splashScreen.setVisible(false);
    }

    // method: displayMenu
    // purpose: this sets visibility for the JPanel to true,
    //          and adds this JPanel to the JFrame.
    public static void displayMenu() {
        // loadHighScores();
        menu.setVisible(true);
        f.add(menu);
        isHighScore = false;
        loadHighScores();
    }

    // method: displayCredits
    // purpose: this sets visibility for the JPanel to true,
    //          and adds this JPanel to the JFrame.
    public static void displayCredits() {
        credits.setVisible(true);
        f.add(credits);
    }

    // method: displayHighScores
    // purpose: this sets visibility for the JPanel to true,
    //          and adds this JPanel to the JFrame.
    public static void displayHighScores() {
        scores = new HighScores();
        scores.setVisible(true);
        f.add(scores);
    }

    // method: displayHangMan
    // purpose: this sets visibility for the JPanel to true,
    //          and adds this JPanel to the JFrame.
    public static void displayHangMan() {
        hangMan.setVisible(true);
        //finalScore.setVisible(false);
        f.add(hangMan);

    }

    // method: displayFinalScore
    // purpose: this sets visibility for the JPanel to true,
    //          and adds this JPanel to the JFrame.
    public static void displayFinalScore() {
        saveHighScores(highScoreNames, highScoresList);
        finalScore = new FinalScore();
        finalScore.setVisible(true);
        colors.setVisible(false);
        f.add(finalScore);
    }

    public static void displayColors() {
        colors = new Colors();
        hangMan.setVisible(false);
        colors.setVisible(true);
        f.add(colors);
    }

    public static void displaySudoku() {
        sudoku = new Sudoku();
        colors.setVisible(false);
        sudoku.setVisible(true);
        f.add(sudoku);
    }
    
    // method: getScore
    // purpose: this gets score
    public static int getScore() {
        return score;
    }

    // method: setScore
    // purpose: this sets score, also adds the score into the highScoresList
    //          and instantiates a FinalScore Panel with the new score.
    public static void setScore(int points) {
        score = points;
        //highScoresList.add(userName + "....." + score);
        //finalScore = new FinalScore();
    }

    // method: getUserName
    // purpose: this gets userName, if userName is empty set it as "ABC"
    public static String getUserName() {
        if (userName.isEmpty() || userName.equals(null)) {
            userName = "ABC";
        }
        return userName;
    }

    // method: setUserName
    // purpose: this sets userName
    public static void setUserName(String name) {
        userName = name;
    }

    public static void loadHighScores() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("HighScores.txt"));
            String line;
            for (int i = 0; i < 5; i++) {
                line = br.readLine();
                if (line == null) {
                    return;
                }
                highScoreNames[i] = line;
                highScoresList[i] = Integer.valueOf(br.readLine());
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
//        finally {
//            for(int i = 0; i< 5; i++){
//                System.out.println(highScoreNames[i] +"....." + highScoresList[i]);
//            }
//        }   
    }

    // method: saveHighScores
    // purpose: this method saves the high scores list and adds in the users
    // high score if it is high enough to be on the list
    public static void saveHighScores(String[] names, int[] scores) {
        boolean swapped = false;
        String tempName = "";
        int tempScore = 0;
        String tempName1 = "";
        int tempScore1 = 0;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("HighScores.txt", false));
            for (int i = 0; i < 5; i++) {
                if (score > scores[i]) {
                    if (swapped != true) {
                        tempScore = highScoresList[i];
                        tempName = highScoreNames[i];

                        highScoreNames[i] = userName;
                        highScoresList[i] = score;
                        swapped = true;
                        isHighScore = true;
                    } else { // push other scores down
                        tempName1 = highScoreNames[i];
                        tempScore1 = highScoresList[i];

                        highScoreNames[i] = tempName;
                        highScoresList[i] = tempScore;

                        tempScore = tempScore1;
                        tempName = tempName1;
                    }
                }
                writer.println(highScoreNames[i]);
                writer.println(highScoresList[i]);
            }
            writer.close();
        } catch (Exception ex) {
        }

    }

    // method: main
    // purpose: this instantiates the JFrame and JPanels, and starts
    public static void main(String[] args) {
        f = new JFrame();
        splashScreen = new Splash();
        menu = new Menu();
        credits = new Credits();
        scores = new HighScores();
        hangMan = new HangMan();

        start();
    }
}
