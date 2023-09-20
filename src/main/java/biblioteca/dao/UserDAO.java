package biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import biblioteca.model.User;

public class UserDAO {
    

    private EntityManagerFactory emf = Persistence
                                        .createEntityManagerFactory("persistence-biblioteca");

    private EntityManager em = emf.createEntityManager();

    public UserDAO() {

    }

    public void create(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public User read(int id){
        User user = em.find(User.class, id);
        em.close();
        emf.close();
        return user;
    }

    public void remove(int id){
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        emf.close();

        
    }

    
}
