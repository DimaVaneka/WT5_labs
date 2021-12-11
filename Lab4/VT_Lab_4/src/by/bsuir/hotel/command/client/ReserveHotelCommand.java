package by.bsuir.hotel.command.client;

import by.bsuir.hotel.entity.Request;
import by.bsuir.hotel.entity.User;
import by.bsuir.hotel.command.Command;
import by.bsuir.hotel.dao.HotelDAO;
import by.bsuir.hotel.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ReserveHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {


        Request requestEntity = new Request();
        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        int placesCount = Integer.parseInt(request.getParameter("reservedplacescount"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        requestEntity.setUserId(user.getId());
        requestEntity.setPlacesCount(placesCount);
        requestEntity.setHotelId(hotelId);

        try {
            RequestDAO.INSTANCE.createEntity(requestEntity);
            HotelDAO.INSTANCE.updatePlacesCount(requestEntity.getHotelId(),-requestEntity.getPlacesCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowClientHotelsCommand().execute(request);
        return "/hotelsminsk";
    }
}
