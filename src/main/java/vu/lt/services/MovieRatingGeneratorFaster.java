package vu.lt.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@Alternative
@Specializes
public class MovieRatingGeneratorFaster extends MovieRatingGenerator implements Serializable, NumberGenerator{
    @Futureable
    public Future<Integer> generateRating() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        final Integer generatedMovieRating = new Random().nextInt(10);
        System.out.println("This number was generated much faster: " + generatedMovieRating);
        return new AsyncResult<>(generatedMovieRating);
    }
}
