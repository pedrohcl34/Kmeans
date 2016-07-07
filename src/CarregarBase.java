/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroLima
 */
public class CarregarBase {
    public static List<AvaliacaoEstudante> lerBase(String fileName) throws FileNotFoundException {
        List<AvaliacaoEstudante> individuos = new ArrayList<AvaliacaoEstudante>();
            Scanner in = new Scanner(new File(fileName));
            //leitura da base de dados
            while(in.hasNext()){
                
                String linha[] = in.next().split(",");
                int instrutor = Integer.parseInt(linha[0]);
                int classe = Integer.parseInt(linha[1]);
                int numeroRepeteDisciplina = Integer.parseInt(linha[2]);
                int frequencia = Integer.parseInt(linha[3]);
                int dificuldade = Integer.parseInt(linha[4]);
                int questionario[] = new int[28];
                for(int i=5; i<linha.length;i++){
                    questionario[i-5] = Integer.parseInt(linha[i]);
                }
                AvaliacaoEstudante individuo = new AvaliacaoEstudante(instrutor, classe, numeroRepeteDisciplina, frequencia, dificuldade);
                individuo.setQuestionario(questionario);
                individuos.add(individuo);
            }
        
        return individuos;
    }
    
    
}
