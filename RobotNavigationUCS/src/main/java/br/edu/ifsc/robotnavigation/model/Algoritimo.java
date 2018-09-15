/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Matheus
 */
public class Algoritimo {

    public static ArrayList<Vertice> dijkstra(Grafo g, Vertice s, Vertice f) {

        ArrayList<Vertice> borda = new ArrayList();

        //Zerando a distância e caminho de todos os vértices do grafo
        for (Vertice u : g.obterVertices()) {
            u.setCaminho("");
            u.zerarDistancia();
        }
        //Adicionando os adjacentes do vertice inicial na borda
        for (Vertice v : s.obterAdjacentes()) {
            borda.add(v);
        }
        Collections.sort(borda, new Comparator() {

            public int compare(Object o1, Object o2) {
                Arco a1 = (Arco) o1;
                Arco a2 = (Arco) o2;
                return a1.getPeso() < a2.getPeso() ? -1 : (a1.getPeso() > a2.getPeso() ? +1 : 0);
            }
        });

      
        while (!borda.isEmpty()) {
            borda.get(0);

        }
        return borda;
    }
}
