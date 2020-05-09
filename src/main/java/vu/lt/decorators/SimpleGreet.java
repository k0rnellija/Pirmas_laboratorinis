package vu.lt.decorators;

public class SimpleGreet implements Greeting{

    @Override
    public String greet(String name) {

        return "New producer's name: " + name;
    }
}
