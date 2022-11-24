package cdu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/* REFAZER A CLASSE RELATÓRIO */

import persistence.DBConnection;
import ui.*;

public class CDURelatorio extends CDU {
    private FormRelatorio formRelatorio;
    private DBConnection db;

    public CDURelatorio(FormRelatorio formRelatorio, DBConnection db){
        this.formRelatorio = formRelatorio;
        formRelatorio.setcdur(this);
        this.db = db;
    }

    public void exec(){
        formRelatorio.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": querySerieTable(); break;
            case "2": queryEpisodioTable(); break;
            case "3": queryAtorTable(); break;
            case "4": queryPersonagemTable(); break;
        }
    }

    public void querySerieTable(){
        String sql = "SELECT * FROM serie";
        ResultSet res = db.queryTable(sql);

        try {
            while(res.next()){
                String id = res.getString("idSerie");
                String titulo =  res.getString("tituloSerie");
                
                // Busca pela categoria da série
                String catg = "select fk_idserie, fk_idcategoria, tipo from categserie inner join categoria on(categserie.fk_idcategoria = categoria.idCategoria and categserie.fk_idserie = " + id + ")";
                ResultSet resCtg = db.queryTable(catg);

                List <String> categoria = new ArrayList<>();
                while(resCtg.next()){
                    categoria.add(resCtg.getString("tipo"));
                }

                System.out.println("ID: " + id + " - Titulo: " + titulo + " - Categoria: " + categoria);
                
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void queryEpisodioTable(){
        String sql = "SELECT * FROM episodio";
        ResultSet res = db.queryTable(sql);

        try {
            while(res.next()){
                String id = res.getString("idEpisodio");
                //String fkSerie =  res.getString("fk_idserie");
                String temporada = res.getString("temporada");
                String titulo =  res.getString("tituloEpisodio");
                String resumo =  res.getString("resumo");
                System.out.println("ID: " + id + " EP: " + " Temporada: " + 
                                    temporada + " titulo: " + titulo + " Resumo " + resumo);
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void queryAtorTable(){
        String sql = "SELECT * FROM ator";
        ResultSet res = db.queryTable(sql);

        try {
            while(res.next()){
                String id = res.getString("idAtor");
                String nome =  res.getString("nomeAtor");
                String nacionalidade = res.getString("nacionalidade");
                System.out.println("ID: " + id + " Nome: " + nome + " Nacionalidade: " + nacionalidade);

            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void queryPersonagemTable(){
        String sql = "SELECT * FROM personagem";
        ResultSet res = db.queryTable(sql);

        try {
            while(res.next()){
                String id = res.getString("idPersonagem");
                String nome =  res.getString("nomePersonagem");
                System.out.println("ID: " + id + " Nome: " + nome);
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

