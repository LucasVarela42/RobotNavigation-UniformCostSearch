/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Lucas
 */
public class CustoUniforme {

    //TODO Adaptar a busca de Dijkstra para busca uniforme
    public static ArrayList<Vertice> dijkstra(Grafo g, Vertice s, Vertice f) {
        Queue<Vertice> Q = new LinkedList();
        ArrayList<Vertice> S = new ArrayList();
        ArrayList<Vertice> borda = new ArrayList();
        
        
        //Zerando a distância e caminho de todos os vértices do grafo
        for (Vertice u : g.obterVertices()) {
            u.setCaminho("");
            u.zerarDistancia();
            //Q.add(u);
        }
        
       
        
        
        
        //Inicializando o vertice inicial com caminho vazio e distância 0
        s.setCaminho("");
        s.definirDistancia(0);

        while (!Q.isEmpty()) {
            //System.out.println(Q);
            //Pegar da fila
            Vertice u = Q.remove();
            
            //Obtendo os ADJ a partir dos arcos, e colorindo o vertice a partir dos destinos obtidos
            for (Arco arco : u.obterArcos()) {

                Vertice v = arco.getDestino();
                System.out.println("u: " + u + ", v: " + v);
                if (v.obterDistancia() > u.obterDistancia() + arco.getPeso()) {
                    //---
                    v.definirDistancia(u.obterDistancia() + arco.getPeso());
                    v.setCaminho(u.getCaminho());
                    //---
                }
            }
            S.add(u);
        }
        return S;
    }

}
