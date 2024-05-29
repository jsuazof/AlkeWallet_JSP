package repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DatabaseConnection;
import model.Customer;

public class CustomerRepo extends DatabaseConnection implements Repository<Customer>{
   

    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setName(resultSet.getString("name"));
        customer.setLast_name(resultSet.getString("last_name"));
        customer.setRut(resultSet.getString("rut"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPassword(resultSet.getString("password"));
        return customer;

    }

    public static void main(String[] args) {
        CustomerRepo repo = new CustomerRepo();
        Customer customer = new Customer( 2,"Oskar", "Pinochet", "12345679-3","opinochet@email.com","123456");
        try {
            List<Customer> customers = repo.read();
            System.out.println(customers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int create(Customer customer) throws SQLException {
        String sql = String.format("INSERT INTO customer (id, name, last_name, rut, email, password)" + "VALUES ('%d', '%s', '%s', '%s')"
                , customer.getId(), customer.getName(), customer.getLast_name(), customer.getRut(), customer.getEmail(),customer.getPassword());

        return this.executeSql(sql);
    }

    @Override
    public List<Customer> read() throws SQLException {
        String str = "SELECT * FROM cliente";
        this.query(str);
        List<Customer> customers = new ArrayList<>();
        while(rs.next()) {
            Customer customer = crearCliente(rs);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public int update(Cliente cliente) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public void create(Customer t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public List<Customer> read() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

 
  
}
