package vu.lt.usecases;

import vu.lt.entities.Category;
import vu.lt.entities.Movie;
import lombok.Getter;
import vu.lt.persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class MovieCategoriesInfo {

    @Getter
    private Category category = new Category();

    @Getter
    private Movie movie = new Movie();

    @Getter
    private List<Movie> allMovies;

    @PostConstruct
    public void init() {loadAllMovies();}

    @Inject
    private MoviesDAO moviesDAO;


    @Transactional
    public void createMovieCategory() {
        movie.getCategoryList().add(category);
        category.getMovieList().add(movie);
    }
    private void loadAllMovies() {
        allMovies = moviesDAO.getAllMovies();
    }

}
