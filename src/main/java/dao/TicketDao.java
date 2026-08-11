package dao;

import Connection.ConnectionFactory;
import model.TicketModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    public boolean cadastrarTicket(TicketModel ticket) {
        String sql = "INSERT INTO ticket" +
                "(status,titulo,texto)" +
                "VALUES(?,?,?)";
        try (var con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, ticket.getStatus());
            stmt.setString(2, ticket.getTitulo());
            stmt.setString(3, ticket.getTexto());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO CADASTRAR: " + e.getMessage());
            return false;

        }
    }

    public boolean atualizar(TicketModel ticket) {
        String sql = "UPDATE ticket SET" +
                "status = ?; " +
                "titulo = ?, " +
                "texto = ? " +
                "WHERE id = ?";
        try (var con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, ticket.getStatus());
            stmt.setString(2, ticket.getTitulo());
            stmt.setString(3, ticket.getTexto());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO ATUALIZAR: " + e.getMessage());
            return false;

        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM ticket " +
                "WHERE id = ?";

        try (var con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO EXCLUIR: " + e.getMessage());
            return false;

        }

    }

    public List<TicketModel> listar(){
        List<TicketModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM ticket";

        try (var con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TicketModel ticket = new TicketModel();

                ticket.setTitulo(rs.getString(""));
                ticket.setTexto(rs.getString(""));
                ticket.setStatus(rs.getString(""));
                lista.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(("ERRO AO LISTAR" + e.getMessage()));
        } return lista;

    }
}