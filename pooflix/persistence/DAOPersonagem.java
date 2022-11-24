package persistence;

import java.sql.*;
import dominio.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonagem {
    private Connection connection;

    public DAOPersonagem(Connection connection){
        this.connection = connection;
    }

    public int add(OBJPOOFlix obj){
        try {
            Personagem personagem = (Personagem) obj;	
            String sql = String.format("INSERT INTO personagem(idPersonagem, nomePersonagem) VALUES('%s', '%s')", personagem.getid(), personagem.getnome());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPersonagem.add" + e.getMessage());
			return -1;
        }
    }

    public List<Personagem> lista() {
		try {
			List<Personagem> personagens = new ArrayList<Personagem>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personagem");
			while (rs.next()) {
                String id = rs.getString("idPersonagem");
                String nome = rs.getString("nomePersonagem");
				Personagem personagem = new Personagem(id,nome);
				
				personagens.add(personagem);
			}
			rs.close();
			// connection.close();
			
			return personagens;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOPersonagem.lista" + e.getMessage());
			return null;
		}
	}
}
