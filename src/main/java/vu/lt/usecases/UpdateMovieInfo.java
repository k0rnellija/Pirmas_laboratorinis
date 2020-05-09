package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Movie;
import vu.lt.persistence.MoviesDAO;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
    private Movie selectedMovie;
    private Movie conflictingMovie = null;

    @Inject
    private MoviesDAO moviesDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateMovieInfo INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer movieId = Integer.parseInt(requestParameters.get("movieId"));
        this.selectedMovie = moviesDAO.findOne(movieId);
    }

    @Transactional
    public String updateMovie() {
        try {
            missMatchCheck();
            moviesDAO.updateAndFlush(this.selectedMovie);
        } catch (OptimisticLockException e) {
            return "movieInfo.xhtml?faces-redirect=true&movieId=" + this.selectedMovie.getId() + "&error=optimistic-lock-exception";
        }
        return "movies.xhtml?producerId=" + this.selectedMovie.getProducer().getId()+ "&faces-redirect=true";
    }

    @Transactional
    public void missMatchCheck() throws OptimisticLockException {
        conflictingMovie = moviesDAO.findOne(this.selectedMovie.getId());

        if(this.selectedMovie.getVersion() != conflictingMovie.getVersion()){
            throw new OptimisticLockException();
        }
    }
}
