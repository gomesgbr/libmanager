package biblioteca;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/segundaServlet")
public class PrimeiraServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request,
     HttpServletResponse response) throws ServletException, IOException, ServletException {
        
        
        PrintWriter pw = response.getWriter();

        pw.println("<h1> É o trikas </h1>");
    }
    
}
