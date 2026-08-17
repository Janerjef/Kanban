package dao;

import Connection.ConnectionFactory;
import jakarta.servlet.http.HttpServlet;
import model.AreaModel;

import java.sql.PreparedStatement;

public class CadastroAreaDao {

    public boolean CadastrarArea(AreaModel area) {
        String sql = "INSERT INTO areas" +
                "(nome,descricao)" +
                "VALUES(?,?)";

        try (var con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, area.getNome());
            stmt.setString(2, area.getDescricao());
            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO CADASTRAR: " + e.getMessage());
            return false;
        }
    }
}
