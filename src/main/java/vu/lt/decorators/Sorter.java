package vu.lt.decorators;

import vu.lt.entities.Producer;

import java.util.List;

public interface Sorter {
    List<Producer> sort(List<Producer> allProducers);
}
