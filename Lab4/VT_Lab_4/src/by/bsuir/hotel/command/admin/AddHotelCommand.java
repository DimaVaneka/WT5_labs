package by.bsuir.hotel.command.admin;

import by.bsuir.hotel.entity.Hotel;
import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.dao.HotelDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class AddHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        Hotel hotel = new Hotel();
        hotel.setName(request.getParameter("hotelname"));
        hotel.setPlacesCount(Integer.parseInt(request.getParameter("placescount")));
        try {
            HotelDAO.INSTANCE.createEntity(hotel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowAdminPageCommand().execute(request);
        return "/hotelsminsk";
    }
}
