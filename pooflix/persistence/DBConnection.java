package persistence;

import java.sql.*;

public class DBConnection {
    Connection con;
    public void dataBaseCon() {
        final String URL;
        final String USER;
        final String PWD;

        try {
            con = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    public ResultSet queryTable(String sql){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
