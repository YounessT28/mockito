package eu.ensup.gestionetablissement.web;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.service.ConnectionService;
import eu.ensup.gestionetablissement.service.ExceptionService;
import eu.ensup.gestionetablissement.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@WebServlet(
        name = "Connexion",
        urlPatterns = "/connexion"
)
public class Connexion extends HttpServlet {

    public Connexion() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        ConnectionService sc = new ConnectionService();
        PersonService sp = new PersonService();
        RequestDispatcher dispatcher;

        int idConnexion = 0;
        dispatcher = req.getRequestDispatcher("index.jsp");
        try {
            idConnexion = sc.checkConnection(userName, password);
            PersonDTO p = sp.get(idConnexion);
            Role r = p.getRole();
            if (r.getNum() == 1 || r.getNum() == 2) {
                session.setAttribute("email", req.getParameter("email"));
                dispatcher = req.getRequestDispatcher("mainmenu.jsp");
            }
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
        }
        dispatcher.forward(req, resp);
    }
}