package controller;

import java.io.IOException;

import dao.UserAccess;
import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String LOGIN_URL = "login";
    private static final String HOME_JSP = "home.jsp";

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar el DAO aquí para evitar crear múltiples instancias en cada solicitud
        userDao = new UserAccess();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(LOGIN_URL);
        } else {
            Object idObj = session.getAttribute("id");

            if (idObj instanceof Integer) {
                int id = (int) idObj;
                User user = userDao.obtenerUsuarioPorID(id);
                if (user != null) {
                    session.setAttribute("usuario", user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(HOME_JSP);
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect(LOGIN_URL);
                }
            } else {
                response.sendRedirect(LOGIN_URL);
            }
        }
    }
}
