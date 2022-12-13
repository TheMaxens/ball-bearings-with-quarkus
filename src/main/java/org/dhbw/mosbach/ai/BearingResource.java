package org.dhbw.mosbach.ai;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bearing")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BearingResource {

    @GET
    public List<OArrangement> get() {
        return OArrangement.listAll();
    }

    @GET
    @Path("{id}")
    public OArrangement getSingle(Long id) {
        OArrangement entity = OArrangement.findById(id);
        return entity;
    }

    @POST
    @Transactional
    public Response create(OArrangement oArrangement) {
        oArrangement.persist();
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(Long id, OArrangement oArrangement) {
        OArrangement entity = OArrangement.findById(id);
        if (entity != null) {
            entity.delete();
            oArrangement.persist();
            return Response.status(204).build();
        } else {
            return Response.status(400).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(Long id) {
        OArrangement entity = OArrangement.findById(id);
        if (entity != null) {
            entity.delete();
            return Response.status(204).build();
        } else {
            return Response.status(400).build();
        }
    }
}
