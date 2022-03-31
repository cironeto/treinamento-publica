package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/atividade_sql";
        String username = "root";
        String password = "admin";
        
        Connection conn =  DriverManager.getConnection(url, username, password);
        System.out.println("Conexão realizada");
        return conn;

    }
}
