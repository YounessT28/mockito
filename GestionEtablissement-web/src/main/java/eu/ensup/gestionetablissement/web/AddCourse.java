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
        name = "AddCourse",
        urlPatterns = "/addcourse"
)
public class AddCourse extends HttpServlet {

    public AddCourse() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("creeretudiant.jsp");
        //If nb hours is not numeric return msgbox
        try {
            float f = Float.parseFloat(req.getParameter("nbheures"));

            //Create course with parameters
            CourseService cs = new CourseService();
            CourseDTO c = new CourseDTO(req.getParameter("theme"), f);
            cs.create(c);
        } catch (ExceptionService es) {
            dispatcher = req.getRequestDispatcher("error.jsp");
            req.setAttribute("error", es.getMessage());
        }
        dispatcher.forward(req, resp);
    }
}