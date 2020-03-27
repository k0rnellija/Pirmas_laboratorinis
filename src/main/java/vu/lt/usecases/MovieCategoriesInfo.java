package vu.lt.usecases;

import vu.lt.entities.Category;
import vu.lt.entities.Movie;
import vu.lt.entities.Producer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import vu.lt.persistence.CategoriesDAO;
import vu.lt.persistence.MoviesDAO;
import vu.lt.persistence.ProducersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@Slf4j
public class MovieCategoriesInfo {

    @Getter
    private Category category = new Category();

    @Getter
    private Movie movie = new Movie();

    @Getter
    private Producer producer;

    @Getter
    private List<Movie> allMovies;

    @PostConstruct
    public void init() {loadAllMovies();}

    @Inject
    private CategoriesDAO categoriesDAO;

    @Inject
    private MoviesDAO moviesDAO;

    @Inject
    private ProducersDAO producersDAO;

    @Transactional
    public void createMovieCategory() {
        movie.getCategoryList().add(category);
        category.getMovieList().add(movie);
        producer.getName();
    }
    private void loadAllMovies() {
        allMovies = moviesDAO.getAllMovies();
    }

}
