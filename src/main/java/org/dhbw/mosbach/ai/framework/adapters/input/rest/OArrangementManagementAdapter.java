package org.dhbw.mosbach.ai.framework.adapters.input.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dhbw.mosbach.ai.application.usecases.OArrangementCommandUseCase;
import org.dhbw.mosbach.ai.application.usecases.OArrangementQueryUseCase;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;

@Path("/bearing")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OArrangementManagementAdapter {

    @Inject
    private OArrangementQueryUseCase oArrangementQuery;
    @Inject
    private OArrangementCommandUseCase oArrangementCommand;

    @Transactional
    @GET
    @Path("/{id}")
    public OArrangement getSingle(@PathParam("id") Id id) {
        return oArrangementQuery.getSingle(id);
    }

    // public OArrangementResource get() {
    // return mapper.mapOArrangementToOArrangementResource(oArrangementQuery.get());
    // }

    @Transactional
    @PUT
    @Path("/{id}")
    public OArrangement update(@PathParam("id") Id id, CreateOArrangement resource) {
        return oArrangementCommand.update(id, resource);
    }

    @Transactional
    @POST
    public OArrangement create(CreateOArrangement resource) {
        return oArrangementCommand.create(resource);
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public boolean delete(@PathParam("id") Id id) {
        return oArrangementCommand.delete(id);
    }
}
