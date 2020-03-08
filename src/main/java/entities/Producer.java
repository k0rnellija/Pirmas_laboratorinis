package entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@NamedQueries({
        @NamedQuery(name = "Producer.findAll", query = "select p from Producer as p")
})

@Table(name = "PRODUCER")
@Getter
@Setter

public class Producer {
    public Producer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
