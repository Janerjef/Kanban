package dao;

import Connection.ConnectionFactory;
import model.TicketModel;

import java.sql.PreparedStatement;

public class CadastroTicketDao {

    public boolean cadastrarTicket(TicketModel ticket){
        String sql = "INSERT INTO ticket" +
                "(titulo, texto, area_id)" +
                "VALUES(?, ?, ?)";

        try(var con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1, ticket.getTitulo() );
            stmt.setString(2, ticket.getTexto() );
            stmt.setInt(3, ticket.getAreaId());
            stmt.executeUpdate();

            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ERRO AO CADASTRAR: " + e.getMessage());
            return false;
        }
    }
}
