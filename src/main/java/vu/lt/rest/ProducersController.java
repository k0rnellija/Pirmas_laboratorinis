package vu.lt.rest;

import vu.lt.entities.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/producers")
@Produces(MediaType.APPLICATION_JSON)
public class ProducersController {
    @Inject private EntityManager em;

    @GET
    @Path("/{producerId}")
    public Producer find(@PathParam("producerId") Integer producerId) {return em.find(Producer.class, producerId);}
}
