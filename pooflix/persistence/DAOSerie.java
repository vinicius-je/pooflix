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

    public int update(OBJPOOFlix obj){
        try {
            Serie serie = (Serie) obj;	
            String sql = null;

            if(serie.gettitulo() != null)
                sql = String.format("UPDATE serie set tituloserie = '"+ serie.gettitulo() +"' where idserie = " + serie.getid());
            if(serie.getClassEtaria() != 0)
                sql = String.format("UPDATE serie set idade = '"+ serie.getClassEtaria() +"' where idserie = " + serie.getid());
            
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOSerie.update" + e.getMessage());
			return -1;
        }
    }

    public int remove(String id){
        try {
            String sql = String.format("DELETE FROM serie WHERE idserie = " + id);
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOSerie.remove" + e.getMessage());
			return -1;
        }
    }

    public Serie getSerieByID(String id){
        String sql = String.format("SELECT * FROM serie where idserie = %s", id);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Serie serie = null;
            
            while(rs.next()){
                String idserie = rs.getString("idserie");
                String tituloserie =  rs.getString("tituloserie");
                int idade = Integer.parseInt(rs.getString("idade"));
                serie = new Serie(idserie, tituloserie, idade);
            }
            return serie;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
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
