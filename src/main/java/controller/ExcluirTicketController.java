package controller;


import dao.TicketDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TicketModel;

import java.io.IOException;

@WebServlet("/ticket/excluir")
public class ExcluirTicketController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        TicketModel ticket = new TicketModel();

        ticket.setId(Integer.parseInt(request.getParameter("id")));

        TicketDao dao = new TicketDao();
        if(dao.deletar(ticket.getId())){
            response.sendRedirect(request.getContextPath() + "/pages/quadro.html");
        }else {
            response.sendRedirect(request.getContextPath() + "/pages/quadro.html");
        }
    }
}
