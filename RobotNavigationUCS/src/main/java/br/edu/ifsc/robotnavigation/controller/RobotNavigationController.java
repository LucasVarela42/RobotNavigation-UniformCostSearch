/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import br.edu.ifsc.robotnavigation.model.CustoUniforme;
import br.edu.ifsc.robotnavigation.model.Grafo;
import br.edu.ifsc.robotnavigation.model.Vertice;
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
    private PanelGrid panelGrid;
    private ArrayList<NavigationButton> buttonsGrid = new ArrayList<>();

    public RobotNavigationController(RobotNavigationFrame view) {
        this.view = view;
        this.view.getjButtonStart().addActionListener(this);
        this.view.getjButtonGenerate().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.getjButtonStart()) {
            eventoStart();
        } else if (e.getSource() == this.view.getjButtonGenerate()) {
            eventoGenerateGrid();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        NavigationButton button;
        if (e.getButton() == MouseEvent.BUTTON1) { //Left
            System.out.println("Left click");
            button = (NavigationButton) e.getSource();
            if (button.getTypeImage().equals("/initial-position.png")) {
                button.setImagemBotao("/background.png");
            } else {
                button.setImagemBotao("/initial-position.png");
            }
        } else if (e.getButton() == MouseEvent.BUTTON2) { //Middle
            System.out.println("Middle click");
            button = (NavigationButton) e.getSource();
            if (button.getTypeImage().equals("/block.png")) {
                button.setImagemBotao("/background.png");
            } else {
                button.setImagemBotao("/block.png");
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) { //Right
            System.out.println("Right click");
            button = (NavigationButton) e.getSource();
            if (button.getTypeImage().equals("/final-position.png")) {
                button.setImagemBotao("/background.png");
            } else {
                button.setImagemBotao("/final-position.png");
            }
        }
    }

    private void eventoGenerateGrid() {
        this.view.getjPanelGrid().removeAll();
        panelGrid = new PanelGrid(
                this.view.getjPanelGrid(),
                (int) this.view.getjSpinnerSize().getValue());

        this.view.getjPanelGrid().repaint();
        this.view.pack();

        for (Component component : this.view.getjPanelGrid().getComponents()) {
            component.addMouseListener(this);
            buttonsGrid.add((NavigationButton) component);
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
        Grafo grafo;
        Vertice verticeInicio;
        Vertice verticeFim;
        ArrayList<Vertice> vertices;
        ConvertGrafo.convert(panelGrid);
        grafo = ConvertGrafo.gerarGrafo();

        verticeInicio = ConvertGrafo.getVerticeInicio();
        verticeFim = ConvertGrafo.getVerticeFim();

        vertices = CustoUniforme.dijkstra(grafo, verticeInicio);

        this.view.getjLabelCostValue().setText(String.format("%.2f", verticeFim.obterDistancia()));

        for (Vertice v : vertices) {
            System.out.println(v.toString() + "," + v.obterDistancia());
        }

    }
}
