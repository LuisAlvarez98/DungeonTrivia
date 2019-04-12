/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class Pregunta {
    private String pregunta;
     ArrayList<String> respuestas;
    
    public Pregunta(){
        this.pregunta = "";
    }
    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<String>();
    }
    public void setPregunta(String pregunta){
        this.pregunta = pregunta;
    }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }
    
    public String getPregunta(){
        return this.pregunta;
    }
    public void addAnswer(String ans){
        respuestas.add(ans);
    }
    public void printAnswers(){
        for(int i = 0; i < respuestas.size(); i++){
            System.out.println(respuestas.get(i));
        }
    }
}
