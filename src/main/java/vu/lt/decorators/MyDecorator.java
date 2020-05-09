package vu.lt.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class MyDecorator implements Greeting{

    @Inject
    @Delegate
    @Any
    Greeting greeting;

    @Override
    public String greet(String name) {
        return greeting.greet(name + ". Good job.");
    }

}
