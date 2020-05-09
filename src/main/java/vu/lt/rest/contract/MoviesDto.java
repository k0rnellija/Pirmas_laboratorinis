package vu.lt.rest.contract;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MoviesDto {

    private String name;

    private String year;

    private String duration;

    private Integer rating;

    private String producerName;

    private List<String> categoryNames;

}
