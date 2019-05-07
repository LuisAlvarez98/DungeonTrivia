/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DbConnect Class In charge of connecting the java application to the MySQL
 * database, also in charge of getting all the data from the tables in the
 * database.
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class DbConnect {

    /**
     * DbConnect Constructor In charge of connecting the java application to the
     * MySQL database
     *
     */
    public DbConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DungeonTrivia.con = DriverManager.getConnection("jdbc:mysql://dungeontriviajava.cyqk3zuszau6.us-east-2.rds.amazonaws.com:3306/dungeontrivia", "lfas98", "pipepipe");
            DungeonTrivia.st = DungeonTrivia.con.createStatement();
            System.out.println("Connected to DB.");

        } catch (Exception e) {
            DungeonTrivia.offline = true;
            e.printStackTrace();
            System.out.print("offline 404 ");
        }
    }

    /**
     * gets stats
     *
     * @return stats
     */
    public ArrayList<Stat> getHighscores() {
        ArrayList<Stat> stats = new ArrayList<Stat>();

        try {

            String query = "SELECT * FROM stats ORDER BY score DESC LIMIT 6";
            DungeonTrivia.rs = DungeonTrivia.st.executeQuery(query);

            while (DungeonTrivia.rs.next()) {
                String name = DungeonTrivia.rs.getString("name");
                String stat = DungeonTrivia.rs.getString("score");
                stats.add(new Stat(name, stat));
            }
        } catch (Exception e) {
            System.out.print("Error" + e);
        }
        return stats;
    }
}
