package usecases;

import entities.Category;
import entities.Movie;
import lombok.Getter;
import lombok.Setter;
import persistence.CategoriesDAO;
import persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class MoviesInCategory implements Serializable {


    @Inject
    private CategoriesDAO categoriesDAO;

    @Inject
    private MoviesDAO moviesDAO;

    @Getter
    @Setter
    private Category category;

    @Getter
    @Setter
    private Movie movieToCreate = new Movie();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer categoryId = Integer.parseInt(requestParameters.get("categoryId"));
        this.category = categoriesDAO.findOne(categoryId);
    }

    @Transactional
    public String createMovie(){
        movieToCreate.setCategory(this.category);
        moviesDAO.persist(movieToCreate);
        return "/movies.xhtml?faces-redirect=true&categoryId=" + this.category.getId();
    }
}
