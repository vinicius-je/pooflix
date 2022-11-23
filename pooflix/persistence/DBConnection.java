package persistence;

import java.sql.*;
import dominio.*;

public class DBConnection {
    private String url;
    private String usuario;
    private String senha;
    Connection con = null;

    public DBConnection(String url, String usuario, String senha){
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection connection(){
        try{
            con = DriverManager.getConnection(url, usuario, senha);
        }catch (SQLException e){
            System.err.println("ERRO em DBConnection.connection: " + e.getMessage());
        }
        return con;
    }

    public Connection getConnection(){
        return con;
    }

    public void disconnect(){
        try {
            con.close();
        } catch (NullPointerException e) {
			System.err.println("ERRO em DBConnection.disconnect: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("ERRO em DBConnection.disconnect: " + e.getMessage());
		}
    }
}

    // [REMOVER DAQUI PARA BAIXO]
    // public ResultSet queryTable(String sql){
    //     try {
    //         Statement st = con.createStatement();
    //         ResultSet rs = st.executeQuery(sql);
    //         return rs;
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //         return null;
    //     }
    // }

    // public int runCommand(String sql){
    //     try {
    //         Statement st = con.createStatement();
    //         int res = st.executeUpdate(sql);
    //         return res;
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //         return 0;
    //     }
    // }

//     public void salvarAtor(Ator ator){
//         String sql = String.format("INSERT INTO ator(idAtor, nomeAtor, nacionalidade) VALUES('%s', '%s', '%s')", ator.getid(), ator.getnome(), ator.getnacionalidade());
//         int res = runCommand(sql);

//         if(res != 0){
//             System.out.println("Salvando o ator: " + ator.getnome() + "no banco de dados..");
//         }else{
//             System.out.println("Não foi possível salvar o ator: " + ator.getnome() + " no banco de dados..");
//         }
//     }

//     public void salvarPersonagem(Personagem personagem){
//         String sql = String.format("INSERT INTO personagem(idPersonagem, nomePersonagem) VALUES('%s', '%s')", personagem.getid(), personagem.getnome());
//         int res = runCommand(sql);

//         if(res != 0){
//             System.out.println("Salvando o personagem: " + personagem.getnome() + "no banco de dados..");
//         }else{
//             System.out.println("Não foi possível salvar o personagem: " + personagem.getnome() + " no banco de dados..");
//         }
//     }

//     public void salvarPerformance(Performance performance){
//         String sql = String.format("INSERT INTO performance(fk_idepisodio, fk_idpersonagem, fk_idator) VALUES('%s', '%s', '%s')", performance.getidep(), performance.getidperson(), performance.getidator());
//         int res = runCommand(sql);

//         if(res != 0){
//             System.out.println("Performance salva no banco de dados com sucesso!");
//         }else{
//             System.out.println("Não foi possível salvar a performance no banco de dados!");
//         }
//     }

//     public void salvarSerie(Serie serie){
//         String sql = String.format("INSERT INTO serie(idSerie, tituloSerie, idade) VALUES('%s', '%s', '%d')", serie.getid(), serie.gettitulo(), serie.getClassEtaria());
//         int res = runCommand(sql);

//         if(res != 0){
//             System.out.println("Salvando a série: " + serie.gettitulo() + "no banco de dados..");
//         }else{
//             System.out.println("Não foi possível salvar a série: " + serie.gettitulo() + " no banco de dados..");
//         }
//     }

//     public void salvarEpisodio(Episodio episodio){
//         String sql = String.format("INSERT INTO episodio(idepisodio, fk_idserie, temporada, tituloepisodio, resumo) VALUES('%s', '%s', '%s', '%s', '%s')", episodio.getid(), episodio.getidserie(), episodio.gettemporada(), episodio.gettitulo(), episodio.getresumo());
//         int res = runCommand(sql);

//         if(res != 0){
//             System.out.println("Salvando o epsódio: " + episodio.gettitulo() + "no banco de dados..");
//         }else{
//             System.out.println("Não foi possível salvar o epsódio: " + episodio.gettitulo() + " no banco de dados..");
//         }
//     }

//     public Serie getSerie(int idSerie){
//         String sql = String.format("SELECT * FROM serie where idserie = %s", idSerie);
//         ResultSet res = queryTable(sql);

//         try {
//             Serie serie = null;
//             while(res.next()){
//                 String id = res.getString("idSerie");
//                 String titulo =  res.getString("tituloSerie");
//                 int classeEtaria = Integer.parseInt(res.getString("idade"));
//                 serie = new Serie(id, titulo, classeEtaria);
//                 return serie;
//             }
//             return serie;
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//             return null;
//         }        
//     }
// }
