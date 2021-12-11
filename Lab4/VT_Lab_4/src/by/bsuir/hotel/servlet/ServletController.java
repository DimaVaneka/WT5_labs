package by.bsuir.hotel.servlet;

import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.command.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/hotel")
public class ServletController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String page = null;
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        CommandFactory commandFactory = CommandFactory.INSTANCE;
        Command command = commandFactory.defineCommand(request);
        page = command.execute(request);

        if(page != null){
            response.sendRedirect(request.getContextPath()+page);
        }
        else {
            page = "/index.jsp";
            response.sendRedirect(request.getContextPath()+page);
        }
        response.setCharacterEncoding("UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
