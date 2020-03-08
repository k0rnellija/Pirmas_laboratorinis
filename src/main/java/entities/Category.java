package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select c from Category as c"),
        @NamedQuery(name = "Category.findById", query = "select c from Category as c WHERE c.id = :id")
})

@Table(name = "CATEGORY")
@Getter
@Setter
public class Category {
    public Category() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

    @ManyToMany (mappedBy = "categoryList")
    private List<Movie> movieList = new ArrayList<>();
}
