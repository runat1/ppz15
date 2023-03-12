//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USE = "root";
    private static final String PASSWORD = "poot";
    private static Connection connection = null;

    public Util() {
    }

    public static Connection getCon() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "poot");
        } catch (SQLException e) {
            System.out.println("Error проблемма с соединением");
            throw new RuntimeException(e);
        }

        return connection;
    }
}
