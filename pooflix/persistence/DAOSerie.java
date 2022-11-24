package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.*;

public class DAOSerie {
    private Connection connection;

    public DAOSerie(Connection connection){
        this.connection = connection;
    }

    public int add(OBJPOOFlix obj){
        try {
            Serie serie = (Serie) obj;	
            String sql = String.format("INSERT INTO serie(idSerie, tituloSerie, idade) VALUES('%s', '%s', '%d')", serie.getid(), serie.gettitulo(), serie.getClassEtaria());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOSerie.adiciona" + e.getMessage());
			return -1;
        }
    }

    public List<Serie> lista() {
		try {
			List<Serie> series = new ArrayList<Serie>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM serie");
			while (rs.next()) {
				String id = rs.getString("idSerie");
				String titulo = rs.getString("tituloSerie");
                int classeEtaria = Integer.valueOf(rs.getString("idade"));
				Serie serie = new Serie(id,titulo,classeEtaria);
				
				series.add(serie);
			}
			rs.close();
			// connection.close();
			
			return series;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOSerie.lista" + e.getMessage());
			return null;
		}
	}
}
