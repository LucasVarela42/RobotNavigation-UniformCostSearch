/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Aluno
 */
public class NavigationButton extends JButton {

    private Icon imagemBotao;

    public NavigationButton(String icone) {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(icone)));
    }

    public NavigationButton(Icon imagemBotao) {
        this.imagemBotao = imagemBotao;
        setIcon(imagemBotao);
    }

    public Icon getImagemBotao() {
        return imagemBotao;
    }

    public void setImagemBotao(String icone) {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(icone)));
    }

}
