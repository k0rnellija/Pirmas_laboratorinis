package usecases;

import entities.Category;
import entities.Movie;
import entities.Producer;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import persistence.CategoriesDAO;
import persistence.MoviesDAO;
import persistence.ProducersDAO;

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
    private Producer producer = new Producer();

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
        //movie.setProducer(this.producer);
        categoriesDAO.create(category);
        moviesDAO.create(movie);
    }

    private void loadAllMovies() {
        allMovies = moviesDAO.getAllMovies();
    }

}
