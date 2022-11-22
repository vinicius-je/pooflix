package ui;

import java.io.Console;
import cdu.*;

public class FormSerie extends Form {
    private String id;
    private String titulo;
    private String idademin;
    private CDUcadastrarSerie cducs;

    public void setcdu(CDUcadastrarSerie cducs){
        this.cducs = cducs;
    }

    public void exibe() {
        Console c = System.console();
        boolean termina = false;
        String continuar;        

        System.out.println("CADASTRANDO SÉRIE\n");

        while(!termina){
            id = c.readLine("ID: ");
            titulo = c.readLine("Titulo: ");
            idademin = c.readLine("Idade mínima: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
            // Remover esse (if), pois o mesmo não permite salvar a última série cadastrada
            
            cducs.salvarSerie();
            
        }
    }

    public String getid(){
        return id;
    }

    public String gettitulo(){
        return titulo;
    }

    public String getidademin(){
        return idademin;
    }
}