package persistence;

import entities.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ProducersDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Producer> loadAll() {
        return em.createNamedQuery("Producer.findAll", Producer.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Producer producer) {
        this.em.persist(producer);
    }

    public Producer findOne(Integer id) {
        return em.find(Producer.class, id);
    }
}
