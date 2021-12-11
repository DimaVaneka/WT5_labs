package by.bsuir.hotel.command.user;

import by.bsuir.hotel.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userType");
        session.removeAttribute("errorLoginOrPassword");
        return "/hotelsminsk";
    }
}
