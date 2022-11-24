package persistence;

import java.sql.*;
import dominio.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEpisodio {
    private Connection connection;

    public DAOEpisodio(Connection connection){
        this.connection = connection;
    }

    public int add(OBJPOOFlix obj){
        try {
            Episodio episodio = (Episodio) obj;	
            String sql = String.format("INSERT INTO episodio(idepisodio, fk_idserie, temporada, tituloepisodio, resumo) VALUES('%s', '%s', '%s', '%s', '%s')", episodio.getid(), episodio.getidserie(), episodio.gettemporada(), episodio.gettitulo(), episodio.getresumo());
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOEpisodio.add" + e.getMessage());
			return -1;
        }
    }

    public List<OBJPOOFlix> lista() {
		try {
			List<OBJPOOFlix> personagens = new ArrayList<OBJPOOFlix>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personagem");
			while (rs.next()) {
                String idepisodio = rs.getString("idepisodio");
                String idserie = rs.getString("fk_idserie");
                String temporada = rs.getString("temporada");
                String titulo = rs.getString("tituloepisodio");
                String resumo = rs.getString("resumo");

				Episodio episodio = new Episodio(idepisodio, titulo, temporada, resumo, idserie);
				
				personagens.add(episodio);
			}
			rs.close();
			connection.close();
			
			return personagens;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOEpisodio.lista" + e.getMessage());
			return null;
		}
	}

    public Serie getSerie(int id){
        String sql = String.format("SELECT * FROM serie where idserie = %s", id);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Serie serie = null;
            
            while(rs.next()){
                String idSerie = rs.getString("idSerie");
                String titulo =  rs.getString("tituloSerie");
                int classeEtaria = Integer.parseInt(rs.getString("idade"));
                serie = new Serie(idSerie, titulo, classeEtaria);
            }
            return serie;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
