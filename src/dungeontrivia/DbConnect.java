package dungeontrivia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DbConnect Class es utilizado para poder conectar la aplicacion de Java al
 * servidor de MySQL y acceder a la informacion de la base de datos.
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class DbConnect {

    /**
     * Constructor con el proposito de conectar la aplicacion al servidor
     *
     */
    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //DungeonTrivia.con = DriverManager.getConnection("jdbc:mysql://localhost:3308/dungeontrivia", "root", "");
            DungeonTrivia.con = DriverManager.getConnection("jdbc:mysql://dungeontriviafinal.cyqk3zuszau6.us-east-2.rds.amazonaws.com:3306/dungeontrivia", "lfas98", "pipepipe");
            DungeonTrivia.st = DungeonTrivia.con.createStatement();
            System.out.println("Connected to DB.");

        } catch (Exception e) {
            DungeonTrivia.offline = true;
            e.printStackTrace();
            System.out.print("offline 404 ");
        }
    }

    /**
     * Obtiene los datos del Highscore
     *
     * @return stats un <code>Stat</code> con un arreglo de estadisticas
     */
    public ArrayList<Stat> getHighscores() {
        ArrayList<Stat> stats = new ArrayList<Stat>();

        try {

            String query = "SELECT * FROM stats ORDER BY stat DESC LIMIT 5";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                String name = DungeonTrivia.rs.getString("name");
                String stat = DungeonTrivia.rs.getString("stat");
                stats.add(new Stat(name, stat));
            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return stats;
    }

    /**
     * getAllTheQuestions Query
     *
     * @return questions
     */
    public ArrayList<Pregunta> getQuestions() {
        ArrayList<Pregunta> questions = new ArrayList<Pregunta>();

        try {

            String query = "SELECT * FROM questions";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                ArrayList<String> respuestas = new ArrayList<String>();
                String question = DungeonTrivia.rs.getString("question");
                String type = DungeonTrivia.rs.getString("type");
                String ans1 = DungeonTrivia.rs.getString("ans1");
                String ans2 = DungeonTrivia.rs.getString("ans2");
                String ans3 = DungeonTrivia.rs.getString("ans3");
                respuestas.add(ans1);
                respuestas.add(ans2);
                respuestas.add(ans3);

                questions.add(new Pregunta(question, type, respuestas));

            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return questions;
    }

    /**
     * get math questions Query
     *
     * @return questions
     */
    public ArrayList<Pregunta> getMathQuestions() {
        ArrayList<Pregunta> questions = new ArrayList<Pregunta>();

        try {

            String query = "SELECT * FROM questions WHERE type = 'math'";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                ArrayList<String> respuestas = new ArrayList<String>();
                String question = DungeonTrivia.rs.getString("question");
                String type = DungeonTrivia.rs.getString("type");
                String ans1 = DungeonTrivia.rs.getString("ans1");
                String ans2 = DungeonTrivia.rs.getString("ans2");
                String ans3 = DungeonTrivia.rs.getString("ans3");
                respuestas.add(ans1);
                respuestas.add(ans2);
                respuestas.add(ans3);

                questions.add(new Pregunta(question, type, respuestas));

            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return questions;
    }

    /**
     * get cs questions Query
     *
     * @return questions
     */
    public ArrayList<Pregunta> getCSQuestions() {
        ArrayList<Pregunta> questions = new ArrayList<Pregunta>();

        try {

            String query = "SELECT * FROM questions WHERE type = 'cs'";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                ArrayList<String> respuestas = new ArrayList<String>();
                String question = DungeonTrivia.rs.getString("question");
                String type = DungeonTrivia.rs.getString("type");
                String ans1 = DungeonTrivia.rs.getString("ans1");
                String ans2 = DungeonTrivia.rs.getString("ans2");
                String ans3 = DungeonTrivia.rs.getString("ans3");
                respuestas.add(ans1);
                respuestas.add(ans2);
                respuestas.add(ans3);

                questions.add(new Pregunta(question, type, respuestas));

            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return questions;
    }

    /**
     * get science questions Query
     *
     * @return questions
     */
    public ArrayList<Pregunta> getScienceQuestions() {
        ArrayList<Pregunta> questions = new ArrayList<Pregunta>();

        try {

            String query = "SELECT * FROM questions WHERE type = 'science'";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                ArrayList<String> respuestas = new ArrayList<String>();
                String question = DungeonTrivia.rs.getString("question");
                String type = DungeonTrivia.rs.getString("type");
                String ans1 = DungeonTrivia.rs.getString("ans1");
                String ans2 = DungeonTrivia.rs.getString("ans2");
                String ans3 = DungeonTrivia.rs.getString("ans3");
                respuestas.add(ans1);
                respuestas.add(ans2);
                respuestas.add(ans3);

                questions.add(new Pregunta(question, type, respuestas));

            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return questions;
    }

    /**
     * get geography questions Query
     *
     * @return questions
     */
    public ArrayList<Pregunta> getGeographyQuestions() {
        ArrayList<Pregunta> questions = new ArrayList<Pregunta>();

        try {

            String query = "SELECT * FROM questions WHERE type = 'geography'";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                ArrayList<String> respuestas = new ArrayList<String>();
                String question = DungeonTrivia.rs.getString("question");
                String type = DungeonTrivia.rs.getString("type");
                String ans1 = DungeonTrivia.rs.getString("ans1");
                String ans2 = DungeonTrivia.rs.getString("ans2");
                String ans3 = DungeonTrivia.rs.getString("ans3");
                respuestas.add(ans1);
                respuestas.add(ans2);
                respuestas.add(ans3);

                questions.add(new Pregunta(question, type, respuestas));

            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return questions;
    }

    /**
     * get history questions Query
     *
     * @return questions
     */
    public ArrayList<Pregunta> getHistoryQuestions() {
        ArrayList<Pregunta> questions = new ArrayList<Pregunta>();

        try {

            String query = "SELECT * FROM questions WHERE type = 'history'";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                ArrayList<String> respuestas = new ArrayList<String>();
                String question = DungeonTrivia.rs.getString("question");
                String type = DungeonTrivia.rs.getString("type");
                String ans1 = DungeonTrivia.rs.getString("ans1");
                String ans2 = DungeonTrivia.rs.getString("ans2");
                String ans3 = DungeonTrivia.rs.getString("ans3");
                respuestas.add(ans1);
                respuestas.add(ans2);
                respuestas.add(ans3);

                questions.add(new Pregunta(question, type, respuestas));

            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return questions;
    }

    /*
        Insert
     */
    void insertTop(String name, int score) {
        try {
            DungeonTrivia.st.execute("INSERT INTO stats " + "VALUES (''," + name + "," + score +")");
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
    }
}
