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
        RequestDispatcher dispatcher;
        PersonService ps = new PersonService();
        try {
            ps.delete(parseInt(req.getParameter("idsupprimer")));
            String refererURI = new URI(req.getHeader("referer")).getPath();
            if(refererURI.equals("/GestionEtablissement-web/liststudent"))
            {
                resp.sendRedirect(req.getContextPath() + "/liststudent");
            }
            else
            {
                resp.sendRedirect(req.getContextPath() + "/managestudent");
            }
        } catch (ExceptionService | URISyntaxException es) {
            req.setAttribute("error", es.getMessage());
            dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}