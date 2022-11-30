package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.Categoria;
import dominio.OBJPOOFlix;
import dominio.Serie;

public class DAOCategoria {
    private Connection connection;

    public DAOCategoria(Connection connection){
        this.connection = connection;
    }

	public int add(OBJPOOFlix obj){
        try {
            Serie serie = (Serie) obj;	
			String sql = "INSERT INTO categserie(fk_idserie, fk_idcategoria) VALUES";
			//Concatena os valores para salvar no banco de dados
			for(Categoria cat : serie.getCategorias()){
				sql += String.format("('%s', '%s'),", serie.getid(), cat.getid());
			}
			//Remover a último vírgula
			sql = sql.substring(0, sql.length() - 1);
            Statement st = connection.createStatement();
            st.execute(sql);
            return 0;
        } catch (SQLException e) {
            System.out.println("Problemas em DAOSerie.adiciona" + e.getMessage());
			return -1;
        }
    }

    public List<Categoria> lista() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categoria");
			while (rs.next()) {
                String id = rs.getString("idcategoria");
                String tipo = rs.getString("tipo");
				Categoria categoria = new Categoria(id, tipo);
				
				categorias.add(categoria);
			}
			rs.close();
			// connection.close();
			
			return categorias;			
		} catch (SQLException e) {
			System.out.println("Problemas em DAOCategoria.lista" + e.getMessage());
			return null;
		}
	}
}
