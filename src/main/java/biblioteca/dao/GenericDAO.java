package biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GenericDAO<T> {
    
    private Class<T> classe;

    private EntityManagerFactory emf = Persistence
                                        .createEntityManagerFactory("persistence-biblioteca");

    private EntityManager em = emf.createEntityManager();

    
    public GenericDAO(Class<T> classe) {
        this.classe = classe;
    }

    public void create(T obj){
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public T read(int id){
        T obj = em.find(classe, id);
        em.close();
        emf.close();
        return obj;
    }

    public void remove(int id){
        T obj = em.find(classe, id);
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();

        
    }

    
}
