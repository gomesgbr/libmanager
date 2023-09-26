package biblioteca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.GenericDAO;
import biblioteca.model.User;


@WebServlet("/adicionarUsuario")
public class AddUserServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request,
     HttpServletResponse response) throws ServletException, IOException, ServletException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");

        GenericDAO<User> userDAO = new GenericDAO<User>(User.class);
        User user = new User(null, nome, cpf);

        userDAO.create(user);
        System.out.println("Nome: " + nome + "\nCPF: " + cpf);
    }
    
}
