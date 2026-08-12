package controller;

import com.google.gson.Gson;
import dao.TicketDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TicketModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ticket/listar")
public class ListarTicketController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        TicketDao dao = new TicketDao();
        List<TicketModel> lista = dao.listar();

        String json = new Gson().toJson(lista);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
