package persistence;

import entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CategoriesDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Category> loadAll() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Category category) {
        this.em.persist(category);
    }

    public Category findOne(Integer id) {
        return em.find(Category.class, id);
    }
}
