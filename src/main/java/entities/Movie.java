package entities;

import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select a from Movie as a")
})
@Table(name = "MOVIE")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 15)
    @Column(name = "NAME")
    private String name;


    public Movie(){

    }

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
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
