package p2.projetoiimaquinasweb.Classes;

import java.util.Date;

public abstract class Reposicao {
    private Date data_preposicao = null;
    private String Descricao = null;
    private Date data_ereposicao = null;


    public Date getData_preposicao() {
        return data_preposicao;
    }

    public void setData_preposicao(Date data_preposicao) {
        this.data_preposicao = data_preposicao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Date getData_ereposicao() {
        return data_ereposicao;
    }

    public void setData_ereposicao(Date data_ereposicao) {
        this.data_ereposicao = data_ereposicao;
    }

}
