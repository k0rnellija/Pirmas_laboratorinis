package persistence;

import entities.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class MoviesDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Movie> loadAll() {
        return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Movie movie) {
        this.em.persist(movie);
    }
}
