package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select a from Movie as a")
})
@Table(name = "MOVIE")
@Getter @Setter
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 15)
    @Column(name = "NAME")
    private String name;

    @Size(max = 15)
    @Column(name = "YEAR")
    private String year;


    @ManyToOne
    @JoinColumn(name="PRODUCER_ID")
    private Producer producer;

    public Movie(){

    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }
}
