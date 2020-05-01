package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Movie;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateMovieInfo implements Serializable {
    private Movie movie;

    @Inject
    private MoviesDAO moviesDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateMovieInfo INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer movieId = Integer.parseInt(requestParameters.get("movieId"));
        this.movie = moviesDAO.findOne(movieId);
    }

    @Transactional
    @LoggedInvocation
    public String updateMovieRating() {
        try {
            moviesDAO.updateAndFlush(this.movie);
        } catch (OptimisticLockException e) {
            System.out.println("exception occured: " + e);
        }
        return "movies.xhtml?producerId=" + this.movie.getProducer().getId()+ "&faces-redirect=true";
    }
}
