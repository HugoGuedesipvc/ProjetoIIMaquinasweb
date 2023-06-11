package p2.projetoiimaquinasweb.Classes;

import p2.projetoiimaquinasweb.DAO.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static p2.projetoiimaquinasweb.Classes.SaveCentral.idCentral;

public class MaquinaDAO {
    public List<Maquina> getMaquinas() {
        List<Maquina> maquinas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Consulta SQL para buscar as máquinas através da view VistaMaquina
            connection = DBConnectionManager.getConnection();
            String sql = "SELECT * FROM vistaMaquina WHERE id_central =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCentral);
            resultSet = preparedStatement.executeQuery();

            // Processar os resultados da consulta
            while (resultSet.next()) {
                int maquina = resultSet.getInt("id_maquina");
                int idCentral = resultSet.getInt("id_central");
                String descricao = resultSet.getString("descricao");
                String nome = resultSet.getString("nome");
                int tipoPagamento = resultSet.getInt("multibanco");
                String estado = resultSet.getString("estado");

                Maquina maquinaObj = new Maquina(maquina, idCentral, descricao, nome, tipoPagamento, estado);
                maquinas.add(maquinaObj);
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
        return maquinas;
    }
}
