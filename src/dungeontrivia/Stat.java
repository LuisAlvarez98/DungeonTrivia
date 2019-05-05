/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

/**
 *
 * @author luisf
 */
public class Stat {

    private String name;
    private String score;

    public Stat() {
    }

    public Stat(String name, String score) {
        this.name = name;
        this.score = score;
    }

    Stat(String name, Stat stat) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

}
