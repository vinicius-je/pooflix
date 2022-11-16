package persistence;

import java.sql.*;

public class DBConnection {
    public Connection con = null;

    public Connection dataBaseCon(){
        final String URL;
        final String USER;
        final String PWD;
        try {
            con = DriverManager.getConnection(URL, USER, PWD);
            System.out.println(con);
            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }
}
