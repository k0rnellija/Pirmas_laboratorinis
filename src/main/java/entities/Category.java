package entities;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "CATEGORY")


public class Category {
    public Category() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Movie> movies;

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public List<Movie> getMovies(){
        return movies;
    }

    public void setMovies (List<Movie> movies){
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }


}
