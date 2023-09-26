package biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.GenericDAO;
import biblioteca.model.Admin;
import biblioteca.security.CriptografarPwd;

@WebServlet("/CadastroAdmin")
public class CadastroAdminServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, ServletException {

                
                String nome = request.getParameter("nome");
                String passwd = CriptografarPwd.crypt(request.getParameter("passwd"));

                GenericDAO<Admin> genericDAO = new GenericDAO<Admin>(Admin.class);

                Admin admin = new Admin(null, nome, passwd);

                genericDAO.create(admin);

                request.getRequestDispatcher("login.html").forward(request, response);

    }

}
