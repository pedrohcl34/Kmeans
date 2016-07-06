
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ofdesousa
 */
public class KMeansAvaliacao {
    
    private List<AvaliacaoEstudante> pontos;
    private List<AvaliacaoEstudante> individuos;
    private int quantidadeClusters;
    private List<Cluster> clusters;
    
    public KMeansAvaliacao(int quantidadeClusters) {
        
    }
    
    public List<AvaliacaoEstudante> pontosAleatorios() {
        List<AvaliacaoEstudante> escolhidos = new ArrayList<AvaliacaoEstudante>();
        for (int i = 0; i < quantidadeClusters; i++) {
            int valor = new Random().nextInt(individuos.size());
            while (escolhidos.contains(individuos.get(valor))) {
                valor = new Random().nextInt(individuos.size());
            }
            escolhidos.add(individuos.get(valor));
        }
        return escolhidos;
    }
    
    public AvaliacaoEstudante pontosAleatorio() {
        
        int valor = new Random().nextInt(individuos.size());
        
        return individuos.get(valor);
    }
    
   
    
    public void init() {

        // Cria os clusters configurando centroides aleatórios
        for (int i = 0; i < quantidadeClusters; i++) {
            Cluster cluster = new Cluster(i);
            AvaliacaoEstudante centroide = pontosAleatorio();
            while(individuos.contains(centroide))
                centroide = pontosAleatorio();
            cluster.setCentroide(centroide);
            clusters.add(cluster);
        }

        // Imprime estado inicial
    }
}
