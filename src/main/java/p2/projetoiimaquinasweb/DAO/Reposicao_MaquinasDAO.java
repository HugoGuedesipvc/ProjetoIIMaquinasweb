package p2.projetoiimaquinasweb.DAO;

import p2.projetoiimaquinasweb.Classes.Reposicao_Maquinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static p2.projetoiimaquinasweb.Classes.SaveCentral.idCentral;

public class Reposicao_MaquinasDAO {
    public List<Reposicao_Maquinas> getReposicoesMaquinas() {
        List<Reposicao_Maquinas> reposicoesMaquinas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnectionManager.getConnection();

            // Consulta SQL para buscar as reposições de máquinas com o nome do utilizador
            String sql = "SELECT rm.*, u.nome AS nome_utilizador " +
                    "FROM reposicoes_maquinas rm " +
                    "JOIN utilizadores u ON rm.id_utilizador = u.id_utilizador " +
                    "WHERE u.id_central = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCentral);
            resultSet = preparedStatement.executeQuery();

            // Processar os resultados da consulta
            while (resultSet.next()) {
                int idReposicaoM = resultSet.getInt("id_reposicao_m");
                int idMaquina = resultSet.getInt("id_maquina");
                int idUtilizador = resultSet.getInt("id_utilizador");
                Date dataPreposicao = resultSet.getDate("data_preposicao");
                String descricao = resultSet.getString("descricao");
                Date dataEreposicao = resultSet.getDate("data_ereposicao");
                String nomeUtilizador = resultSet.getString("nome_utilizador");

                Reposicao_Maquinas reposicaoMaquinas = new Reposicao_Maquinas(idReposicaoM, idMaquina,dataPreposicao, dataEreposicao, descricao);
                reposicoesMaquinas.add(reposicaoMaquinas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar recursos (ResultSet, PreparedStatement, Connection)
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        DBConnectionManager.closeConnection();
        return reposicoesMaquinas;
    }

}

