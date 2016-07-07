import java.io.FileNotFoundException;
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

  
    private List<AvaliacaoEstudante> individuos;
    private int quantidadeClusters;
    private List<Cluster> clusters;
    public KMeansAvaliacao(int quantidadeClusters) throws FileNotFoundException {
        this.quantidadeClusters = quantidadeClusters;
        clusters = new ArrayList<>();
        individuos = CarregarBase.lerBase("estudantes_questionario_base.csv");
        inicializacao();
    }

    public List<AvaliacaoEstudante> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(List<AvaliacaoEstudante> individuos) {
        this.individuos = individuos;
    }

    public int getQuantidadeClusters() {
        return quantidadeClusters;
    }

    public void setQuantidadeClusters(int quantidadeClusters) {
        this.quantidadeClusters = quantidadeClusters;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
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

    public void inicializacao() {

        // Cria os clusters configurando centroides aleatórios
        for (int i = 0; i < quantidadeClusters; i++) {
            Cluster cluster = new Cluster(i);
            AvaliacaoEstudante centroide = pontosAleatorio();
            while (cluster.getCentroide()==centroide) {
                centroide = pontosAleatorio();
            }

            cluster.setCentroide(centroide);

            clusters.add(cluster);
        }

    }

    public double distanciaEuclidiana(AvaliacaoEstudante ponto1, AvaliacaoEstudante ponto2) {
        double distancia = 0;

        for (int i = 0; i < 28; i++) {
            distancia += Math.pow(ponto1.getQuestionario()[i] - ponto2.getQuestionario()[i], 2);
        }

        return Math.sqrt(distancia);
    }

    public void agrupamentoPorCentroides() {
        double distancia = Double.MAX_VALUE;
        int centroideEscolhido = 0;
        for (AvaliacaoEstudante individuo : individuos) {
            for (int i = 0; i < clusters.size(); i++) {
                if (distanciaEuclidiana(clusters.get(i).getCentroide(), individuo) < distancia) {
                    distancia =  distanciaEuclidiana(clusters.get(i).getCentroide(), individuo);
                    centroideEscolhido = i;
                }
                
            }
            clusters.get(centroideEscolhido).addPonto(individuo);
        }
    }
    
    public AvaliacaoEstudante calcularIndividuoMedio(Cluster cluster){
        int mediaQuestoes[] = new int[28];
        for(int i=0;i<28;i++)
            mediaQuestoes[i] = 0;
        
        for(AvaliacaoEstudante individuo : cluster.getPontos()){
            for(int i=0;i<individuo.getQuestionario().length;i++)
                mediaQuestoes[i]+=individuo.getQuestionario()[i];
        }
        
        for(int i=0;i<28;i++){
            if(cluster.getPontos().size()>0)
                mediaQuestoes[i] = mediaQuestoes[i]/cluster.getPontos().size();
            else mediaQuestoes[i] =0;
        }
            
        AvaliacaoEstudante novoCentroide = new AvaliacaoEstudante(1, 1, 1, 1, 1);
        novoCentroide.setQuestionario(mediaQuestoes);
        return novoCentroide;
    }
    public boolean verificaQuestionario(int questionarioVelho[], int questionarioNovo[]){
        for(int i=0; i<questionarioVelho.length;i++)
            if(questionarioVelho[i]!=questionarioNovo[i])
                return false;
        return true;
    }
    
    public boolean houveMudancas(List<Cluster> clusters){
        for(Cluster cluster : clusters)
           if(!verificaQuestionario(cluster.getCentroideAntigo().getQuestionario(), cluster.getCentroide().getQuestionario()))
               return true;
        return false;
    }
    
    public void kmeans(){
        do{
           
            for(int i=0;i<clusters.size();i++){
                clusters.get(i).setCentroideAntigo(clusters.get(i).getCentroide());
                clusters.get(i).limpaCluster();
            }
            agrupamentoPorCentroides();
           for(Cluster cluster : clusters)
               cluster.setCentroide(calcularIndividuoMedio(cluster)); 
        }while(houveMudancas(clusters));
    }
    
    public void imprimirClusters(){
        for(Cluster cluster: clusters){
            System.out.print(cluster.getId());
            System.out.println("Número de indivíduos: "+ cluster.getPontos().size());
        }
    }
    
    
}
