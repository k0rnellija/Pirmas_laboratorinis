package vu.lt.services;

import java.util.concurrent.Future;

public interface NumberGenerator {
    public Future<Integer> generateRating();
}
