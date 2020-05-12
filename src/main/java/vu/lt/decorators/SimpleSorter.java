package vu.lt.decorators;

import vu.lt.entities.Producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleSorter implements Sorter{

    @Override
    public List<Producer> sort(List<Producer> allProducers) {

        return allProducers;
    }

}
