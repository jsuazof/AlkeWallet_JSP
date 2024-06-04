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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INDEX_JSP = "index.jsp";
    private static final String HOME_URL = "home";
    
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar el DAO aquí para evitar crear múltiples instancias en cada solicitud
        userDao = new UserAccess();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX_JSP);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        User usuario = userDao.obtenerUsuario(correo, clave);

        if (usuario != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", usuario.getId());
            response.sendRedirect(HOME_URL);
        } else {
            request.setAttribute("status", "failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX_JSP);
            dispatcher.forward(request, response);
        }
    }
}
