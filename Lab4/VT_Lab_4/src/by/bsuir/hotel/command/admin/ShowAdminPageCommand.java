package by.bsuir.hotel.command.admin;

import by.bsuir.hotel.dao.HotelDAO;
import by.bsuir.hotel.entity.Hotel;
import by.bsuir.hotel.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowAdminPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();

            List<Hotel> hotelList = HotelDAO.INSTANCE.findAll();
            session.setAttribute("hotelList",hotelList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/admin/main.jsp";
    }
}
