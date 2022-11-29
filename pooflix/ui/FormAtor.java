package ui;
import java.io.Console;

import cdu.CDUAtualizarAtor;
import cdu.CDUExcluirAtor;
import cdu.CDUcadastrarAtor;
import dominio.Ator;

public class FormAtor extends Form {
    private String id;
    private String nome;
    private String nacionalidade;
    private CDUcadastrarAtor cduca;
    private CDUAtualizarAtor cduaa;
    private CDUExcluirAtor cduea;

    public void setcduca(CDUcadastrarAtor cduca){
        this.cduca = cduca;
    }

    public void setcduaa(CDUAtualizarAtor cduaa){
        this.cduaa = cduaa;
    }

    public void setcduea(CDUExcluirAtor cduea){
        this.cduea = cduea;
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

    public void exibeAtulizarAtor(){
        //Faz o update do ator de acordo com o que o usuário decidir mudar
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt; 

        System.out.println("UPDATE DE DADOS DE ATOR\n");

        while(!termina){
            id = c.readLine("ID do ator que deseja mudar os dados: ");
            Ator ator = cduaa.getAtor(id);
            //verificação, para saber se ator existe no banco de dados
            if(ator.getid().equals(id)){
                System.out.println(ator);
                updt = c.readLine("O que deseja mudar deste ator? Digite (No)me ou (Na)cionalidade: ");
                if(updt.equals("No")){
                    nome = c.readLine("Qual o novo nome do ator? ");
                }else if(updt.equals("Na")){
                    nacionalidade = c.readLine("Qual a nova nacionalidade do ator? ");
                }
                cduaa.atualizarAtor();
            }else{
                System.out.println("Erro! Nome não encontrado no banco de dados, tente novamente");
                continuar = c.readLine("Deseja tentar novamente? (s/n): ");
                termina = continuar.toLowerCase().equals("n");
            }
            continuar = c.readLine("Deseja mudar mais algum ator? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
            nome = null;
            nacionalidade = null;
        }
    }

    public void exibeDeletarAtor(){
        //Deleta um ator do banco de dados
        Console c = System.console();

        System.out.println("DELETANDO ATOR\n");
        id = c.readLine("ID do ator que deseja deletar do banco de dados: ");
        Ator ator = cduea.getAtor(id);
        //verificando se o id existe no banco de dados
        if(id.equals(this.getid())){
            System.out.println(ator);
            cduea.deletarSerie();
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
