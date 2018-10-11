/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
 */
package br.edu.ifsc.robotnavigation.model;

import java.util.ArrayList;

/**
 * Classe para abstrair grafos direcionados. A classe utiliza representação por
 * lista de adjacência. IFSC - Lages. 
 * Adaptação do codigo de grafos, criado por: Prof. Vilson Heck Junior
 */
public class Grafo {

    private final ArrayList<Vertice> vertices = new ArrayList();

    /**
     * Construtor vazio
     */
    public Grafo() {
    }

    /**
     *
     * @param rotulo
     * @param tipo
     */
    public void adicionarVertice(String rotulo, int tipo) {
        Vertice novo = new Vertice(rotulo, tipo);
        vertices.add(novo);
    }

    /**
     *
     * @return
     */
    public ArrayList<Vertice> obterVertices() {
        return this.vertices;
    }

    /**
     *
     * @param rotulo
     * @param tipo
     * @return
     */
    public Vertice pesquisaVertice(String rotulo, int tipo) {
        int indice = vertices.indexOf(new Vertice(rotulo, tipo));
        return (indice >= 0) ? vertices.get(indice) : null;
    }

    /**
     *
     * @return
     */
    public ArrayList<Arco> obterTodosOsArcos() {
        ArrayList<Arco> resultado = new ArrayList();
        for (Vertice vertice : vertices) {
            resultado.addAll(vertice.obterArcos());
        }
        return resultado;
    }

    /**
     *
     * @param v
     */
    public void copiarVertices(Vertice v[][]) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                vertices.add(v[i][j]);

            }
        }
    }
}
