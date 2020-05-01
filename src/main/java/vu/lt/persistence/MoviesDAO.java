package vu.lt.persistence;

import vu.lt.entities.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class MoviesDAO {
    @Inject
    private EntityManager em;

    public List<Movie> getAllMovies() {
       return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
    }

    public void persist(Movie movie) {
        this.em.persist(movie);
    }

    public Movie findOne(Integer id){
        return em.find(Movie.class, id);
    }

    public void updateAndFlush(Movie movie){
        em.merge(movie);
        em.flush();
    }
}
