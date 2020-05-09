package vu.lt.usecases;

import vu.lt.Interceptors.LoggedInvocation;
import vu.lt.services.MovieRatingGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named
@SessionScoped
public class GenerateMovieRating implements Serializable {

    @Inject
    MovieRatingGenerator movieRatingGenerator;

    private Future<Integer> movieRatingGeneratorTask = null;

    @LoggedInvocation
    public String generateNewMovieRating() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        movieRatingGeneratorTask = movieRatingGenerator.generateRating();
        return "/movieInfo.xhtml?faces-redirect=true&movieId=" + requestParameters.get("movieId");
    }

    public boolean isMovieRatingGeneratorRunning() {
        return movieRatingGeneratorTask != null && !movieRatingGeneratorTask.isDone();
    }

    public String getMovieRatingGeneratorStatus() throws ExecutionException, InterruptedException {
        if(movieRatingGeneratorTask == null){
            return null;
        } else if (isMovieRatingGeneratorRunning()) {
            return "Rating generation in progress";
        } else {
            return "Suggested movie rating: " + movieRatingGeneratorTask.get();
        }
    }
}
