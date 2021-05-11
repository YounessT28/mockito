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
import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

@WebServlet(
        name = "DeleteStudent",
        urlPatterns = "/deletestudent"
)
public class DeleteStudent extends HttpServlet {

    public DeleteStudent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonService ps = new PersonService();
        String refererURI = null;
        String posturi = null;
        // Définition de l'url de renvoit en fonction de l'url précédent
        try {
            refererURI = new URI(req.getHeader("referer")).getPath();
            if(refererURI.equals("/GestionEtablissement-web/liststudent"))
            {
                posturi = "/liststudent";
            }
            else
            {
                posturi = "/managestudent";
            }
        } catch (URISyntaxException e) {
            RequestDispatcher dispatcher;
            dispatcher = req.getRequestDispatcher("error.jsp");
        }
        // Suppresion de l'étudiant
        try {
            ps.delete(parseInt(req.getParameter("idsupprimer")));
            req.setAttribute("message", "L'étudiant a bien été supprimé");
            resp.sendRedirect(req.getContextPath() + posturi);
        } catch (ExceptionService es) {
            resp.sendRedirect(req.getContextPath() + posturi);
            req.setAttribute("message", es.getMessage());
        }
    }
}