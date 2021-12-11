package by.bsuir.hotel.command.user;

import by.bsuir.hotel.entity.User;
import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.command.util.LocalizationCommand;
import by.bsuir.hotel.dao.UserDAO;
import by.bsuir.hotel.command.factory.CommandType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String page = null;
        try{
            if(UserDAO.INSTANCE.isAuthorized(login,password)){
                HttpSession session = request.getSession();
                User user = UserDAO.INSTANCE.getUserByLogin(login);
                session.setAttribute("userType",user.getRole());
                session.setAttribute("user",user);

                if(user.getRole().equals("ROLE_CLIENT")){
                    CommandType type = CommandType.valueOf("SHOWCLIENTPAGE");
                    type.getCurrentCommand().execute(request);
                    page = "/jsp/client/main.jsp";
                }else{
                    CommandType type = CommandType.valueOf("SHOWADMINPAGE");
                    type.getCurrentCommand().execute(request);
                    page="/jsp/admin/main.jsp";
                }
            }else{
                page = "/index.jsp";
                if(login != null && password != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("errorLoginOrPassword", "Invalid login or password");
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
            page = "/index.jsp";
        }
        new LocalizationCommand().execute(request);
        return page;
    }
}
