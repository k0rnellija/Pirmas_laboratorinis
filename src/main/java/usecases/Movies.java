package usecases;

import entities.Movie;
import persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Movies implements Serializable {

    @Inject
    private MoviesDAO moviesDAO;

    private Movie movieToCreate = new Movie();

    private List<Movie> allMovies;

    @PostConstruct
    public void init() {
        loadMovies();
    }

    public void loadMovies() {
        this.allMovies = moviesDAO.loadAll();
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    @Transactional
    public String createMovie() {
        this.moviesDAO.persist(movieToCreate);
        return "success";
    }

    public Movie getMovieToCreate() {
        return movieToCreate;
    }

    public void setMovieToCreate(Movie movieToCreate) {
        this.movieToCreate = movieToCreate;
    }
}
