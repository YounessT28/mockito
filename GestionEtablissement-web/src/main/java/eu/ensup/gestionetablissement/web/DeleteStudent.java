package eu.ensup.gestionetablissement.web;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.dto.StudentDTO;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        RequestDispatcher dispatcher;
        try {
            ps.delete(parseInt(req.getParameter("idsupprimer")));
            req.setAttribute("message", "L'étudiant a bien été supprimé");
            refererURI = new URI(req.getHeader("referer")).getPath();
            if(refererURI.equals("/GestionEtablissement-web/liststudent"))
            {
                dispatcher = req.getRequestDispatcher("listeetudiant.jsp");
                ManageStudent.listStudent(req, resp);
                dispatcher.forward(req, resp);
            }
            else
            {
                dispatcher = req.getRequestDispatcher("gereretudiant.jsp");
                ManageStudent.listStudent(req, resp);
                dispatcher.forward(req, resp);
            }
        } catch (URISyntaxException | ExceptionService es) {
            System.out.println(es.getMessage());
            req.setAttribute("message", "L'étudiant a des cours qui lui sont associé, on ne peut donc pas le supprimer");
            ManageStudent.listStudent(req, resp);
            try { refererURI = new URI(req.getHeader("referer")).getPath(); } catch (URISyntaxException e) {  dispatcher = req.getRequestDispatcher("error.jsp"); }
            if(refererURI.equals("/GestionEtablissement-web/liststudent"))
            {
                dispatcher = req.getRequestDispatcher("listeetudiant.jsp");
            }
            else
            {
                dispatcher = req.getRequestDispatcher("gereretudiant.jsp");
            }
            dispatcher.forward(req, resp);
        }
    }
}