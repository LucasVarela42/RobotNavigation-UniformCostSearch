/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.util;

import br.edu.ifsc.robotnavigation.model.Arco;
import br.edu.ifsc.robotnavigation.model.Grafo;
import br.edu.ifsc.robotnavigation.model.Vertice;

/**
 * Classe Helper
 * 
 * Nesta classe é convertido o PanelGrid para uma matriz numerica,
 * É gerado grafos, arcos, vertices
 * 
 * A classe está acoplada, é preciso refatorar num futuro
 * 
 * @author Lucas, Matheus
 */
public class RobotNavigationHelper {

    private static NavigationButton buttons[][];
    private static int repNumeric[][];
    private static Vertice vertices[][];
    private static Vertice verticeInicio;
    private static Vertice verticeFim;

    /**
     * Construtor vazio
     */
    public static Grafo grafo;

    /**
     * Método estatico para converter o painel para uma matriz numerica
     * 
     * A matriz criada é usada para gerar os vertices
     * 
     * @param panel
     */
    public static void convertPanel(PanelGrid panel) {
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

    /**
     * Método estatico para gerar a matriz de vertices a partir da matriz numerica
     * 
     * Guarda o vertice inicial bem como o final
     * 
     */
    private static void gerarVertices() {
        vertices = new Vertice[repNumeric.length][repNumeric.length];
        Vertice v = null;
        for (int i = 0; i < repNumeric.length; i++) {
            for (int j = 0; j < repNumeric.length; j++) {
                String rotulo = String.valueOf(buttons[i][j].hashCode());
                int tipo = repNumeric[i][j];
                if (tipo != 2) {
                    v = new Vertice(rotulo, tipo);
                    vertices[i][j] = v;
                }
                if (tipo == 1) {
                    verticeInicio = v;
                }
                if (tipo == 3) {
                    verticeFim = v;
                }
            }
        }
    }

    /**
     *
     * @return verticeInicio
     */
    public static Vertice getVerticeInicio() {
        return verticeInicio;
    }

    /**
     *
     * @return verticeFim
     */
    public static Vertice getVerticeFim() {
        return verticeFim;
    }

     /**
     * Método estatico para gerar os Arcos a partir dos vertices gerados
     * 
     * Verifica todos os possivel vizinhos
     * 
     */
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

    /**
     * Método estatico para gerar o Grafo
     * 
     * @return grafo
     */
    public static Grafo gerarGrafo() {
        gerarVertices();
        gerarArcos();
        grafo = new Grafo();
        grafo.copiarVertices(vertices);
        System.out.println("O grafo foi gerado com sucesso!!");
        return grafo;
    }

    private static void verificarDireita(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarEsquerda(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarCima(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarBaixo(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1);
        }
    }

    private static void verificarDiagonalSupDireita(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1.4);
        }
    }

    private static void verificarDiagonalSupEsquerda(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1.4);
        }
    }

    private static void verificarDiagonalInfDireita(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1.4);
        }
    }

    private static void verificarDiagonalInfEsquerda(Vertice v1, Vertice v2) {
        if ((v1 != null) && (v2 != null)) {
            v1.adicionarArco(v2, 1.4);
        }
    }
}
