package biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import biblioteca.model.Admin;

public class AdminDAO extends GenericDAO<Admin> {

     private EntityManagerFactory emf = Persistence
                                        .createEntityManagerFactory("persistence-biblioteca");

    private EntityManager em = emf.createEntityManager();

    public AdminDAO(){
        super(Admin.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<Admin> find (String nome){
        
        List<Admin> admins = em.createQuery("from Admin where nome = :customName").setParameter("customName",nome).getResultList();
        em.close();
        emf.close();
        return admins;

    }

    
}
