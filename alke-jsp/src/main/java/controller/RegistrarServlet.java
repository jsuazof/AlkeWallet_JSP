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
import model.User;

@WebServlet("/registrarse")
public class RegistrarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User usuario = null;
        UserDao usuarioDAO = new UserAccess();
        RequestDispatcher dispatcher = null;

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        try {
            usuario = new User(nombre, apellido, correo, clave, 0.0);
            int operacion = usuarioDAO.guardar(usuario);

            if (operacion > 0) {
                request.setAttribute("status", "success");
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("status", "failed");
            request.setAttribute("errorMessage", "Error al registrar usuario.");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
