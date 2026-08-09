package controller;

import dao.TicketDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CadastroUserModel;
import model.TicketModel;

import java.io.IOException;

public class TicketServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        TicketModel ticket = new TicketModel();

        ticket.setStatus(request.getParameter(""));
        ticket.setTitulo(request.getParameter(""));
        ticket.setTexto(request.getParameter(""));


        TicketDao dao =new TicketDao();
        if(dao.cadastrarTicket(ticket)){
            response.sendRedirect(request.getContextPath() + "");
        }else{

        }
    }
}
