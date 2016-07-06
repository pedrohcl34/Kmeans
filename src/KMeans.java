
import java.util.ArrayList;
import java.util.List;

public class KMeans {
/*
    private static final int QTD_CLUSTERS = 3;
    private static final int QTD_POINTS = 15;
    private static final int COORDENADA_MINIMA = 0;
    private static final int COORDENADA_MAXIMA = 10;

    private List<Ponto> pontos;
    private List<Cluster> clusters;

    public KMeans() {
        this.pontos = new ArrayList();
        this.clusters = new ArrayList();
    }

    public static void main(String[] args) {
        KMeans kmeans = new KMeans();
        kmeans.init();
        kmeans.calcula();
    }

    public void init() {
        pontos = Ponto.criaPontosAleatorios(COORDENADA_MINIMA, COORDENADA_MAXIMA, QTD_POINTS);

        // Cria os clusters configurando centroides aleatórios
        for (int i = 0; i < QTD_CLUSTERS; i++) {
            Cluster cluster = new Cluster(i);
            Ponto centroide = Ponto.criaPontoAleatorio(COORDENADA_MINIMA, COORDENADA_MAXIMA);
            cluster.setCentroide(centroide);
            clusters.add(cluster);
        }

        // Imprime estado inicial
        imprimeClusters();
    }

    private void imprimeClusters() {
        for (int i = 0; i < QTD_CLUSTERS; i++) {
            Cluster cluster = clusters.get(i);
            cluster.imprimeCluster();
        }
    }

    // Função que calcula o K-Means, com metodo de iteração
    public void calcula() {
        boolean fim = false;
        int iteracao = 0;

        // Add in new data, one at a time, recalculating centroids with each new one. 
        while (!fim) {
            // Limpa os estados dos clusters
            limpaClusters();

            List<Ponto> ultimosCentroides = getCentroides();

            // Atribui pontos aos clusters mais próximos
            atribuiCluster();

            //Calculate novos centroids.
            calculaCentroides();

            iteracao++;

            List<Ponto> atuaisCentroides = getCentroides();

            // Calcula distancia total entre novo e velho centroide
            double distancia = 0;
            for (int i = 0; i < ultimosCentroides.size(); i++) {
                distancia += Ponto.calculaDistancia(ultimosCentroides.get(i), atuaisCentroides.get(i));
            }
            System.out.println("#################");
            System.out.println("Iteração: " + iteracao);
            System.out.println("Distâncias dos centróides: " + distancia);
            imprimeClusters();

            if (distancia == 0) {
                fim = true;
            }
        }
    }

    private void limpaClusters() {
        for (Cluster cluster : clusters) {
            cluster.limpaCluster();
        }
    }

    private List getCentroides() {
        List centroids = new ArrayList(QTD_CLUSTERS);
        for (Cluster cluster : clusters) {
            Ponto aux = cluster.getCentroide();
            Ponto ponto = new Ponto(aux.getX(), aux.getY());
            centroids.add(ponto);
        }
        return centroids;
    }

    private void atribuiCluster() {
        double max = Double.MAX_VALUE;
        double min = max;
        int pos_cluster = 0;
        double distance = 0.0;

        for (Ponto ponto : pontos) {
            min = max;
            for (int i = 0; i < QTD_CLUSTERS; i++) {
                Cluster cluster = clusters.get(i);
                distance = Ponto.calculaDistancia(ponto, cluster.getCentroide());
                if (distance < min) {
                    min = distance;
                    pos_cluster = i;
                }
            }
            ponto.setNumero_cluster(pos_cluster);
            clusters.get(pos_cluster).addPonto(ponto);
        }
    }

    private void calculaCentroides() {
        for (Cluster cluster : clusters) {
            double somaX = 0;
            double somaY = 0;
            List<Ponto> pontos = cluster.getPontos();
            int qtdPontos = pontos.size();

            for (Ponto ponto : pontos) {
                somaX += ponto.getX();
                somaY += ponto.getY();
            }

            Ponto centroide = cluster.getCentroide();
            if (qtdPontos > 0) {
                double newX = somaX / qtdPontos;
                double newY = somaY / qtdPontos;
                centroide.setX(newX);
                centroide.setY(newY);
            }
        }
    }
*/
}
