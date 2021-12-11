package by.bsuir.hotel.command.admin;

import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.dao.HotelDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DeleteHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        try {
            HotelDAO.INSTANCE.deleteEntity(hotelId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new ShowAdminPageCommand().execute(request);
        return "/hotelsminsk";
    }
}
