package vu.lt.persistence;

import vu.lt.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import java.util.List;

@ApplicationScoped
public class CategoriesDAO {
    @PersistenceContext (synchronization = SynchronizationType.SYNCHRONIZED)

    private EntityManager em;

    public void create (Category category) {em.persist(category);}

    public void persist(Category category) {
        this.em.persist(category);
    }

    public List<Category> getAllCategories() {return em.createNamedQuery("Category.findAll", Category.class).getResultList();}

    public Category findById(Integer id) {
        return em.find(Category.class, id);
    }
}
