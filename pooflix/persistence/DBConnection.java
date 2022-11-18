package persistence;

import java.sql.*;

import dominio.Ator;
import dominio.Personagem;
import dominio.Serie;

public class DBConnection {
    Connection con;
    public void dataBaseCon() {
        final String URL = "jdbc:postgresql://babar.db.elephantsql.com/stmhqghf";
        final String USER = "stmhqghf";
        final String PWD = "ddks5Z_6nS_Ef4sZLU64ZpCcE9-4RpIV";

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

    public int runCommand(String sql){
        try {
            Statement st = con.createStatement();
            int res = st.executeUpdate(sql);
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public void salvarAtor(Ator ator){
        String sql = String.format("INSERT INTO ator(idAtor, nomeAtor, nacionalidade) VALUES('%s', '%s', '%s')", ator.getid(), ator.getnome(), ator.getnacionalidade());
        int res = runCommand(sql);

        if(res != 0){
            System.out.println("Salvando o ator: " + ator.getnome() + "no banco de dados..");
        }else{
            System.out.println("Não foi possível salvar o ator: " + ator.getnome() + " no banco de dados..");
        }
    }

    public void salvarPersonagem(Personagem personagem){
        String sql = String.format("INSERT INTO personagem(idPersonagem, nomePersonagem) VALUES('%s', '%s')", personagem.getid(), personagem.getnome());
        int res = runCommand(sql);

        if(res != 0){
            System.out.println("Salvando o personagem: " + personagem.getnome() + "no banco de dados..");
        }else{
            System.out.println("Não foi possível salvar o personagem: " + personagem.getnome() + " no banco de dados..");
        }
    }

    public void salvarSerie(Serie serie){
        String sql = String.format("INSERT INTO serie(idSerie, nomeSerie, idade) VALUES('%s', '%s', '%d')", serie.getid(), serie.gettitulo(), serie.getClassEtaria());
        int res = runCommand(sql);

        if(res != 0){
            System.out.println("Salvando a série: " + serie.gettitulo() + "no banco de dados..");
        }else{
            System.out.println("Não foi possível salvar a série: " + serie.gettitulo() + " no banco de dados..");
        }
    }
}
