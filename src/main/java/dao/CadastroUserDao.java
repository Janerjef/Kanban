package dao;

import Connection.ConnectionFactory;
import model.CadastroUserModel;


import java.sql.PreparedStatement;

public class CadastroUserDao {

    public boolean cadastrar(CadastroUserModel user){
        String sql = "INSERT INTO users" +
                "(nome, sobrenome, email, username, psw)" +
                "VALUES(?, ?, ?, ?, ?)";
        try (var con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,user.getNome());
            stmt.setString(2, user.getSobrenome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getNomeUsuario());
            stmt.setString(5, util.SenhaUtil.gerarHash(user.getSenha()));

            stmt.executeUpdate();

            return true;
        } catch(Exception e){
             e.printStackTrace();
            System.out.println("ERRO AO CADASTRAR: " + e.getMessage());
            return false;
        }
    }
}
