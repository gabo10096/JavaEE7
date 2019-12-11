package org.certificatic.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    final static Logger logger = LoggerFactory.getLogger(TestServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headers = request.getHeaderNames();
        String header;
        while (headers.hasMoreElements() != false){
            header = headers.nextElement();
            String message = header + " : " + request.getHeader(header);
            logger.info("*** logger {} ***", message);
        }
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
