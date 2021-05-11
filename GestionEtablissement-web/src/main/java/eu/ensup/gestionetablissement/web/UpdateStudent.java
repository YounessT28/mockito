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
        name = "UpdateStudent",
        urlPatterns = "/updatestudent"
)
public class UpdateStudent extends HttpServlet {

    public UpdateStudent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String refererURI = null, posturi = null;

        // Définition de l'url de renvoit en fonction de l'url précédent
        try {
            refererURI = new URI(req.getHeader("referer")).getPath();
            if(refererURI.equals("/GestionEtablissement-web/updatestudentpage"))
            {
                posturi = "/liststudent";
            }
            else
            {
                posturi = "/managestudent";
            }
        } catch (URISyntaxException e) {
            req.setAttribute("error", e.getMessage());
            dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
        }


        try {
            PersonService sp = new PersonService();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            Date auj = sdf.parse(req.getParameter("datenaissance"));

            sp.update(req.getParameter("nom"), req.getParameter("email"), req.getParameter("adresse"), req.getParameter("telephone"), req.getParameter("prenom"), req.getParameter("mdp"), 4, auj ,"", Double.parseDouble(req.getParameter("moyenne")));

            req.setAttribute("message","L'étudiant a bien été mis à jours");
            resp.sendRedirect(req.getContextPath() + posturi);
        } catch (NumberFormatException | ParseException nfe) {
            req.setAttribute("message","Un des paramètre n'a pas été enseigné");
            resp.sendRedirect(req.getContextPath() + posturi);
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
            resp.sendRedirect(req.getContextPath() + posturi);
        }

    }
}

