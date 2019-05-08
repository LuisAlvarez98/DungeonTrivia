/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.util.ArrayList;

/**
 * Pregunta utilizada para crear las preguntas
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Pregunta {

    // Variables
    private String pregunta;
    private String type;

    ArrayList<String> respuestas;

    /**
     * Constructor Pregunta
     */
    public Pregunta() {
        this.pregunta = "";
    }
    /**
     * 
     * @param pregunta
     * @param type
     * @param respuestas 
     */
    public Pregunta(String pregunta, String type, ArrayList<String> respuestas) {
        this.pregunta = pregunta;
        this.type = type;
        this.respuestas = respuestas;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Constructor Pregunta
     *
     * @param pregunta un <code>String</code> con la pregunta
     */
    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<String>();
    }

    /**
     * Metodo para acceder a las respuestas
     *
     * @return un <code>ArrayList<String></code> con las respuestas
     */
    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    /**
     * Metodo para acceder la pregunta
     *
     * @return
     */
    public String getPregunta() {
        return this.pregunta;
    }

    /**
     * Metodo para modificar la pregunta
     *
     * @param pregunta un <code>String</code> con la pregunta
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * Metodo para modificar las respuestas
     *
     * @param respuestas un <code>ArrayList<String></code> con las respuestas
     */
    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     * Metodo para agregar una respuesta al arreglo de respuestas
     *
     * @param ans un <code>String</code> con la nueva respuesta
     */
    public void addAnswer(String ans) {
        respuestas.add(ans);
    }

    /**
     * Metodo para imprimir las respuestas
     */
    public void printAnswers() {
        for (int i = 0; i < respuestas.size(); i++) {
            System.out.println(respuestas.get(i));
        }
    }
}
