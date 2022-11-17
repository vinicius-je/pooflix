package persistence;

import java.sql.*;

public class DBConnection {
    Connection con;
    public void dataBaseCon() {
        final String URL;
        final String USER;
        final String PWD;

        try {
            Connection dbcon = DriverManager.getConnection(URL, USER, PWD);
            setCon(dbcon);
            System.out.println(getCon());
            System.out.println("Conexão com o banco de dados realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    public ResultSet queryTable(String sql){
        System.out.println("con: "+ getCon());
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void setCon(Connection con){
        this.con = con;
    }

    public Connection getCon(){
        return con;
    }
}
