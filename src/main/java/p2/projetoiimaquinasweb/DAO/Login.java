package p2.projetoiimaquinasweb.DAO;

import p2.projetoiimaquinasweb.Classes.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {

    private static Utilizador sessao;

    public static void LoginUser( String Email, String NIF){

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Utilizador sessao = null;
        try {
            connection = DBConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM utilizadores_por_central WHERE \"email\" = ?");
            preparedStatement.setString(1, Email);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Utilizador não encontrado!");
            } else {
                boolean nifMatch = false;
                while (resultSet.next()) {
                    int idUtilizador = resultSet.getInt("id_utilizador");
                    int idTipo = resultSet.getInt("id_tipo");
                    SaveCentral.idCentral = resultSet.getInt("id_central");
                    String retrievedNome = resultSet.getString("nome");
                    int retrievedTelemovel = resultSet.getInt("telemovel");
                    String retrievedEmail = resultSet.getString("email");
                    int retrievedNIF = resultSet.getInt("nif");

                    if (String.valueOf(retrievedNIF).equals(NIF)) {
                        nifMatch = true;
                        sessao = new Utilizador(idUtilizador, retrievedNome, retrievedNIF, retrievedTelemovel, retrievedEmail, idTipo);
                        Login.guardarSessao(sessao);
                        break; // Exit the loop after finding a matching NIF
                    }
                }
                if (!nifMatch) {
                    System.out.println("NIF incorreto!");
                } else if (sessao.getFuncao() == 1) {
                    System.out.println("Tipo de utilizador inválido!");

                } else {

                    int centralId = SaveCentral.idCentral;
                    System.out.println("idCentral:  " + centralId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
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
            DBConnectionManager.closeConnection();
        }
    }

    public static void guardarSessao(Utilizador utilizador) {
        sessao = utilizador;
    }

    public static Utilizador getSessao() {
        return sessao;
    }

}