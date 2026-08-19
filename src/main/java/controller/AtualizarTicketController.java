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

@WebServlet("/ticket/atualizar")
public class AtualizarTicketController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        TicketModel ticket = new TicketModel();

        ticket.setId(Integer.parseInt("id"));
        ticket.setTitulo(request.getParameter("titulo"));
        ticket.setTexto(request.getParameter("texto"));
        ticket.setAreaId(Integer.parseInt("area_id"));

        TicketDao dao = new TicketDao();
        if(dao.atualizar(ticket)){
            response.sendRedirect(request.getContextPath() + "/pages/quadro.html");
        }else{
            response.sendRedirect(request.getContextPath() + "");
        }
    }
}
