package persistence;

import java.sql.*;
import dominio.*;

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

    public ResultSet queryTeste(String sql){
        try {
            Statement st = con.createStatement();
            boolean isResult = st.execute(sql);
            ResultSet rs = null;
            if(isResult)
                rs = st.getResultSet();
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

    public void salvarPerformance(Performance performance){
        String sql = String.format("INSERT INTO performance(fk_idepisodio, fk_idpersonagem, fk_idator) VALUES('%s', '%s', '%s')", performance.getidep(), performance.getidperson(), performance.getidator());
        int res = runCommand(sql);

        if(res != 0){
            System.out.println("Performance salva no banco de dados com sucesso!");
        }else{
            System.out.println("Não foi possível salvar a performance no banco de dados!");
        }
    }

    public void salvarSerie(Serie serie){
        String sql = String.format("INSERT INTO serie(idSerie, tituloSerie, idade) VALUES('%s', '%s', '%d')", serie.getid(), serie.gettitulo(), serie.getClassEtaria());
        int res = runCommand(sql);

        if(res != 0){
            System.out.println("Salvando a série: " + serie.gettitulo() + "no banco de dados..");
        }else{
            System.out.println("Não foi possível salvar a série: " + serie.gettitulo() + " no banco de dados..");
        }
    }

    public void salvarEpisodio(Episodio episodio){
        String sql = String.format("INSERT INTO episodio(idepisodio, fk_idserie, temporada, tituloepisodio, resumo) VALUES('%s', '%s', '%s', '%s', '%s')", episodio.getid(), episodio.getidserie(), episodio.gettemporada(), episodio.gettitulo(), episodio.getresumo());
        int res = runCommand(sql);

        if(res != 0){
            System.out.println("Salvando o epsódio: " + episodio.gettitulo() + "no banco de dados..");
        }else{
            System.out.println("Não foi possível salvar o epsódio: " + episodio.gettitulo() + " no banco de dados..");
        }
    }

    public Serie getSerie(int idSerie){
        String sql = String.format("SELECT * FROM serie where idserie = %s", idSerie);
        ResultSet res = queryTable(sql);

        try {
            Serie serie = null;
            while(res.next()){
                String id = res.getString("idSerie");
                String titulo =  res.getString("tituloSerie");
                int classeEtaria = Integer.parseInt(res.getString("idade"));
                serie = new Serie(id, titulo, classeEtaria);
                return serie;
            }
            return serie;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }        
    }
}
