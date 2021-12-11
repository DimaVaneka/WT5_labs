package by.bsuir.hotel.dao;

import by.bsuir.hotel.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO <T extends Entity> {
    List<T> findAll() throws SQLException;
    void createEntity(T entity) throws SQLException;
    T getEntityById(int id) throws SQLException;
}
