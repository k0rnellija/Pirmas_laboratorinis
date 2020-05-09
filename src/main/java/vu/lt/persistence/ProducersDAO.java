package vu.lt.persistence;

import vu.lt.entities.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProducersDAO {
    @Inject
    private EntityManager em;

    public List<Producer> loadAll() {
        return em.createNamedQuery("Producer.findAll", Producer.class).getResultList();
    }

    public void persist(Producer producer) {
        this.em.persist(producer);
    }

    public Producer findOne(Integer id) {
        return em.find(Producer.class, id);
    }

    public void updateAndFlush(Producer producer) {
        em.merge(producer);
        em.flush();
    }
}
