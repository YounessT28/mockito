package eu.ensup.gestionetablissement.web;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.CourseDTO;
import eu.ensup.gestionetablissement.dto.MarkDTO;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.service.*;

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
        name = "AddMark",
        urlPatterns = "/addmark"
)
public class AddMark extends HttpServlet {

    public AddMark() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCourse = Integer.parseInt(req.getParameter("selectcourse"));
        int idStudent = Integer.parseInt(req.getParameter("selectstudent"));

        MarkService ps = new MarkService();
        try {
            ps.create(new MarkDTO( idStudent, idCourse, Float.parseFloat(req.getParameter("mark")), req.getParameter("appreciations")));
            req.setAttribute("message", "La note a bien été ajouté");
            resp.sendRedirect(req.getContextPath() + "/managemark");
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
            resp.sendRedirect(req.getContextPath() + "/managemark");
        }
    }
}