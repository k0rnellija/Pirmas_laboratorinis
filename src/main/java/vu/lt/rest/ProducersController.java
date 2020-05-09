package vu.lt.rest;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Producer;
import vu.lt.persistence.ProducersDAO;
import vu.lt.rest.contract.ProducersDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/producers")
public class ProducersController {

    @Inject
    @Getter
    @Setter
    ProducersDAO producersDAO= new ProducersDAO();

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Producer producer = producersDAO.findOne(id);
        if (producer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ProducersDto producersDto = new ProducersDto();
        producersDto.setName(producer.getName());

        return Response.ok(producersDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer producerId, ProducersDto data) {
        try {
            Producer existingProducer = producersDAO.findOne(producerId);
            if (existingProducer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingProducer.setName(data.getName());
            producersDAO.updateAndFlush(existingProducer);
            return Response.ok().build();
        } catch (OptimisticLockException o) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(final ProducersDto data) {

        Producer producerToCreate = new Producer();
        producerToCreate.setName(data.getName());
        this.producersDAO.persist(producerToCreate);

        return Response.ok().build();
    }

}
