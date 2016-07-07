
import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private int id;
    private List<AvaliacaoEstudante> dados;
    private AvaliacaoEstudante centroide;
    private AvaliacaoEstudante centroideAntigo;
    public Cluster() {
    }

    public Cluster(int id, List dados, AvaliacaoEstudante centroid) {
        this.id = id;
        this.dados = dados;
        this.centroide = centroid;
        this.centroideAntigo = centroid;
    }

    public Cluster(int id) {
        this.id = id;
        this.dados = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AvaliacaoEstudante getCentroideAntigo() {
        return centroideAntigo;
    }

    public void setCentroideAntigo(AvaliacaoEstudante centroideAntigo) {
        this.centroideAntigo = centroideAntigo;
    }

    public List<AvaliacaoEstudante> getPontos() {
        return dados;
    }

    public void setPontos(List dados) {
        this.dados = dados;
    }

    public AvaliacaoEstudante getCentroide() {
        return centroide;
    }

    public void setCentroide(AvaliacaoEstudante centroide) {
        this.centroide = centroide;
    }

    public void addPonto(AvaliacaoEstudante individuo) {
        this.dados.add(individuo);
    }

    public void removePonto(AvaliacaoEstudante individuo) {
        this.dados.remove(individuo);
    }

    public void limpaCluster() {
        dados.clear();
    }

    public void imprimeCluster() {
        System.out.println("[Cluster: " + id + "]");
        System.out.println("[Centroide: " + centroide + "]");
        System.out.println("[Pontos: \n");
        for (AvaliacaoEstudante individuo : dados) {
            System.out.println(individuo);
        }
        System.out.println("]");
    }
}
