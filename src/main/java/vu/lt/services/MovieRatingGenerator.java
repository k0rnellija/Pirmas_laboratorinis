package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class MovieRatingGenerator implements Serializable, NumberGenerator {

    @Futureable
    public Future<Integer> generateRating() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }

        final Integer generatedMovieRating = new Random().nextInt(10);
        System.out.println("some generated number is: " + generatedMovieRating);
        return new AsyncResult<>(generatedMovieRating);
    }
}
