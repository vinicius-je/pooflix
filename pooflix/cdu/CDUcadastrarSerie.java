package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import persistence.DAOCategoria;
import persistence.DAOSerie;

public class CDUcadastrarSerie  extends CDU {
    private Serie serie;
    private FormSerie formSerie;
    Connection con;

    public CDUcadastrarSerie(FormSerie formSerie, Connection con){
        this.formSerie = formSerie;
        this.formSerie.setcdu(this);
        this.con = con;
    }

    public void exec() {
        formSerie.exibe();
    }

    public List<Categoria> getCategorias(){
        DAOCategoria dao = new DAOCategoria(con);
        return dao.lista();
    }

    public void salvarSerie() {
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int idade = Integer.valueOf(formSerie.getidademin());
        LinkedList<Categoria> categorias = formSerie.getcategoria();

        System.out.println("Salvando no banco de dados.." + serie);
        serie = new Serie(id,titulo,idade);
        serie.setCategorias(categorias);

        // String sql = "INSERT INTO categserie(fk_idserie, fk_idcategoria)";
        // for(Categoria cat : serie.getCategorias()){
        //     sql += String.format(" VALUES('%s', '%s'),", serie.getid(), cat.getid());
        //     // System.out.println(cat.getid());
        // }
        // sql = sql.substring(0, sql.length() - 1);
        // System.out.println(sql);
        DAOSerie daoSerie = new DAOSerie(con);
        DAOCategoria daoCategoria = new DAOCategoria(con);
        int rs = daoSerie.add(serie);
        daoCategoria.add(serie);
        
        if(rs == 0){
            System.out.println("Serie cadastrada com sucesso!");
        }else{
            System.out.println("Não foi possível salvar a serie!");
        }
    }
}