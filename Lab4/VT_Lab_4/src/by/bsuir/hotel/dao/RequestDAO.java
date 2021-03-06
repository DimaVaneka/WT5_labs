package by.bsuir.hotel.dao;



import by.bsuir.hotel.entity.Request;
import by.bsuir.hotel.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum RequestDAO implements AbstractDAO<Request> {
    INSTANCE;

    @Override
    public List<Request> findAll() throws SQLException {
        return null;
    }

    @Override
    public void createEntity(Request entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `hotelmanagerbd`.`requests` (`user_id`, `hotel_id`, `places_count`) VALUES (?, ?, ?);");
        statement.setString(1, String.valueOf(entity.getUserId()));
        statement.setString(2, String.valueOf(entity.getHotelId()));
        statement.setString(3, String.valueOf(entity.getPlacesCount()));
        statement.execute();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Request getEntityById(int id) throws SQLException {
        return null;
    }

    public void deleteEntity(int id) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `hotelmanagerbd`.`requests` WHERE `id`=?;");
        statement.setInt(1, id);
        statement.execute();
    }


    public List<Request> getEntitiesByUserId(int id) throws SQLException {

        List<Request> requestList = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT requests.id, requests.places_count, requests.user_id, hotels.name, hotels.id as hotel_id FROM hotelmanagerbd.requests INNER JOIN hotelmanagerbd.hotels ON requests.hotel_id=hotels.id WHERE user_id=?;");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Request request = new Request();
            request.setId(resultSet.getInt("id"));
            request.setUserId(resultSet.getInt("user_id"));
            request.setHotelName(resultSet.getString("name"));
            request.setPlacesCount(resultSet.getInt("places_count"));
            request.setHotelId(resultSet.getInt("hotel_id"));
            requestList.add(request);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return requestList;
    }
}
