package lv.itlat.helloweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloWebServlet", urlPatterns = {"/hello"}, loadOnStartup = 1)
public class HelloWebServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html lang=\"en\">");
        writer.println("<body>");
        writer.println("<h1>Hello from WEB Servlet<h1>");
    }


}
