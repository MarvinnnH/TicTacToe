package TicTacToeAPP.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Creators {
    public static JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 100));
        button.setFont(menuButtonFont);
        button.addActionListener(actionListener);
        return button;
    }

    public static JTextArea createTextArea(String text) {
        JTextArea textArea= new JTextArea(text);
        textArea.setFont(menuTextFont);
        return textArea;
    }

    public static JLabel createPic(String path) {
        ImageIcon icon = new ImageIcon(Creators.class.getResource(path));
        return new JLabel(icon);

    }

    public static JButton createFieldButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 100));
        button.setFont(fieldButtonFont);
        button.addActionListener(actionListener);
        return button;
    }


    //FONT
    public static Font fieldButtonFont = new Font("Arial", Font.PLAIN, 40);
    public static Font menuButtonFont = new Font("Arial", Font.PLAIN, 50);
    public static Font menuTextFont = new Font("Arial", Font.PLAIN, 50);
}
