package TicTacToeAPP.gui;

import TicTacToeAPP.gui.Multiplayer.MultiPlayerTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Launcher {

    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Launcher().GUI());
    }

    public void GUI() {
        frame = new JFrame("TicTacToe-Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new FlowLayout());
        panel.setLayout(new GridLayout(0, 1));
        panel.add(icon);


        panel.add(startButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }



    private void eventStartButton(ActionEvent e) {
        panel.remove(startButton);
        panel.remove(exitButton);



        panel.add(singlePlayerButton);
        panel.add(multiPlayerButton);

        panel.revalidate();
        panel.repaint();
    }

    private void eventSinglePlayerButton(ActionEvent e) {
        panel.remove(singlePlayerButton);
        panel.remove(multiPlayerButton);

        panel.add(difficultyText);
        panel.add(difficultyOneButton);
        panel.add(difficultyTwoButton);
        panel.add(difficultyThreeButton);



        panel.revalidate();
        panel.repaint();
    }

    private void eventMultiPlayerButton(ActionEvent e) {
        panel.remove(singlePlayerButton);
        panel.remove(multiPlayerButton);

        panel.add(ticTacToeButton);
        panel.add(metaTicTacToeButton);

        panel.revalidate();
        panel.repaint();

    }

    private void eventDifficultyOneButton(ActionEvent e) {

    }

    private void eventDifficultyTwoButton(ActionEvent e) {

    }
    private void eventDifficultyThreeButton(ActionEvent e) {

    }

    private void eventTicTacToeButton(ActionEvent e){
            MultiPlayerTicTacToe Game = new MultiPlayerTicTacToe();
            Game.GUI();
            frame.dispose();

    }

    private void eventMetaTicTacToeButton(ActionEvent e){

    }



    //BUTTONS
    JButton startButton = Creators.createButton("START", this::eventStartButton);
    JButton exitButton = Creators.createButton("Exit", e -> System.exit(0));

    JButton singlePlayerButton = Creators.createButton("Singleplayer", this::eventSinglePlayerButton);
    JButton multiPlayerButton = Creators.createButton("Multiplayer", this::eventMultiPlayerButton);

    JButton difficultyOneButton = Creators.createButton("1", this::eventDifficultyOneButton);
    JButton difficultyTwoButton = Creators.createButton("2", this::eventDifficultyTwoButton);
    JButton difficultyThreeButton = Creators.createButton("3", this::eventDifficultyThreeButton);

    JButton ticTacToeButton = Creators.createButton("TicTacToe", this::eventTicTacToeButton);
    JButton metaTicTacToeButton = Creators.createButton("META-TicTacToe", this::eventMetaTicTacToeButton);

    //TEXTE
    JTextArea difficultyText = Creators.createTextArea("Choose the difficulty!");

    //BILDER
    JLabel icon = Creators.createPic("/TicTacToeAPP/gui/resources/test.png");







}

