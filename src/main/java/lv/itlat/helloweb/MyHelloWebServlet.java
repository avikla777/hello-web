package lv.itlat.helloweb;

import lv.itlat.helloweb.helper.FormValidator;
import lv.itlat.helloweb.model.Person;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(name = "myHelloWebServlet", urlPatterns = {"/myhello"})

public class MyHelloWebServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(MyHelloWebServlet.class);

    @Inject
    private FormValidator formValidator;

    @Override
    public void init() throws ServletException {
        logger.info("Servlet initialized.");
        logger.info("FV: " + formValidator);
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").include(req, resp);
//        resp.setContentType("text/html");
//        PrintWriter writer = resp.getWriter();
//        writer.println("Privet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.info("Servlet post method started.");


        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        formValidator.validateRegistration(firstName, lastName, email);

        final Map<String, String> errors = formValidator.getErrors();
        if(!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            doGet(req, resp);
            return;
        }

        final Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);

        req.setAttribute("person", person);
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);

//        logger.info("Mandatory fields: " + firstName + " " + lastName + " " + email);

//        String gender = req.getParameter("gender");
        String notify =req.getParameter("notify");
//        String comment = req.getParameter("comment");
////        logger.info("Parametrs: " + firstName + " " + lastName + " " + email + " " + gender + "" );
//
//        if (firstName == null || firstName.isEmpty()) {
//            resp.sendError(resp.SC_BAD_REQUEST, "Please enter your name.");
//        }
//
//        if (lastName == null || lastName.isEmpty()) {
//            resp.sendError(resp.SC_BAD_REQUEST, "Please enter your lastname.");
//        }
//
//        if (!email.contains("@") || !email.contains(".") ) {
//            resp.sendError(resp.SC_BAD_REQUEST, "Please write your correct email.");
//        }
//
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>Hello, " + firstName + " " + lastName + "</h1>");
//        writer.println("<h1>Your contact email: " + email + "<h1>");
//        writer.close();
//        logger.info("Setvlet was fineshed.");
    }
}
