package entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select a from Movie as a")
})
@Table(name = "MOVIE")
@Getter
@Setter
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

    @Size(max = 4)
    @Column(name = "YEAR")
    private String year;


    @ManyToOne
    @JoinColumn(name = "PRODUCER_ID")
    private Producer producer;

    @JoinTable(name = "MOVIE_CATEGORY", joinColumns = {
            @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")})

    @ManyToMany
    @JohnzonIgnore
    private List<Category> categoryList = new ArrayList<>();


    public Movie() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
