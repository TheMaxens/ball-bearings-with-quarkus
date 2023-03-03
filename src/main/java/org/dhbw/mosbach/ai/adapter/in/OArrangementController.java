package org.dhbw.mosbach.ai.adapter.in;

import org.dhbw.mosbach.ai.adapter.in.resource.OArrangementResource;
import org.dhbw.mosbach.ai.domain.model.OArrangement;
import org.dhbw.mosbach.ai.usecase.in.OArrangementCommand;
import org.dhbw.mosbach.ai.usecase.in.OArrangementQuery;
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
public class OArrangementController {

    private OArrangementQuery oArrangementQuery;
    private OArrangToOArrangResourceMapper mapper;
    private OArrangementCommand oArrangementCommand;

    public OArrangementController(OArrangementQuery oArrangementQuery, OArrangToOArrangResourceMapper mapper,
            OArrangementCommand oArrangementCommand) {
        this.oArrangementQuery = oArrangementQuery;
        this.mapper = mapper;
        this.oArrangementCommand = oArrangementCommand;
    }

    @GET
    @Path("{id}")
    public OArrangementResource getSingle(Long id) {
        return mapper.mapOArrangementToOArrangementResource(oArrangementQuery.getSingle(id));
    }

    // public OArrangementResource get() {
    // return mapper.mapOArrangementToOArrangementResource(oArrangementQuery.get());
    // }

    @PUT
    @Path("{id}")
    public OArrangementResource update(Long id, OArrangementResource resource) {
        OArrangement oArrangement = mapper.mapOArrangementResourceToOArrangement(resource);
        OArrangement updatedOArrangement = oArrangementCommand.update(id, oArrangement);
        return mapper.mapOArrangementToOArrangementResource(updatedOArrangement);
    }

    @POST
    public OArrangementResource create(OArrangementResource resource) {
        OArrangement createdOArrangement = oArrangementCommand
                .create(mapper.mapOArrangementResourceToOArrangement(resource));
        return mapper.mapOArrangementToOArrangementResource(createdOArrangement);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(Long id) {
        return oArrangementCommand.delete(id);
    }

}
