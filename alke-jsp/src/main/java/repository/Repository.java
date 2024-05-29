package repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
      //implemetar CRUD

    //Create
    void create(T t) throws SQLException;

    //Read
    List<T> read() throws SQLException;

    //Update
    void update(T t) throws SQLException;

    //Delete
    void delete(int id) throws SQLException;

}
