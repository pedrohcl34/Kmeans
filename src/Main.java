
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PedroLima
 */
public class Main {
    public static void main(String args[]){
        try {
            KMeansAvaliacao kmeansAvaliacao = new KMeansAvaliacao(3);
            System.out.println("---------------------------Clusters-----------------------------------------");
            kmeansAvaliacao.kmeans();
            kmeansAvaliacao.imprimirClusters();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
