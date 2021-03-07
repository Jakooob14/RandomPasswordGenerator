package me.jakooob;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static String password = "";

    public static void main(String[] args) {
        createWindow();
    }
    public static void createWindow(){
        JFrame frame = new JFrame("Random Password Generator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        //characters
        JLabel charsLabel = new JLabel("Characters:");
        charsLabel.setBounds(10, 0, 100, 50);
        JTextField charsText = new JTextField();
        charsText.setBounds(85, 15, 100, 20);

        //generated
        JTextField generatedText = new JTextField();
        generatedText.setBounds(10, 145, 465, 25);

        //generate
        JButton createButton = new JButton("Generate");
        createButton.setBounds(100, 50, 100, 30);
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // this makes sure the button you are pressing is the button variable
                if(e.getSource() == createButton) {
                    String charsString = charsText.getText();
                    int charsInt = Integer.parseInt(charsString);
                        String[] characters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "/", "*", "-", "+", "\"", "'", "\\", "§", "<", ">", "_", "-"};
                        ArrayList<String> pass = new ArrayList<String>();
                        for (int i = 0; i < charsInt; i++) {
                            Random random = new Random();
                            int randomInt = random.nextInt(83);
                            String randomChar = characters[randomInt];
                            pass.add(randomChar);
                        }
                        String listString = String.join("", pass);
                        password = listString;
                        generatedText.setText(password);
                }
            }
        });

        // copy button
        JButton copyButton = new JButton("Copy to clipboard");
        copyButton.setBounds(10, 175, 140, 30);
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // this makes sure the button you are pressing is the button variable
                if(e.getSource() == copyButton) {
                    copyPassword();
                }
            }
        });

        // frame adds
        frame.add(copyButton);
        frame.add(generatedText);
        frame.add(createButton);
        frame.add(charsLabel);
        frame.add(charsText);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void copyPassword(){
        StringSelection stringSelection = new StringSelection(password);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
