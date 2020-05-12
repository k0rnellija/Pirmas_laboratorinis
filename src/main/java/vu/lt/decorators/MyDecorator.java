package vu.lt.decorators;

import vu.lt.entities.Producer;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Decorator
public class MyDecorator implements Sorter{

    @Inject
    @Delegate
    @Any
    Sorter Sorter;

    @Override
    public List<Producer> sort(List<Producer> allProducers) {
        List<Producer> list = new ArrayList(allProducers);
        boolean sorted = false;
        Producer temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getName().compareToIgnoreCase(list.get(i+1).getName()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    sorted = false;
                }
            }
        }
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }

        return list;
    }

}
