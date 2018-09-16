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
 *
 * @author Lucas
 */
public class CustoUniforme {

    public static Vertice custoUniforme(Grafo g, Vertice start, Vertice goal) {
        for (Vertice u : g.obterVertices()) {
            if (u != null) {
                u.zerarDistancia();
                u.setCaminhoLista(null);
            }
        }
        start.definirDistancia(0);

        Vertice result = null;
        boolean found = false;

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
                    //---
                }
            }
            if (current.getRotulo().equals(goal.getRotulo())) {
                found = true;
                result = current;
            }
        }
        return result;
    }

}
