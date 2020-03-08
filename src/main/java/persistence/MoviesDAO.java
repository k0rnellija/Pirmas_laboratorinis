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

    public void create(Movie movie) { em.persist(movie);}

    public void persist(Movie movie) {
        this.em.persist(movie);
    }
}
