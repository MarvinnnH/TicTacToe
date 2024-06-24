package TicTacToeAPP.gui;

import javax.swing.*;

public class CheckForEnd {
    public static boolean checkForWin(JButton[][] array) {

        //Reihen
        for (int i = 0; i < 3; i++) {
            if (checkLine(array[i][0].getText(), array[i][1].getText(), array[i][2].getText())) {
                return true;
            }
        }

        //Spalten
        for (int i = 0; i < 3; i++) {
            if (checkLine(array[0][i].getText(), array[1][i].getText(), array[2][i].getText())) {
                return true;
            }
        }

        //Diagonal
        if (checkLine(array[0][0].getText(), array[1][1].getText(), array[2][2].getText())) {
            return true;
        }
        if (checkLine(array[0][2].getText(), array[1][1].getText(), array[2][0].getText())) {
            return true;
        }

        return false;
    }

    private static boolean checkLine(String a, String b, String c) {
        return (!a.isEmpty() && a.equals(b) && b.equals(c));
    }

    public static boolean checkForDraw(JButton[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }


}
