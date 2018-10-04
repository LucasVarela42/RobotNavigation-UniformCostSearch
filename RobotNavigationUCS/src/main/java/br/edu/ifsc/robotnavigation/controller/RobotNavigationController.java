/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import br.edu.ifsc.robotnavigation.util.PanelGrid;
import br.edu.ifsc.robotnavigation.util.NavigationButton;
import br.edu.ifsc.robotnavigation.util.ConvertGrafo;
import br.edu.ifsc.robotnavigation.algorithm.Algoritmos;
import br.edu.ifsc.robotnavigation.model.Grafo;
import br.edu.ifsc.robotnavigation.model.Vertice;
import br.edu.ifsc.robotnavigation.view.RobotNavigationFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Duration;
import java.time.Instant;
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
        this.view.getjComboBoxAlgorithm().addActionListener(this);
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
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                //Left
                button = (NavigationButton) e.getSource();
                if (button.getTypeImage().equals("/initial-position.png")) {
                    button.setImagemBotao("/background.png");
                } else {
                    button.setImagemBotao("/initial-position.png");
                }
                break;
            case MouseEvent.BUTTON2:
                //Middle
                button = (NavigationButton) e.getSource();
                if (button.getTypeImage().equals("/block.png")) {
                    button.setImagemBotao("/background.png");
                } else {
                    button.setImagemBotao("/block.png");
                }
                break;
            case MouseEvent.BUTTON3:
                //Right
                button = (NavigationButton) e.getSource();
                if (button.getTypeImage().equals("/final-position.png")) {
                    button.setImagemBotao("/background.png");
                } else {
                    button.setImagemBotao("/final-position.png");
                }
                break;
            default:
                break;
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

        this.view.getjButtonStart().setEnabled(true);
    }

    private void eventoStart() {
        Grafo grafo;
        Instant start;
        Instant finish;
        Vertice resultado;
        ConvertGrafo.convert(panelGrid);
        grafo = ConvertGrafo.gerarGrafo();

        if (getSelectedAlgorithm() == 0) {
            start = Instant.now();
            resultado = Algoritmos.custoUniformeGrafo(
                    grafo,
                    ConvertGrafo.getVerticeInicio(),
                    ConvertGrafo.getVerticeFim());
            finish = Instant.now();
        } else {
            start = Instant.now();
            resultado = Algoritmos.custoUniformeArvore(
                    grafo,
                    ConvertGrafo.getVerticeInicio(),
                    ConvertGrafo.getVerticeFim());
            finish = Instant.now();
        }

        long timeElapsed = Duration.between(start, finish).toMillis();

        this.view.getjLabelCostValue().setText(String.format("%.2f",
                ConvertGrafo.getVerticeFim().obterDistancia())
                + " - " + timeElapsed + "ms");
        this.view.getjLabelExplored().setText(String.valueOf(Algoritmos.EXPLORADOS));
        this.view.getjLabelGenerated().setText(String.valueOf(Algoritmos.GERADOS));

        if (resultado != null) {
            mostrarCaminho(resultado);
        }
    }

    private int getSelectedAlgorithm() {
        return this.view.getjComboBoxAlgorithm().getSelectedIndex();
    }

    private void mostrarCaminho(Vertice resultado) {
        for (String rotulo : resultado.getCaminhoLista()) {
            for (NavigationButton navigationButton : buttonsGrid) {
                if (rotulo.equals(String.valueOf(navigationButton.hashCode()))) {
                    navigationButton.setImagemBotao("/path.png");
                }
            }
        }
    }

    //Mouse events
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
}
