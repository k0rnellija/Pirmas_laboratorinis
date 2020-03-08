package usecases;

import entities.Category;
import entities.Movie;
import lombok.Getter;
import persistence.CategoriesDAO;
import persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class MoviesAndCategories {

    @Getter
    private Movie movie = new Movie();

    @Getter
    private Category category = new Category();

    @Getter
    private List<Category> allCategories;

    @PostConstruct
    public void init() {loadAllDishes();}

    @Inject
    private MoviesDAO moviesDAO;

    @Inject
    private CategoriesDAO categoriesDAO;

    @Transactional
    public void createMovieCategory(){
        category.getMovieList().add(movie);
        movie.getCategoryList().add(category);
        moviesDAO.create(movie);
        categoriesDAO.create(category);
    }

    private void loadAllDishes() {
        allCategories = categoriesDAO.getAllCategories();
    }


}
