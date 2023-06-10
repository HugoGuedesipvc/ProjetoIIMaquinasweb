package p2.projetoiimaquinasweb.Classes;

public class Utilizador {
    private int id_utilizador = 0;
    private String Nome_Utilizador = null;
    private int Nif = 0;
    private int Telemovel = 0;
    private String Email = null;
    private int Funcao = 0;
    //private String Descricao_Funcao;
    //private Central central= null;
    public Utilizador(int id_utilizador, String Nome_Utilizador, int Nif, int Telemovel, String Email, int Funcao)
    {
        this.id_utilizador = id_utilizador;
        this.Nome_Utilizador = Nome_Utilizador;
        this.Nif = Nif;
        this.Telemovel = Telemovel;
        this.Email = Email;
        this.Funcao = Funcao;
        //this.Descricao_Funcao = Descricao_Funcao;
    }

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public String getNome_Utilizador() {
        return Nome_Utilizador;
    }

    public void setNome_Utilizador(String nome_Utilizador) {
        Nome_Utilizador = nome_Utilizador;
    }

    public int getNif() {
        return Nif;
    }

    public void setNif(int nif) {
        Nif = nif;
    }

    public int getTelemovel() {
        return Telemovel;
    }

    public void setTelemovel(int telemovel) {
        Telemovel = telemovel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getFuncao() {
        return Funcao;
    }

    public void setFuncao(int funcao) {
        Funcao = funcao;
    }

}
