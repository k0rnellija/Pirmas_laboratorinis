package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@Alternative
public class MovieRatingGeneratorFaster implements Serializable, NumberGenerator{
    @Futureable
    public Future<Integer> generateRating() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }

        final Integer generatedMovieRating = new Random().nextInt(10);
        System.out.println("This number was generated much faster: " + generatedMovieRating);
        return new AsyncResult<>(generatedMovieRating);
    }
}
