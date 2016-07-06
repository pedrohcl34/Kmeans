
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ponto {

    private double x;
    private double y;
    private int numero_cluster;

    public Ponto() {
    }

    public Ponto(double x, double y, int numero_cluster) {
        this.x = x;
        this.y = y;
        this.numero_cluster = numero_cluster;
    }

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getNumero_cluster() {
        return numero_cluster;
    }

    public void setNumero_cluster(int numero_cluster) {
        this.numero_cluster = numero_cluster;
    }

    // Função que calcula a distância entre dois pontos
    protected static double calculaDistancia(Ponto ponto1, Ponto ponto2) {
        return Math.sqrt(Math.pow((ponto1.getX() - ponto2.getX()), 2) + Math.pow((ponto1.getY() - ponto2.getY()), 2));
    }

    // Função que cria um ponto aleatório
    protected static Ponto criaPontoAleatorio(int minimo, int maximo) {
        Random random = new Random();
        double x = minimo + (maximo - minimo) * random.nextDouble();
        double y = minimo + (maximo - minimo) * random.nextDouble();
        return new Ponto(x, y);
    }

    // Função que retorna uma lista de pontos aleatórios
    protected static List<Ponto> criaPontosAleatorios(int min, int max, int quantidade) {
        List<Ponto> pontos = new ArrayList(quantidade);
        for (int i = 0; i < quantidade; i++) {
            pontos.add(criaPontoAleatorio(min, max));
        }
        return pontos;
    }

    // Função que transforma um ponto em uma String. Utilizado em exibições.
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
