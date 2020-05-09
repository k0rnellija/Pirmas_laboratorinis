package vu.lt.rest;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Movie;
import vu.lt.persistence.CategoriesDAO;
import vu.lt.persistence.MoviesDAO;
import vu.lt.rest.contract.MoviesDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/movies")
public class MoviesController {

    @Inject
    @Getter
    @Setter
    private MoviesDAO moviesDAO;

    private List<String> temp;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Movie movie = moviesDAO.findOne(id);
        if (movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        MoviesDto moviesDto = new MoviesDto();
        moviesDto.setName(movie.getName());
        moviesDto.setYear(movie.getYear());
        moviesDto.setDuration(movie.getDuration());
        moviesDto.setRating(movie.getRating());
        moviesDto.setProducerName(movie.getProducer().getName());

        temp = new ArrayList<>();
        for (int i = 0; i < movie.getCategoryList().size(); i++) {
            temp.add(movie.getCategoryList().get(i).getName());
        }
        moviesDto.setCategoryNames(temp);

        return Response.ok(moviesDto).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer movieId, MoviesDto movieData) {
        try {
            Movie existingMovie = moviesDAO.findOne(movieId);
            if (existingMovie == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingMovie.setName(movieData.getName());
            existingMovie.setYear(movieData.getYear());
            existingMovie.setDuration(movieData.getDuration());
            existingMovie.setRating(movieData.getRating());
            moviesDAO.updateAndFlush(existingMovie);
            return Response.ok().build();
        } catch (OptimisticLockException o) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
