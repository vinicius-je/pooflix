package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.*;

public class DAOPerformance {
    private Connection connection;

    public DAOPerformance(Connection connection){
        this.connection = connection;
    }

    public int add(OBJPOOFlix obj){
        try {
            Performance performance = (Performance) obj;	
            String sql = String.format("INSERT INTO performance(fk_idepisodio, fk_idpersonagem, fk_idator) VALUES('%s', '%s', '%s')", performance.getidep(), performance.getidperson(), performance.getidator());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOPerformance.add" + e.getMessage());
			return -1;
        }
    }

    public List<OBJPOOFlix> lista() {
		try {
			List<OBJPOOFlix> performances = new ArrayList<OBJPOOFlix>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM performance");
			while (rs.next()) {
                String idEpisodio = rs.getString("fk_idepisodio");
                String idPersonagem = rs.getString("fk_idpersonagem");
                String idAtor = rs.getString("fk_idator");

				Performance performance = new Performance(idEpisodio,idPersonagem,idAtor);
				
				performances.add(performance);
			}
			rs.close();
			connection.close();
			
			return performances;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOPerformance.lista" + e.getMessage());
			return null;
		}
	}
}
