package p2.projetoiimaquinasweb.Classes;

public class Maquina {

    private int Id_Central = 0;
    private int Maquina = 0;
    private String Descricao = null;
    private String Nome = null;
    private int Tipo_Pagamento = 0;
    private String Modelo = null;
    public Maquina(int Maquina, int ID_Central, String Descricao, String Nome, int Tipo_Pagamento, String Modelo){

        this.Maquina = Maquina;
        this.Id_Central=ID_Central;
        this.Descricao=Descricao;
        this.Nome = Nome;
        this.Tipo_Pagamento = Tipo_Pagamento;
        this.Modelo = Modelo;
    }

    public int getId_Central() {
        return Id_Central;
    }

    public void setId_Central(int id_Central) {
        Id_Central = id_Central;
    }

    public int getMaquina() {
        return Maquina;
    }

    public void setMaquina(int maquina) {
        Maquina = maquina;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getTipo_Pagamento() {
        return Tipo_Pagamento;
    }

    public void setTipo_Pagamento(int tipo_Pagamento) {
        Tipo_Pagamento = tipo_Pagamento;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }
}
