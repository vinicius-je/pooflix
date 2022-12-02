package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dominio.*;

public class DAOSerie {
    private Connection connection;

    public DAOSerie(Connection connection){
        this.connection = connection;
    }

    public int create(OBJPOOFlix obj){
        try {
            Serie serie = (Serie) obj;	
            String sql = String.format("INSERT INTO serie(idSerie, tituloSerie, idade) VALUES('%s', '%s', '%d')", serie.getid(), serie.gettitulo(), serie.getClassEtaria());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOSerie.create" + e.getMessage());
			return -1;
        }
    }

    public List<Serie> read() {
		try {
			List<Serie> series = new ArrayList<Serie>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM serie");
			while (rs.next()) {
				String id = rs.getString("idSerie");
				String titulo = rs.getString("tituloSerie");
                int classeEtaria = Integer.valueOf(rs.getString("idade"));

                // Busca pela categoria da série
                String catg = "select fk_idserie, fk_idcategoria, tipo from categserie inner join categoria on(categserie.fk_idcategoria = categoria.idCategoria and categserie.fk_idserie = " + id + ")";
                st = connection.createStatement();
                ResultSet rsCatg = st.executeQuery(catg);

                LinkedList<Categoria> serieCategorias = new LinkedList<Categoria>();
                Categoria categoria = null;
                while(rsCatg.next()){
                    categoria = new Categoria(rsCatg.getString("fk_idcategoria"), rsCatg.getString("tipo"));
                    serieCategorias.add(categoria);
                }


				Serie serie = new Serie(id,titulo,classeEtaria);
                serie.setCategorias(serieCategorias);
				
				series.add(serie);
			}
			rs.close();
			return series;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOSerie.read" + e.getMessage());
			return null;
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

    public int delete(String id){
        try {
            String sql = String.format("DELETE FROM categserie where fk_idserie = "+ id);
            Statement st = connection.createStatement();
            st.execute(sql);
            sql = String.format("DELETE FROM serie where idserie = "+ id);
            st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOSerie.delete" + e.getMessage());
			return -1;
        }
    }

    public Serie getSerieByID(String id){
        try {
            String sql = String.format("SELECT * FROM serie INNER JOIN categserie ON (serie.idserie = "+ id +" and categserie.fk_idserie = "+ id +") INNER JOIN categoria ON (categoria.idcategoria = categserie.fk_idcategoria)");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            String idserie = null;
            String tituloserie = null; 
            int idade = 0;
            LinkedList<Categoria> serieCategorias = new LinkedList<Categoria>();

            Serie serie = null;
            Categoria categoria = null;

            boolean primeiraExecucao = true;
            while(rs.next()){
                if(primeiraExecucao){
                    idserie = rs.getString("idserie");
                    tituloserie =  rs.getString("tituloserie");
                    idade = Integer.parseInt(rs.getString("idade"));
                    serie = new Serie(idserie, tituloserie, idade);
                }
                primeiraExecucao = false;
                categoria = new Categoria(rs.getString("fk_idcategoria"), rs.getString("tipo"));
                serieCategorias.add(categoria);                
            }
            serie.setCategorias(serieCategorias);
            return serie;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}