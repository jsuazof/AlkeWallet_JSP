package services;

import jakarta.servlet.http.HttpServletRequest;
import model.Customer;

import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest request);
    boolean authenticate(String email, String password);
    Optional<Customer> getCustomer(String email);
}
