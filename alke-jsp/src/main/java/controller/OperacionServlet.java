package controller;

import dao.UserAccess;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet("/operacion")
public class OperacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao usuarioDAO = new UserAccess();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            User usuario = (User) session.getAttribute("usuario");
            int id = usuario.getId();

            String operacionDepositar = request.getParameter("operacionDepositar");
            String operacionRetirar = request.getParameter("operacionRetirar");

            if (operacionDepositar != null) {
                Double monto = Double.parseDouble(request.getParameter("monto"));
                int exitoso = usuarioDAO.depositar(monto, id);
                if (exitoso > 0) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "failed");
                }
            } else if (operacionRetirar != null) {
                Double monto = Double.parseDouble(request.getParameter("monto"));
                if (usuario.getSaldo() >= monto) {
                    int exitoso = usuarioDAO.retirar(monto, id);
                    if (exitoso > 0) {
                        session.setAttribute("status", "success");
                    } else {
                        session.setAttribute("status", "failed");
                    }
                } else {
                    session.setAttribute("status", "failed");
                }
            }
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }
    }
}
