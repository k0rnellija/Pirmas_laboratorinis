package vu.lt.persistence;

import vu.lt.entities.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class MoviesDAO {
    @PersistenceContext
    private EntityManager em;

    public void create(Movie movie) { em.persist(movie);}

    public List<Movie> getAllMovies() {
       return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
    }

    public void persist(Movie movie) {
        this.em.persist(movie);
    }
}
