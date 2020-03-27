package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.mybatis.dao.ProducerMapper;
import vu.lt.mybatis.model.Producer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ProducersMyBatis {
    @Inject
    private ProducerMapper producerMapper;

    @Getter
    private List<Producer> allProducers;

    @Getter @Setter
    private Producer producerToCreate = new Producer();

    @PostConstruct
    public void init() {
        this.loadAllProducers();
    }

    private void loadAllProducers() {
        this.allProducers = producerMapper.selectAll();
    }

    @Transactional
    public String createProducer(){
        producerMapper.insert(producerToCreate);
        return "/myBatis/producers?faces-redirect=true";
    }
}
