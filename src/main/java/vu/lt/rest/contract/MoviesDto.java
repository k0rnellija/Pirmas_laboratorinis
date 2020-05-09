package vu.lt.rest.contract;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Category;

import java.util.List;

@Getter @Setter
public class MoviesDto {

    private String Name;

    private String Year;

    private String Duration;

    private Integer Rating;

    private String ProducerName;

    private List<Category> Categories;
}
