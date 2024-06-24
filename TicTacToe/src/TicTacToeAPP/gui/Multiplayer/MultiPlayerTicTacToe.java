package TicTacToeAPP.gui.Multiplayer;

import TicTacToeAPP.gui.CheckForEnd;
import TicTacToeAPP.gui.Creators;
import TicTacToeAPP.gui.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MultiPlayerTicTacToe {
    private JFrame frame;
    private JLabel turnLabel;
    private JLabel winCounterLabel;

    private int winCounterPlayerOne = 0;
    private int winCounterPlayerTwo = 0;
    private int drawCounter = 0;

    JButton[][] buttons = new JButton[3][3];

    private boolean isPlayerOneTurn = true;
    private boolean gameOver;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiPlayerTicTacToe().GUI());
    }

    public void GUI() {
        JOptionPane.showMessageDialog(frame, "Rules: \n " +
                "On a square playing field measuring 3×3 fields, the two players take turns placing their symbol (one player with crosses, the other with circles) in an open field." +
                "\nThe first player to place three characters in a row, column or diagonal wins." +
                "\nHowever, if both players play optimally, neither can win and a tie will result." +
                "\nThis means that all nine fields are filled without a player being able to place the required characters in a row, column or diagonal. When one player ends the round with his turn, the other player starts the next one.");
        frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        gameOver = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = Creators.createFieldButton("", this.eventAt(i,j));
                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }

        //LABEL
        turnLabel = new JLabel("Player 1's turn", JLabel.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 20));

        winCounterLabel = new JLabel(getWinCounterText(), JLabel.CENTER);
        winCounterLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //PANEL
        mainPanel.add(turnLabel, BorderLayout.NORTH);
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(winCounterLabel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setSize(400, 400); // Set a reasonable size
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    private ActionListener eventAt(int i, int j) {
        return e -> eventAtV(i, j);
    }

    private void eventAtV(int i, int j) {
        if (gameOver) {
            return;
        }

        JButton buttonClicked = buttons[i][j];

        if (buttonClicked.getText().isEmpty()) {
            if (isPlayerOneTurn) {
                buttonClicked.setText("X");
                turnLabel.setText("Player 2's turn");
            } else {
                buttonClicked.setText("O");
                turnLabel.setText("Player 1's turn");
            }

            isPlayerOneTurn = !isPlayerOneTurn;

            //ENDE?
            if (CheckForEnd.checkForWin(buttons)) {
                gameOver = true;
                if (!isPlayerOneTurn) {
                    winCounterPlayerOne++;
                } else {
                    winCounterPlayerTwo++;
                }
                winCounterLabel.setText(getWinCounterText());
                askForRematch("Player " + (isPlayerOneTurn ? "2" : "1") + " wins!");
            }
            else{
                if (CheckForEnd.checkForDraw(buttons)) {
                    gameOver = true;
                    drawCounter++;
                    winCounterLabel.setText(getWinCounterText());
                    askForRematch("Draw!");
                }
            }


        }
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        gameOver = false;
    }

    private String getWinCounterText() {
        return "Player 1 Wins: " + winCounterPlayerOne + " | Player 2 Wins: " + winCounterPlayerTwo + " | Draws: " + drawCounter;
    }

    private void askForRematch(String message) {
        int choice = JOptionPane.showOptionDialog(frame,
                message + "   Do you want a rematch?",
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Rematch", "Back to Main Menu"},
                "Rematch");

        if (choice == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            Launcher launcher = new Launcher();
            launcher.GUI();
            frame.dispose();
        }
    }
}

