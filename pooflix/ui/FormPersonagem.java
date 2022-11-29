package ui;
import java.io.Console;

import cdu.CDUAtualizarPersonagem;
import cdu.CDUExcluirPersonagem;
import cdu.CDUcadastrarPersonagem;
import dominio.Personagem;

public class FormPersonagem extends Form {
    private String id;
    private String nome;
    private CDUcadastrarPersonagem cdupe;
    private CDUAtualizarPersonagem cduap;
    private CDUExcluirPersonagem cduep;

    public void setcdupe(CDUcadastrarPersonagem cdupe){
        this.cdupe = cdupe;
    }

    public void setcduap(CDUAtualizarPersonagem cduap){
        this.cduap = cduap;
    }

    public void setcduep(CDUExcluirPersonagem cduep){
        this.cduep = cduep;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO PERSONAGEM\n");

        while(!termina){
            id = c.readLine("ID: ");
            nome = c.readLine("Nome: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            cdupe.salvarPersonagem();
        }
    }

    public void exibeAtualizarPersonagem(){
        //Faz o update de personagem de acordo com o que o usuário decidir mudar
        Console c = System.console();
        boolean termina = false;
        String continuar;
        String updt; 

        System.out.println("UPDATE DE DADOS DE PERSONAGEM\n");

        while(!termina){
            id = c.readLine("ID do personagem que deseja mudar os dados: ");
            //verificação, para saber se personagem existe no banco de dados
            Personagem personagem = cduap.getPersonagem(id);
            if(id.equals(personagem.getid())){
                //Mudar o ID do personagem ou nao?
                //updt = c.readLine("O que deseja mudar deste personagem? Digite (I)D, (No)me: ");
                System.out.println(personagem);
                updt = c.readLine("O que deseja mudar deste personagem? Digite (No)me");
                if(updt.equals("No")){
                    nome = c.readLine("Qual será o novo nome desse personagem? ");
                    cduap.atualizarPersonagem();
                    //Precisa verificar que o personagem tem o mesmo nome que outros do banco de dados? 
                }
            }else{
                System.out.println("Erro! ID não encontrado no banco de dados, tente novamente");
                // continuar = c.readLine("Deseja tentar novamente? (s/n): ");
                // termina = continuar.toLowerCase().equals("n");  
            }
            continuar = c.readLine("Deseja mudar mais alguma coisa? (s/n): ");
            termina = continuar.toLowerCase().equals("n");
        }
        //cdupe.updatePersonagem();

    }

    public void exibeDeletarPersonagem(){
        //Deleta um personagem do banco de dados
        Console c = System.console();

        System.out.println("DELETANDO PERSONAGEM\n");

        id = c.readLine("ID do personagem que deseja deletar do banco de dados: ");
        Personagem personagem = cduep.getPersonagem(id);
        //verificando se o id existe no banco de dados
        if(id.equals(personagem.getid())){
            System.out.println(personagem);
            cduep.deletarPersonagem();
        }
    }

    public String getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }
}
