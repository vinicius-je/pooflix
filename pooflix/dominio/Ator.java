package dominio;

import java.util.LinkedList;

public class Ator implements OBJPOOFlix {
	private String id;
	private String nome;
	private String nacionalidade;
    private LinkedList<Performance> performances;

	public Ator(String id, String nome, String nacionalidade){
        this.id = id;
        this.nome = nome;
		this.nacionalidade = nacionalidade;
        performances = new LinkedList<Performance>();
	}

    public void adperformance(Performance p){
        performances.add(p);
    }

	public void setNacio(String nacionalidade){
        this.nacionalidade = nacionalidade;
	}

	public String getid(){
        return id;
	}

	public String getnome(){
        return nome;
	}

	public String getnacionalidade(){
        return nacionalidade;
	}

	public String toString(){ 
        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Nome: " + nome + ";\n";
		s = s + "Nacionalidade: " + nacionalidade + ";\n";
        return s;
    }
}