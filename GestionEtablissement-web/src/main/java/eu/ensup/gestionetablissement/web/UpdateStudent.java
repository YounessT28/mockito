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
        /*
        "firstname = ?, " +
                    "lastname = ?, " +
                    "address =  ?, "+
                    "phone = ?, "+
                    "role = ?, "+
                    "password = ?, "+
                    "dateofbirth = ?, "+
                    "subjecttaught = ?, "+
                    "average = ? "+
                    "WHERE email = ?";
         */
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("error.jsp");

        try {
            //Create course with parameters
            PersonService sp = new PersonService();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            Date auj = sdf.parse(req.getParameter("datenaissance"));
            //String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught, double average
            sp.update(req.getParameter("nom"), req.getParameter("email"), req.getParameter("adresse"), req.getParameter("telephone"), req.getParameter("prenom"), req.getParameter("mdp"), 4, auj ,"", Double.parseDouble(req.getParameter("moyenne")));

            String refererURI = new URI(req.getHeader("referer")).getPath();
            if(refererURI.equals("/GestionEtablissement-web/updatestudentpage"))
            {
                resp.sendRedirect(req.getContextPath() + "/liststudent");
            }
            else
            {
                resp.sendRedirect(req.getContextPath() + "/managestudent");
            }
        } catch (NumberFormatException | ParseException nfe) {
            req.setAttribute("error","Un des paramètre n'a pas été enseigné");
        } catch (ExceptionService es) {
            req.setAttribute("error", es.getMessage());
            dispatcher.forward(req, resp);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}

