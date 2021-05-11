package eu.ensup.gestionetablissement.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.ensup.gestionetablissement.business.Person;
import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dto.PersonDTO;
import eu.ensup.gestionetablissement.dto.StudentDTO;
import eu.ensup.gestionetablissement.service.ConnectionService;
import eu.ensup.gestionetablissement.service.ExceptionService;
import eu.ensup.gestionetablissement.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(
        name = "Test",
        urlPatterns = "/studentapi"
)
public class StudentAPI extends HttpServlet {

    public StudentAPI() {
        super();
    }
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonService ps = new PersonService();
        List<PersonDTO> personList = new ArrayList<>();
        String employeeJsonString = "";
        int nbStudent = 0;
        String id = req.getParameter("id");

        try {
            PersonDTO persondto = ps.get(parseInt(id));
            if(((StudentDTO)persondto).getAverage() < 20 && ((StudentDTO)persondto).getAverage() > 0){
                //
            }
            else
            {
                ((StudentDTO)persondto).setAverage(0);
            }
            employeeJsonString = this.gson.newBuilder().setDateFormat("MM-dd-yyyy").create().toJson(persondto);
        } catch (ExceptionService es) {
            req.setAttribute("error", es.getMessage());
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Post
    }
}