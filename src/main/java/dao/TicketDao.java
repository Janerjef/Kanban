package dao;

import Connection.ConnectionFactory;
import model.TicketModel;

import java.sql.PreparedStatement;

public class TicketDao {

    public boolean cadastrarTicket(TicketModel ticket) {
        String sql = "INSERT INTO ticket" +
                "(status,titulo,texto)" +
                "VALUES(?,?,?)";
        try (var con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, ticket.getTitulo());
            stmt.setString(2, ticket.getTexto());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO CADASTRAR: " + e.getMessage());
            return false;

        }
    }
}
