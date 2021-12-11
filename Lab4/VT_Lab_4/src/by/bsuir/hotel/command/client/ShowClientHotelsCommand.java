package by.bsuir.hotel.command.client;

import by.bsuir.hotel.entity.User;
import by.bsuir.hotel.entity.Hotel;
import by.bsuir.hotel.entity.Request;
import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.dao.HotelDAO;
import by.bsuir.hotel.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowClientHotelsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();

            List<Hotel> hotelList = HotelDAO.INSTANCE.findAll();
            session.setAttribute("hotelList",hotelList);
            User user = (User)session.getAttribute("user");
            List<Request> requestList = RequestDAO.INSTANCE.getEntitiesByUserId(user.getId());
            session.setAttribute("requestList",requestList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/client/main.jsp";
    }
}
