package org.dhbw.mosbach.ai.framework.adapters.input.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
    OArrangementQueryUseCase oArrangementQuery;
    @Inject
    OArrangementCommandUseCase oArrangementCommand;

    @Transactional
    @GET
    @Path("/{id}")
    public OArrangement getSingle(@PathParam("id") String id) {
        return oArrangementQuery.getSingle(Id.withId(id));
    }

    @Transactional
    @GET
    public List<OArrangement> get() {
        return oArrangementQuery.get();
    }

    @Transactional
    @PUT
    @Path("/{id}")
    public CreateOArrangement update(@PathParam("id") String id, @Valid CreateOArrangement resource) {
        return oArrangementCommand.update(Id.withId(id), resource);
    }

    @Transactional
    @POST
    public CreateOArrangement create(@Valid CreateOArrangement resource) {
        return oArrangementCommand.create(resource);
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public boolean delete(@PathParam("id") String id) {
        return oArrangementCommand.delete(Id.withId(id));
    }
}
