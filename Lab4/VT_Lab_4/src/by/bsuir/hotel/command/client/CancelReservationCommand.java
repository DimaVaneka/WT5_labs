package by.bsuir.hotel.command.client;

import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.dao.HotelDAO;
import by.bsuir.hotel.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CancelReservationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        int requestId = Integer.parseInt(request.getParameter("requestid"));
        int placesCount = Integer.parseInt(request.getParameter("placescount"));
        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        try {
            RequestDAO.INSTANCE.deleteEntity(requestId);
            HotelDAO.INSTANCE.updatePlacesCount(hotelId, placesCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowClientHotelsCommand().execute(request);
        return "/hotelsminsk";
    }
}
