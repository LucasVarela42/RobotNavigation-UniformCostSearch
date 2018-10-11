/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.algorithm;

import br.edu.ifsc.robotnavigation.model.Arco;
import br.edu.ifsc.robotnavigation.model.Grafo;
import br.edu.ifsc.robotnavigation.model.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe com os algoritmos de Custo minimo
 * Custo minimo com grafos
 * Custo minimo com arvore
 * @author Lucas, Matheus
 */
public class Algoritmos {

    /**
     * variavel para guardar os vertices explorados
     */
    public static int EXPLORADOS;

    /**
     * variavel para guardar os vertices gerados
     */
    public static int GERADOS;

    /**
     * variavel para guardar os vertices vizitados
     */
    public static int VIZITADOS;

    /**
     *
     * @param g - Grafo completo
     * @param start - Vertice inicial
     * @param goal - Vertice Final (Objetivo final)
     * @return result com a lista de caminhos realizados
     */
    public static Vertice custoUniformeGrafo(Grafo g, Vertice start, Vertice goal) {
        for (Vertice u : g.obterVertices()) {
            if (u != null) {
                u.zerarVisitas();
                u.zerarDistancia();
                u.setCaminhoLista(null);
            }
        }
        start.visitar();
        start.definirDistancia(0);
        EXPLORADOS = 0;
        GERADOS = 0;
        VIZITADOS = start.obterVisitado();
        Vertice result = null;
        boolean found = false;

        ArrayList<Vertice> explorados = new ArrayList();
        Queue<Vertice> queue = new LinkedList();
        queue.add(start);

        while (!queue.isEmpty() && (found == false)) {
            //Pegar da fila
            //System.out.println(Q);
            Vertice current = queue.remove();

            //Obtendo os ADJ a partir dos arcos, e colorindo o vertice a partir dos destinos obtidos
            for (Arco arco : current.obterArcos()) {
                //System.out.println("current: " + u + ", child: " + arco);
                Vertice child = arco.getDestino();

                if (child.obterDistancia() > current.obterDistancia() + arco.getPeso()) {
                    //---
                    child.definirDistancia(current.obterDistancia() + arco.getPeso());

                    ArrayList<String> caminhos = current.getCaminhoLista();
                    caminhos.add(current.getRotulo());
                    child.setCaminhoLista(caminhos);

                    if (child.obterVisitado() == 0) {
                        queue.add(child);
                        child.visitar();
                        VIZITADOS += child.obterVisitado();
                    }
                    //---
                }
            }
            explorados.add(current);

            if (current.getRotulo().equals(goal.getRotulo())) {
                found = true;
                result = current;
            }
        }
        result.getCaminhoLista().add(result.getRotulo());
        EXPLORADOS = explorados.size();
        GERADOS = explorados.size() + queue.size();
        return result;
    }

    /**
     *
     * @param g - Grafo completo (Adaptado para o algoritmo de arvore)
     * @param start - Vertice inicial
     * @param goal - Vertice Final (Objetivo final)
     * @return result com a lista de caminhos realizados
     */
    public static Vertice custoUniformeArvore(Grafo g, Vertice start, Vertice goal) {
        for (Vertice u : g.obterVertices()) {
            if (u != null) {
                u.zerarVisitas();
                u.zerarDistancia();
                u.setCaminhoLista(null);
            }
        }
        start.definirDistancia(0);
        EXPLORADOS = 0;
        GERADOS = 0;
        VIZITADOS = start.obterVisitado();
        Vertice result = null;
        boolean found = false;

        ArrayList<Vertice> explorados = new ArrayList();
        Queue<Vertice> queue = new LinkedList();
        queue.add(start);

        while (!queue.isEmpty() && (found == false)) {
            //Pegar da fila
            //System.out.println(Q);
            Vertice current = queue.remove();

            //Obtendo os ADJ a partir dos arcos, e colorindo o vertice a partir dos destinos obtidos
            for (Arco arco : current.obterArcos()) {
                //System.out.println("current: " + u + ", child: " + arco);
                Vertice child = arco.getDestino();

                if (child.obterDistancia() > current.obterDistancia() + arco.getPeso()) {
                    //---
                    child.definirDistancia(current.obterDistancia() + arco.getPeso());

                    ArrayList<String> caminhos = current.getCaminhoLista();
                    caminhos.add(current.getRotulo());
                    child.setCaminhoLista(caminhos);

                    queue.add(child);
                    child.visitar();
                    VIZITADOS += child.obterVisitado();
                    //---
                }
            }
            explorados.add(current);

            if (current.getRotulo().equals(goal.getRotulo())) {
                found = true;
                result = current;
            }
        }
        result.getCaminhoLista().add(result.getRotulo());
        EXPLORADOS = explorados.size();
        GERADOS = explorados.size() + queue.size();
        return result;
    }

}
