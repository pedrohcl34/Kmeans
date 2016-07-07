
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
public class AvaliacaoEstudante {
private int Instructor;
private int codigoCurso;
private int quantidadeRepeticaoDisciplina;
private int codigoFrequencia;
private int nivelDificuldadeDisciplina;
int questionario[] = new int[28];

    public AvaliacaoEstudante(int Instructor, int codigoCurso, int quantidadeRepeticaoDisciplina, int codigoFrequencia, int nivelDificuldadeDisciplina) {
        this.Instructor = Instructor;
        this.codigoCurso = codigoCurso;
        this.quantidadeRepeticaoDisciplina = quantidadeRepeticaoDisciplina;
        this.codigoFrequencia = codigoFrequencia;
        this.nivelDificuldadeDisciplina = nivelDificuldadeDisciplina;
    }

    public int getInstructor() {
        return Instructor;
    }

    public void setInstructor(int Instructor) {
        this.Instructor = Instructor;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getQuantidadeRepeticaoDisciplina() {
        return quantidadeRepeticaoDisciplina;
    }

    public void setQuantidadeRepeticaoDisciplina(int quantidadeRepeticaoDisciplina) {
        this.quantidadeRepeticaoDisciplina = quantidadeRepeticaoDisciplina;
    }

    public int getCodigoFrequencia() {
        return codigoFrequencia;
    }

    public void setCodigoFrequencia(int codigoFrequencia) {
        this.codigoFrequencia = codigoFrequencia;
    }

    public int getNivelDificuldadeDisciplina() {
        return nivelDificuldadeDisciplina;
    }

    public void setNivelDificuldadeDisciplina(int nivelDificuldadeDisciplina) {
        this.nivelDificuldadeDisciplina = nivelDificuldadeDisciplina;
    }

    public int[] getQuestionario() {
        return questionario;
    }

    public void setQuestionario(int[] questionario) {
        this.questionario = questionario;
    }
    
@Override
   public String toString(){
      String saida =  "Instrutor: " + Instructor + 
"        \nCurso: "+codigoCurso +
"        \nQuantidade de Repetições da Disciplina: " + quantidadeRepeticaoDisciplina+
"        \nFrequência do Estudante: " + codigoFrequencia+
"        \nNível de Dificuldade da Disciplina: "+ nivelDificuldadeDisciplina;
      
      for(int i=0;i<questionario.length;i++)
          saida = saida + "\n Resposta Questão["+(i+1)+"]: " + questionario[i]; 
      
      return saida;
   }
    


}
