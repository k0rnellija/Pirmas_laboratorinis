package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = "Producer.findAll", query = "select p from Producer as p"),
        @NamedQuery(name = "Producer.findById", query = "select p from Producer as p where p.id = :id"),
        @NamedQuery(name = "Producer.findByName", query = "select p from Producer as p where p.name = :name")
})

@Table(name = "PRODUCER")
@Getter
@Setter
@ToString(of = {"id", "name"})
public class Producer {
    public Producer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
    private List<Movie> movies = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(name, producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
