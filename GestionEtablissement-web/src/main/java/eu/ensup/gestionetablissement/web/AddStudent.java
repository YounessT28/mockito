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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(
        name = "AddStudent",
        urlPatterns = "/addstudent"
)
public class AddStudent extends HttpServlet {

    public AddStudent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("creeretudiant.jsp");
        try {
            PersonService sp = new PersonService();

            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            Date auj = sdf.parse(req.getParameter("datenaissance"));
            sp.create(req.getParameter("nom"), req.getParameter("email"), req.getParameter("adresse"), req.getParameter("tel"), req.getParameter("prenom"), req.getParameter("mdp"), 4, auj ,"");
            req.setAttribute("message", "L'étudiant a bien été créé");
        } catch (NumberFormatException | ParseException nfe) {
            req.setAttribute("message", nfe.getMessage());
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
        }
        dispatcher.forward(req, resp);
    }
}