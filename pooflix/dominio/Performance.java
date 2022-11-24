package dominio;

public class Performance implements OBJPOOFlix {
    private String episodioID;
    private String personagemID;
    private String atorID;

    public Performance(String episodioID,String personagemID,String atorID){
        this.episodioID = episodioID;
        this.personagemID = personagemID;
        this.atorID = atorID;
    }

    public String getidep(){
        return episodioID;
    }

    public String getidperson(){
        return personagemID;
    }

    public String getidator(){
        return atorID;
    }
}