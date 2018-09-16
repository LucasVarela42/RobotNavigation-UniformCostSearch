/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Aluno
 */
public class PanelGrid extends JPanel {

    private static int SIZE = 5;
    private static final String BACKGROUND_IMG = "/background.png";
    private static final Dimension BTN_PREF_SIZE = new Dimension(32, 32);
    private NavigationButton button;
    private NavigationButton buttons[][];

    public PanelGrid(JPanel panel, int side) {
        SIZE = side;
        panel.setLayout(new GridLayout(SIZE, SIZE, 0, 0));
        buttons = new NavigationButton[SIZE][SIZE];
        addButtons(panel);
    }

    private void addButtons(JPanel panel) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                button = new NavigationButton(BACKGROUND_IMG, i, j);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                //button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.LIGHT_GRAY));
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setPreferredSize(BTN_PREF_SIZE);
                buttons[i][j] = button;
                panel.add(button);
            }
        }
    }

    public NavigationButton[][] getButtons() {
        return buttons;
    }

}
