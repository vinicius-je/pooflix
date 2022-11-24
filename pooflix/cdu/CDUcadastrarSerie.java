package cdu;

import ui.*;
import dominio.*;
import java.sql.Connection;
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

    public void salvarSerie() {
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        int idade = Integer.valueOf(formSerie.getidademin());

        System.out.println("Salvando no banco de dados.." + serie);
        serie = new Serie(id,titulo,idade);
        DAOSerie dao = new DAOSerie(con);
        int rs = dao.add(serie);
        
        if(rs == 0){
            System.out.println("Serie cadastrada com sucesso!");
        }else{
            System.out.println("Não foi possível salvar a serie!");
        }
    }
}