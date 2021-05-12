package eu.ensup.gestionetablissement.web;

import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.CourseDTO;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.dto.StudentDTO;
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
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "ManageMark",
        urlPatterns = "/managemark"
)
public class ManageMark extends HttpServlet {

    public ManageMark() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("gerernotes.jsp");
        // Liste de cours
        CourseService cs = new CourseService();
        List<CourseDTO> courseList = new ArrayList();
        try {
            for(CourseDTO p : cs.getAll()){
                courseList.add(p);
            }
            req.setAttribute("course", courseList);
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
        }

        // Liste d'étudiants
        PersonService ps = new PersonService();
        List<PersonDTO> personList = new ArrayList();
        try {
            for(PersonDTO p : ps.getAll()){
                if(p instanceof StudentDTO) {
                    personList.add(p);
                }
            }
            req.setAttribute("person", personList);
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
        }
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Post
    }

    public static void listCourse(HttpServletRequest req, HttpServletResponse resp){
        // Liste de cours
        CourseService cs = new CourseService();
        List<CourseDTO> courseList = new ArrayList();
        try {
            for(CourseDTO p : cs.getAll()){
                courseList.add(p);
            }
            req.setAttribute("course", courseList);
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
        }
    }

    public static void listStudent(HttpServletRequest req, HttpServletResponse resp){
        // Liste d'étudiants
        PersonService ps = new PersonService();
        List<PersonDTO> personList = new ArrayList();
        try {
            for(PersonDTO p : ps.getAll()){
                if(p instanceof StudentDTO) {
                    personList.add(p);
                }
            }
            req.setAttribute("person", personList);
        } catch (ExceptionService es) {
            req.setAttribute("message", es.getMessage());
        }
    }
}