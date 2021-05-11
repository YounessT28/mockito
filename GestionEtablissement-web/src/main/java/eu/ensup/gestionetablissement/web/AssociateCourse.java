package eu.ensup.gestionetablissement.web;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.CourseDTO;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.service.ConnectionService;
import eu.ensup.gestionetablissement.service.CourseService;
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
        name = "AssociateCourse",
        urlPatterns = "/associatecourse"
)
public class AssociateCourse extends HttpServlet {

    public AssociateCourse() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCourse = Integer.parseInt(req.getParameter("selectcourse"));
        int idStudent = Integer.parseInt(req.getParameter("selectstudent"));

        PersonService ps = new PersonService();
        try {
            ps.linkToCourse(idStudent, idCourse);
            req.setAttribute("message", "Le cours a été associé");
            resp.sendRedirect(req.getContextPath() + "/managecourse");
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
            resp.sendRedirect(req.getContextPath() + "/managecourse");
        }

    }
}