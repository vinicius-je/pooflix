package cdu;

import java.sql.Connection;

import dominio.Personagem;
import persistence.DAOPersonagem;
import ui.FormPersonagem;

public class CDUAtualizarPersonagem {
    private Personagem personagem;
    private FormPersonagem formPersonagem;
    Connection con;

    public CDUAtualizarPersonagem(FormPersonagem formPersonagem, Connection con){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcduap(this);
        this.con = con;
    }

    public void exec(){
        formPersonagem.exibeAtualizarPersonagem();
    }

    public Personagem getPersonagem(String id){
        DAOPersonagem dao = new DAOPersonagem(con);
        return dao.getPersonagemByID(id);
    }

    public void atualizarPersonagem(){
        String id = formPersonagem.getid();
        String nome = formPersonagem.getnome();

        personagem = new Personagem(id, nome);
        DAOPersonagem dao = new DAOPersonagem(con);
        int rs = dao.update(personagem);

        if(rs == 0){
            System.out.println("Personagem: " + personagem.getnome() + " atualizado com sucesso" + "\n" + personagem);
        }else{
            System.out.println("Não foi possível realizar a atualização no personagem: " + personagem.getnome());
        }
    }
}
