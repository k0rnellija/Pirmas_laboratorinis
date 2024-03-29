package vu.lt.usecases;

import vu.lt.decorators.Sorter;
import vu.lt.entities.Producer;
import lombok.Getter;
import lombok.Setter;
import vu.lt.persistence.ProducersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Producers {

    @Inject
    private ProducersDAO producersDAO;

    @Inject
    private Sorter sorter;

    @Getter @Setter
    private Producer producerToCreate = new Producer();

    @Getter
    private List<Producer> allProducers;

    @PostConstruct
    public void init(){
        loadAllProducers();
    }

    @Transactional
    public String createProducer(){
        this.producersDAO.persist(producerToCreate);
        /*String msg = greeting.greet(producerToCreate.getName());
        System.out.println(msg);*/
        return "use-case-dao?faces-redirect=true";
    }

    private void loadAllProducers(){
        this.allProducers = producersDAO.loadAll();
        this.allProducers = sorter.sort(this.allProducers);
    }
}
