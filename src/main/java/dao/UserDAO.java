package dao;

import Connection.ConnectionFactory;
import model.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public UserModel validarLogin(UserModel userModel){
        String sql
                = "SELECT * FROM users WHERE username = ?";
        try(var con = ConnectionFactory.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,userModel.getUsername());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                String hashBanco = rs.getString("psw");

                boolean senhaValida = util.SenhaUtil.verificarSenha(userModel.getPassword(), hashBanco);

                if(senhaValida){
                    UserModel user = new UserModel();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(hashBanco);

                    return user;
                }


            }
            return null;
        }catch( Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
