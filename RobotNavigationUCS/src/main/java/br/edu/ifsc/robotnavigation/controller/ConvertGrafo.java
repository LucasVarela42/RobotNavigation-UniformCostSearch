/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.controller;

import br.edu.ifsc.robotnavigation.model.Arco;
import br.edu.ifsc.robotnavigation.model.Grafo;
import br.edu.ifsc.robotnavigation.model.Vertice;

/**
 *
 * @author Aluno
 */
public class ConvertGrafo {

    private static NavigationButton buttons[][];
    private static int repNumeric[][];
    private static Vertice vertices[][];
    public static Grafo grafo;

    public static void convert(PanelGrid panel) {
        buttons = panel.getButtons();
        repNumeric = new int[buttons.length][buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (buttons[i][j].getTypeImage().equals("/background.png")) {
                    repNumeric[i][j] = 0;
                }
                if (buttons[i][j].getTypeImage().equals("/initial-position.png")) {
                    repNumeric[i][j] = 1;
                }
                if (buttons[i][j].getTypeImage().equals("/block.png")) {
                    repNumeric[i][j] = 2;
                }

                if (buttons[i][j].getTypeImage().equals("/final-position.png")) {
                    repNumeric[i][j] = 3;
                }
            }

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

    }

    public static void printVertices() {
        for (int i = 0; i < vertices.length; i++) {
            System.out.println();
            for (int j = 0; j < vertices.length; j++) {
                System.out.print(vertices[i][j] + "\t");
            }
        }
        //printArcos(vertices[8][8]);
    }

    public static void printArcos(Vertice v) {
        for (Arco a : v.obterArcos()) {
            System.out.println(a);
        }

    }

    private static void gerarVertices() {
        vertices = new Vertice[repNumeric.length][repNumeric.length];
        for (int i = 0; i < repNumeric.length; i++) {
            for (int j = 0; j < repNumeric.length; j++) {
                String rotulo = String.valueOf(buttons[i][j].hashCode());
                int tipo = repNumeric[i][j];
                Vertice v = new Vertice(rotulo, tipo);
                vertices[i][j] = v;

            }
        }
    }

    private static void gerarArcos() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i > 0) {
                    //verificar diagonais superiores
                    if (j > 0) {
                        verificarDiagonalSupEsquerda(vertices[i][j], vertices[i - 1][j - 1]);
                    }
                    if (j < vertices.length - 1) {
                        verificarDiagonalSupDireita(vertices[i][j], vertices[i - 1][j + 1]);
                    }

                }
                if (i < vertices.length - 1) {
                    //verificar diagonais inferiores
                    if (j > 0) {
                        verificarDiagonalInfEsquerda(vertices[i][j], vertices[i + 1][j - 1]);
                    }
                    if (j < vertices.length - 1) {
                        verificarDiagonalInfDireita(vertices[i][j], vertices[i + 1][j + 1]);
                    }
                }
                if (j > 0) {
                    //verificar a esquerda
                    verificarEsquerda(vertices[i][j], vertices[i][j - 1]);
                }
                if (j < vertices.length - 1) {
                    //verificar a direita
                    verificarDireita(vertices[i][j], vertices[i][j + 1]);
                }
                if (i > 0) {
                    //verificar em cima
                    verificarCima(vertices[i][j], vertices[i - 1][j]);
                }
                if (i < vertices.length - 1) {
                    //verificar em baixo
                    verificarBaixo(vertices[i][j], vertices[i + 1][j]);
                }

            }

        }
        System.out.println("Arcos gerados com sucesso!");
    }

    public static void gerarGrafo() {
        gerarVertices();
        gerarArcos();
        grafo = new Grafo();
        grafo.copiarVertices(vertices);
        System.out.println("O grafo foi gerado com sucesso!!");
    }

    private static void verificarDireita(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarEsquerda(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarCima(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarBaixo(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarDiagonalSupDireita(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1.4);
        }
    }

    private static void verificarDiagonalSupEsquerda(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1.4);
        }
    }

    private static void verificarDiagonalInfDireita(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1.4);
        }
    }

    private static void verificarDiagonalInfEsquerda(Vertice v1, Vertice v2) {
        if ((v1.getTipo() != 2) && (v2.getTipo() != 2)) {
            v1.adicionarArco(v2, 1.4);
        }
    }
}
