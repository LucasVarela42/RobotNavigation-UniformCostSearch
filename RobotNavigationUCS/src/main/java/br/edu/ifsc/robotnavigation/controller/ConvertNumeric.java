/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import br.edu.ifsc.robotnavigation.model.Vertice;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class ConvertNumeric {

    private static NavigationButton buttons[][];
    private static String repNumeric[][];
    private static ArrayList<Vertice> vertices;

    public static void convert(PanelGrid panel) {
        buttons = panel.getButtons();
        repNumeric = new String[buttons.length][buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getTypeImage().equals("/background.png")) {
                    repNumeric[i][j] = "0";
                }
                if (buttons[i][j].getTypeImage().equals("/initial-position.png")) {
                    repNumeric[i][j] = "1";
                }
                if (buttons[i][j].getTypeImage().equals("/block.png")) {
                    repNumeric[i][j] = "2";
                }

                if (buttons[i][j].getTypeImage().equals("/final-position.png")) {
                    repNumeric[i][j] = "3";
                }
            }
            gerarVertices();
        }
    }

    /**
     * *
     * Printa a representação numerica da grade de botoes * 0 - espaço vazio * 1
     * - posição inicial * 2 - obstaculos * 3 - posição final
     */
    public static void printNumeric() {
        for (int i = 0; i < repNumeric.length; i++) {
            System.out.println();
            for (int j = 0; j < repNumeric.length; j++) {
                System.out.print(repNumeric[i][j] + "\t");
            }
        }

        for (Vertice vertice : vertices) {
            System.out.println(vertice.getRotulo() + "(" + vertice.getTipo() + ") ");
        }
    }

    public static void gerarVertices() {
        vertices = new ArrayList<>();
        for (int i = 0; i < repNumeric.length; i++) {
            for (int j = 0; j < repNumeric.length; j++) {
                String rotulo = String.valueOf(buttons[i][j].hashCode());
                String tipo = repNumeric[i][j];
                Vertice v = new Vertice(rotulo, tipo);
                vertices.add(v);

            }
        }
    }

    private static void verificarDireita() {
    }

    private static void verificarEsquerda() {
    }

    private static void verificarCima() {
    }

    private static void verificarBaixo() {
    }

    private static void verificarDiagonalSupDireita() {
    }

    private static void verificarDiagonalSupEsquerda() {
    }

    private static void verificarDiagonalInfDireita() {
    }

    private static void verificarDiagonalInfEsquerda() {
    }
}
