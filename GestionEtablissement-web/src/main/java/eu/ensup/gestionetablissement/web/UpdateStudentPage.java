package eu.ensup.gestionetablissement.web;

import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.dto.StudentDTO;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(
        name = "UpdateStudentPage",
        urlPatterns = "/updatestudentpage"
)
public class UpdateStudentPage extends HttpServlet {

    public UpdateStudentPage() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("error.jsp");
        PersonService sp = new PersonService();

        List<PersonDTO> personList = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        try {
            // Données de l'étudiant sélectionné
            PersonDTO personDTO = sp.get(parseInt(req.getParameter("select")));
            String strDate = sdf.format(((StudentDTO) personDTO).getDateOfBirth());
            req.setAttribute("nom", personDTO.getLastname());
            req.setAttribute("prenom", personDTO.getFirstname());
            req.setAttribute("email", personDTO.getMailAddress());
            req.setAttribute("adresse", personDTO.getAddress());
            req.setAttribute("telephone", personDTO.getPhoneNumber());
            req.setAttribute("datenaissance", strDate);
            req.setAttribute("moyenne", ((StudentDTO) personDTO).getAverage());
            req.setAttribute("mdp", ((StudentDTO) personDTO).getPassword());
            // Liste des étudiants
            for(PersonDTO p : sp.getAll()){
                if(p instanceof StudentDTO) {
                    personList.add(p);
                }
            }
            req.setAttribute("person", personList);


            dispatcher = req.getRequestDispatcher("gereretudiant.jsp");
        } catch (ExceptionService es) {
            req.setAttribute("error", es.getMessage());
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("error.jsp");
        PersonService sp = new PersonService();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        try {
            PersonDTO personDTO = sp.get(parseInt(req.getParameter("identifiant")));
            String strDate = sdf.format(((StudentDTO) personDTO).getDateOfBirth());
            req.setAttribute("nom", personDTO.getLastname());
            req.setAttribute("prenom", personDTO.getFirstname());
            req.setAttribute("email", personDTO.getMailAddress());
            req.setAttribute("adresse", personDTO.getAddress());
            req.setAttribute("telephone", personDTO.getPhoneNumber());
            req.setAttribute("datenaissance", strDate);
            req.setAttribute("moyenne", ((StudentDTO) personDTO).getAverage());
            req.setAttribute("mdp", ((StudentDTO) personDTO).getPassword());
            dispatcher = req.getRequestDispatcher("updatestudent.jsp");
        } catch (ExceptionService es) {
            req.setAttribute("error", es.getMessage());
        }
        dispatcher.forward(req, resp);
    }
}
