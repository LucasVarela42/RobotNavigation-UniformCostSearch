/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Aluno
 */
public class PanelGrid extends JPanel {

    private static final int SIDE = 10;
    private static final String BACKGROUND_IMG = "/background.png";
    private static final Dimension BTN_PREF_SIZE = new Dimension(32, 32);
    private NavigationButton button;

    public PanelGrid(JPanel panel) {
        panel.setLayout(new GridLayout(SIDE, SIDE));
        addButtons(panel, SIDE);
    }

    private void addButtons(JPanel panel, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                button = new NavigationButton(BACKGROUND_IMG);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                button.setPreferredSize(BTN_PREF_SIZE);
                panel.add(button);
            }
        }
    }
}
