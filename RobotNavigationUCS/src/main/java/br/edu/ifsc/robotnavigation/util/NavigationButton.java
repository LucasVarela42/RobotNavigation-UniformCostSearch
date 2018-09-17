/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.util;

import javax.swing.JButton;

/**
 *
 * @author Aluno
 */
public class NavigationButton extends JButton {

    private String pathImage;

    public NavigationButton(String icone) {
        this.pathImage = icone;
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(icone)));
    }

    public void setImagemBotao(String icone) {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(icone)));
        this.pathImage = icone;
    }

    public String getTypeImage() {
        return pathImage;
    }
}
