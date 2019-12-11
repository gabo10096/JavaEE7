package org.certificatic.ejb;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "TestEjbServlet", urlPatterns = {"/TestEjbServlet"})
public class TestEjbServlet extends HttpServlet {
    @EJB
    private HelloBean helloBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headers = request.getHeaderNames();
        String header;
        while (headers.hasMoreElements() != false){
            header = headers.nextElement();
            String message = header + " : " + request.getHeader(header);
        }
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestEjbServlet </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Servlet TestEjbServlet at " + helloBean.getMessageFor("gabriel")+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
