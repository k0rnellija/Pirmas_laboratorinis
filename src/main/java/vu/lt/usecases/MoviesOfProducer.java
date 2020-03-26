package vu.lt.usecases;

import vu.lt.entities.Producer;
import vu.lt.entities.Movie;
import lombok.Getter;
import lombok.Setter;
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

    @Getter
    @Setter
    private Producer producer;

    @Getter
    @Setter
    private Movie movieToCreate = new Movie();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer producerId = Integer.parseInt(requestParameters.get("producerId"));
        this.producer = producersDAO.findOne(producerId);
    }

    @Transactional
    public String createMovie(){
        movieToCreate.setProducer(this.producer);
        moviesDAO.persist(movieToCreate);
        return "/movies.xhtml?faces-redirect=true&producerId=" + this.producer.getId();
    }
}
