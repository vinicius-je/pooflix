package dominio;

import java.util.LinkedList;

public class Personagem {
	private String id;
	private String nome;
    private LinkedList<Performance> perfomances;

	public Personagem(String id,String nome){
        this.id = id;
        this.nome = nome;
	}

	public void adperformance(Performance p){
        perfomances.add(p);
    }

	public String getid(){
        return id;
	}

	public String getnome(){
        return nome;
	}
}