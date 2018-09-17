/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
 */
package br.edu.ifsc.robotnavigation.model;

import java.util.ArrayList;

/**
 * Classe para abstrair vértices de grafos direcionados IFSC - Lages Adaptação
 * do codigo de grafos, criado por: Prof. Vilson Heck Junior
 */
public class Vertice {

    //Lista de arcos que saem do vértice
    private final ArrayList<Arco> arcos = new ArrayList();
    private final ArrayList<Vertice> adjacentes = new ArrayList();

    //Rótulo do vértice: serve para identificação
    private String rotulo;
    //tipo do vértice: serve para identificar o tipo do vertice atual
    private int tipo;

    //Quando o valor de visitado for 0 (zero) significa que o vértice ainda
    //não foi visitado pelo algoritmo. Em cada nova visita o método deve invocar
    //o método visitar() para incrementar este valor. O método zerarVisitas()
    //zera este valor novamente. O método obterVisitado() informa o valor atual.
    private int visitado = 0;

    //Algoritmos de caminhos podem precisar da informação de qual caminho foi
    //utilizado para se obter a distância informada. O caminho é um Array de String. 
    //Contendo os rótulos dos vértices utilizados para chegar até o vértice final
    private ArrayList<String> caminhoLista;

    //Vários algoritmos irão medir a distância de um vértice até outro. Este
    //atributo servirá como um "medidor auxiliar de distância", armazenando
    //temporariamente distâncias nas iterações dos algoritmos. Os métodos
    //definirDistancia(), zerarDistancia() e obterDistancia() devem ser usados.
    private double distancia = Double.POSITIVE_INFINITY;

    public Vertice(String rotulo, int tipo) {
        this.rotulo = rotulo;
        this.tipo = tipo;
    }

    public Vertice(int tipo) {
        this.tipo = tipo;
    }

    public void adicionarArco(Vertice destino, double peso) {
        this.arcos.add(new Arco(this, destino, peso));
    }

    public ArrayList<Arco> obterArcos() {
        return this.arcos;
    }

    public void visitar() {
        this.visitado++;
    }

    public int obterVisitado() {
        return this.visitado;
    }

    public void zerarVisitas() {
        this.visitado = 0;
    }

    public void zerarDistancia() {
        this.distancia = Double.POSITIVE_INFINITY;
    }

    public void definirDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double obterDistancia() {
        return this.distancia;
    }

    public int getTipo() {
        return tipo;
    }

    public String getRotulo() {
        return rotulo;
    }

    public ArrayList<String> getCaminhoLista() {
        return new ArrayList(this.caminhoLista);
    }

    public void setCaminhoLista(ArrayList<String> caminhoLista) {
        if (caminhoLista == null) {
            this.caminhoLista = new ArrayList();
        } else {
            this.caminhoLista = new ArrayList(caminhoLista);
        }
    }

    @Override
    public String toString() {
        return "(" + this.tipo + ")" + this.rotulo;
    }

    @Override
    public boolean equals(Object o) {
        return o.toString().equals(this.rotulo);
    }
}
