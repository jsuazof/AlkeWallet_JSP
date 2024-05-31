package services;

import java.util.Optional;

import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginServiceImpl {
    private UserDao userDao = new UserDao();
    @Override
    public Optional<String> getName(HttpServletRequest req) {
        HttpSession session = req.getSession(); //crear la sesion
        String username = (String) session.getAttribute("username");
        if (username != null) //usuario creado
            {
            return Optional.of(username);
            }
        return Optional.empty(); //no iniciará una sesion el sistema
    }
}
