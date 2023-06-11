package p2.projetoiimaquinasweb.Classes;

import java.util.Date;

public class Reposicao_Maquinas extends Reposicao {
    private int id_reposicao_M = 0;
    private int id_maquina = 0;

    public Reposicao_Maquinas(int id_reposicao_M, int id_maquina, Date data_preposicao, Date data_ereposicao, String Descricao) {
        this.id_reposicao_M = id_reposicao_M;
        this.id_maquina = id_maquina;
        setData_preposicao(data_preposicao);
        setData_ereposicao(data_ereposicao);
        setDescricao(Descricao);
    }

    public int getId_reposicao_M() {
        return id_reposicao_M;
    }

    public void setId_reposicao_M(int id_reposicao_M) {
        this.id_reposicao_M = id_reposicao_M;
    }

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }
}
