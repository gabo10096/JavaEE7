package cdi;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InjectedServlet", urlPatterns = {"/InjectedServlet", "/injected-servlet"})
public class InjectedServlet extends HttpServlet {

    @Inject
    @SecondMessage
    private Message myMessage;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InjectedServlet </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Servlet InjectedServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>" + myMessage.get() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String getServletInfo(){
        return "Injected Servlet";
    }

}
