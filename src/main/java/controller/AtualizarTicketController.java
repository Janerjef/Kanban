package controller;

import dao.CadastroTicketDao;
import dao.TicketDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TicketModel;

import java.io.IOException;

@WebServlet("/ticket/listar")
public class AtualizarTicketController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        TicketModel ticket = new TicketModel();

        ticket.setTitulo(request.getParameter(""));
        ticket.setStatus(request.getParameter(""));
        ticket.setTexto(request.getParameter(""));

        TicketDao dao = new TicketDao();
        if(dao.atualizar(ticket)){
            response.sendRedirect(request.getContextPath() + "");
        }else{
            response.sendRedirect(request.getContextPath() + "");
        }
    }
}
