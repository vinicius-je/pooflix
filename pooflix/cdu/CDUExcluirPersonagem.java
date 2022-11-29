package cdu;

import java.sql.Connection;

import dominio.Personagem;
import persistence.DAOPersonagem;
import ui.FormPersonagem;

public class CDUExcluirPersonagem {
    private FormPersonagem formPersonagem;
    Connection con;

    public CDUExcluirPersonagem(FormPersonagem formPersonagem, Connection con){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcduep(this);
        this.con = con;
    }

    public void exec(){
        formPersonagem.exibeDeletarPersonagem();
    }

    public Personagem getPersonagem(String id){
        DAOPersonagem dao = new DAOPersonagem(con);
        return dao.getPersonagemByID(id);
    }

    public void deletarPersonagem(){
        String id = formPersonagem.getid();
        DAOPersonagem dao = new DAOPersonagem(con);
        int rs = dao.remove(id);

        if(rs == 0){
            System.out.println("Personagem excluído com sucesso!");
        }else{
            System.out.println("Não foi possível excluir o personagem!");
        }
    }

}
