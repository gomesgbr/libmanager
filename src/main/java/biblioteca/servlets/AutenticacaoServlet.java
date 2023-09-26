package biblioteca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.AdminDAO;
import biblioteca.model.Admin;
import biblioteca.security.CriptografarPwd;

@WebServlet("/Auth")
public class AutenticacaoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, ServletException {

        String nome = request.getParameter("nome");
        String passwd = request.getParameter("passwd");

        AdminDAO adminDAO = new AdminDAO();
        List<Admin> admin = adminDAO.find(nome);

        boolean validAdmin = CriptografarPwd.validHashPasswd(admin.get(0).getSenha(), passwd);

        if(validAdmin){
            request.getRequestDispatcher("index.html").forward(request, response);
        } else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        //Admin admin = new Admin(null, nome, passwd);

        //List<Admin> login = adminDAO.find(nome);

        

    }
}
