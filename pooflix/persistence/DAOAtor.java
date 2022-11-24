package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.*;

public class DAOAtor {
    private Connection connection;

    public DAOAtor(Connection connection){
        this.connection = connection;
    }

    public int add(OBJPOOFlix obj){
        try {
            Ator ator = (Ator) obj;	
            String sql = String.format("INSERT INTO ator(idAtor, nomeAtor, nacionalidade) VALUES('%s', '%s', '%s')", ator.getid(), ator.getnome(), ator.getnacionalidade());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOAtor.add" + e.getMessage());
			return -1;
        }
    }

    public List<Ator> lista() {
		try {
			List<Ator> atores = new ArrayList<Ator>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ator");
			while (rs.next()) {
                String id = rs.getString("idAtor");
                String nome = rs.getString("nomeAtor");
                String nacionalidade = rs.getString("nacionalidade");
				Ator ator = new Ator(id,nome,nacionalidade);
				
				atores.add(ator);
			}
			rs.close();
			// connection.close();
			
			return atores;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOAtor.lista" + e.getMessage());
			return null;
		}
	}
}
