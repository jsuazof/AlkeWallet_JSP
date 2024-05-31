package repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
      //implemetar CRUD

    //Create
    int create(T t) throws SQLException;

    //Read
    List<T> read() throws SQLException;

    //Update
    int update(T t) throws SQLException;

    //Delete
    int delete(int id) throws SQLException;

}
