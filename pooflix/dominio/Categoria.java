package dominio;

public class Categoria implements OBJPOOFlix {
    private String id;
    private String tipo;
    
    public Categoria(String id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public String getid(){
        return id;
	}

	public String getnome(){
        return tipo;
	}

    public String toString(){ 
        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Categoria: " + tipo + ";\n";
        return s;
    }
}
