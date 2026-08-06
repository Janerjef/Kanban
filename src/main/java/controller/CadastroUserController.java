package controller;

import dao.CadastroUserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CadastroUserModel;

import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroUserController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException{

        CadastroUserModel user = new CadastroUserModel();

        user.setNomeUsuario(request.getParameter("nomeDeUsuario"));
        user.setSenha(request.getParameter("senha"));
        user.setEmail(request.getParameter("email"));
        user.setNome(request.getParameter("nome"));
        user.setSobrenome(request.getParameter("sobrenome"));

        CadastroUserDao dao = new CadastroUserDao();

        if(dao.cadastrar(user)){
            response.sendRedirect(request.getContextPath() + "/index.html");
        }else{
            response.sendRedirect(request.getContextPath() + "/pages/cadastro.html");
        }
    }
}
