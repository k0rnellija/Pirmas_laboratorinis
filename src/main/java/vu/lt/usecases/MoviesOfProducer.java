package vu.lt.usecases;

import vu.lt.entities.Category;
import vu.lt.entities.Producer;
import vu.lt.entities.Movie;
import lombok.Getter;
import lombok.Setter;
import vu.lt.persistence.CategoriesDAO;
import vu.lt.persistence.ProducersDAO;
import vu.lt.persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class MoviesOfProducer implements Serializable {


    @Inject
    private ProducersDAO producersDAO;

    @Inject
    private MoviesDAO moviesDAO;
    @Inject
    private CategoriesDAO categoriesDAO;

    @Getter
    @Setter
    private Producer producer;

    @Getter
    @Setter
    private Movie movieToCreate = new Movie();
    @Getter
    @Setter
    private Category categoryToCreate = new Category();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer producerId = Integer.parseInt(requestParameters.get("producerId"));
        this.producer = producersDAO.findOne(producerId);
    }

    @Transactional
    public void createMovie(){
        movieToCreate.setProducer(this.producer);
        movieToCreate.getCategoryList().add(categoryToCreate);
        categoryToCreate.getMovieList().add(movieToCreate);
        moviesDAO.persist(movieToCreate);
        categoriesDAO.persist(categoryToCreate);
    }
}
