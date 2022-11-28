package ui;

import java.io.Console;
import java.util.HashMap;

import cdu.*;
import dominio.Categoria;

public class FormSerie extends Form {
    private String id;
    private String titulo;
    private String idademin;
    private CDUcadastrarSerie cducs;
    private HashMap<String,Categoria> categoria;

    public void setcdu(CDUcadastrarSerie cducs){
        this.cducs = cducs;
    }

    public void exibe() {
        Console c = System.console();
        boolean termina = false;
        boolean terminaCat = false;
        String continuarCat;
        String continuar;   
        String cat;     

        System.out.println("CADASTRANDO SÉRIE\n");

        while(!termina){
            id = c.readLine("ID: ");
            titulo = c.readLine("Titulo: ");
            idademin = c.readLine("Idade mínima: ");

            //Categoria aqui
            //Veja se tem sentido a lógica abaixo:

            while(!terminaCat){
                cat = c.readLine("Qual a categoria da série? Digite (A)ção, (AV)entura, (C)omedia, (D)rama, (V)iolencia, (S)exo, (L)inguagem");

                //loop que pega o input do usuário e de acordo com o que ele decidir, adiciona-se no hashmap que tem como chave o id da série e o conteúdo é a o a categoria
                switch(cat){
                    case "A": categoria.put(id, Categoria.ACAO);break;
                    case "AV": categoria.put(id, Categoria.AVENTURA);break;
                    case "C": categoria.put(id, Categoria.COMEDIA);break;
                    case "D": categoria.put(id, Categoria.DRAMA);break;
                    case "V": categoria.put(id, Categoria.VIOLENCIA);break;
                    case "S": categoria.put(id, Categoria.SEXO);break;
                    case "L": categoria.put(id, Categoria.LINGUAGEM);break;

                }
                //Perguntando se o usuário deseja inserir mais uma categoria na série
                continuarCat = c.readLine("Deseja adicionar mais categorias a série?(s/n): ");
                terminaCat = continuarCat.toLowerCase().equals("n");

            }
            
        
            
            

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
            // Remover esse (if), pois o mesmo não permite salvar a última série cadastrada

            cducs.salvarSerie();
            
        }
    }

    public void updateSerie(){
        //Faz o update de série de acordo com o que o usuário decidir mudar
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt;

        System.out.println("UPDATE DE DADOS DE SÉRIE\n");

        while(!termina){
            id = c.readLine("ID da série que deseja mudar os dados: ");
            //verificação, para saber se personagem existe no banco de dados
            if(id.equals(this.getid())){
                updt = c.readLine("O que deseja mudar desta série? Digite (T)itulo, (I)dade mínima: ");
                
                if(updt.equals("T")){
                    titulo = c.readLine("Qual será o novo título dessa série? ");
                    //Precisa verificar se o titulo da série tem o mesmo nome que outros do banco de dados? 
                }else if(updt.equals("I")){
                    idademin = c.readLine("Qual será a nova idade mínima dessa série? ");

                }
            }else{
                System.out.println("Erro! ID não encontrado no banco de dados, tente novamente");
                continuar = c.readLine("Deseja tentar novamente? (s/n): ");
                termina = continuar.toLowerCase().equals("n");  
            }
        }
        continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
        termina = continuar.toLowerCase().equals("n");

        //cducs.updateSerie();
    }

    public void deleteSerie(){
        //Deleta uma série do banco de dados
        Console c = System.console();
        String del;

        System.out.println("DELETANDO SÉRIE\n");

        id = c.readLine("ID da série que deseja deletar do banco de dados");
        //verificando se o id existe no banco de dados
        if(id.equals(this.getid())){
            //cduca.deleteSerie();
            System.out.printf("Serie %s deletada com sucesso do banco de dados..", this.gettitulo());
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

    public HashMap<String,Categoria> getcategoria(){
        return categoria;
    }
}