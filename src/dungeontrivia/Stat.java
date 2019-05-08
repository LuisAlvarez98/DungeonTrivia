/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

/**
 * Stat utilizada para las estadisticas de un jugador
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Stat {

    // Variables
    private String name;
    private String score;

    /**
     * Constructor Stat sin parametros
     */
    public Stat() {
        
    }

    /**
     * Constructor Stat
     * @param name un <code>String</code> con el nombre
     * @param score un <code>String</code> con el puntaje
     */
    public Stat(String name, String score) {
        this.name = name;
        this.score = score;
    }
    
    /**
     * Constructor
     * @param name un <code>String</code> con el nombre
     * @param stat un <code>Stat</code> con las estadisticas
     */
    Stat(String name, Stat stat) {
        this.name = name;
        this.score = score;
    }

    /**
     * Metodo para acceder al nombre
     * @return un <code>String</code> con el nombre
     */
    public String getName() {
        return name;
    }
    
    /**
     * Metodo para acceder el puntaje
     * @return un <code>String</code> con el puntaje
     */
    public String getScore() {
        return score;
    }
    
    /**
     * Metodo para modificar el nombre
     * @param name un <code>String</code> con el nuevo nombre
     */
    public void setName(String name) {
        this.name = name;
    }

}
