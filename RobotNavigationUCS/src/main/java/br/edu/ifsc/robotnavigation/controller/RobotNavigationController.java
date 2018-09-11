/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import br.edu.ifsc.robotnavigation.view.RobotNavigationFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class RobotNavigationController implements ActionListener, MouseListener {

    private RobotNavigationFrame view;
    private ArrayList<NavigationButton> buttonsGrid = new ArrayList<>();

    public RobotNavigationController(RobotNavigationFrame view) {
        this.view = view;

        this.view.getjButtonStart().addActionListener(this);

        for (Component component : this.view.getjPanelGrid().getComponents()) {
            component.addMouseListener(this);
            buttonsGrid.add((NavigationButton) component);
        }

        System.out.println(buttonsGrid);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.getjButtonStart()) {
            eventoStart();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        NavigationButton button;
        if (e.getButton() == MouseEvent.BUTTON1) { //Left
            System.out.println("Left click");
            button = (NavigationButton) e.getSource();
            button.setImagemBotao("/initial-position.png");
        } else if (e.getButton() == MouseEvent.BUTTON2) { //Middle
            System.out.println("Middle click");
            button = (NavigationButton) e.getSource();
            button.setImagemBotao("/block.png");
        } else if (e.getButton() == MouseEvent.BUTTON3) { //Right
            System.out.println("Right click");
            button = (NavigationButton) e.getSource();
            button.setImagemBotao("/final-position.png");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void eventoStart() {
    }
}
