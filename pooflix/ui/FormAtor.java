package ui;
import java.io.Console;

import cdu.CDURelatorio;
import cdu.CDUcadastrarAtor;

public class FormAtor extends Form {
    private String id;
    private String nome;
    private String nacionalidade;
    private CDUcadastrarAtor cduca;

    public void setcduca(CDUcadastrarAtor cduca){
        this.cduca = cduca;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO ATOR\n");

        while(!termina){
            id = c.readLine("ID: ");
            nome = c.readLine("Nome: ");
            nacionalidade = c.readLine("Nacionalidade: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            cduca.salvarAtor();
        }
    }

    public void updateAtor(){
        //Faz o update do ator de acordo com o que o usuário decidir mudar
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt; 

        System.out.println("UPDATE DE DADOS DE ATOR\n");

        while(!termina){
            id = c.readLine("ID do ator que deseja mudar os dados: ");
            //verificação, para saber se ator existe no banco de dados
            if(id == this.getid()){
                updt = c.readLine("O que deseja mudar deste ator? Digite (No)me ou (Na)cionalidade: ");
                if(updt.equals("No")){
                    nome = c.readLine("Qual o novo nome do ator? ");
                }else if(updt.equals("Na")){
                    nacionalidade = c.readLine("Qual a nova nacionalidade do ator? ");
                }
                
            }else{
                System.out.println("Erro! Nome não encontrado no banco de dados, tente novamente");
                continuar = c.readLine("Deseja tentar novamente? (s/n): ");
                termina = continuar.toLowerCase().equals("n");
            }
            continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
            //cduca.updateAtor();
            
        }
    }

    public void deleteAtor(){
        //Deleta um ator do banco de dados
        Console c = System.console();
        String del;

        System.out.println("DELETANDO ATOR\n");

        id = c.readLine("ID do ator que deseja deletar do banco de dados");
        //verificando se o id existe no banco de dados
        if(id.equals(this.getid())){
            //cduca.deleteAtor();
            System.out.printf("Ator %s deletado com sucesso do banco de dados..", this.getnome());
        }

    }

    public String getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }

    public String getnacionalidade(){
        return nacionalidade;
    }
}
