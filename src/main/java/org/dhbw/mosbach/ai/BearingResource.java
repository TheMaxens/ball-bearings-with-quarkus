package org.dhbw.mosbach.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/bearing")
public class BearingResource {

    private List<OArrangement> oArrangements = Collections.synchronizedList(new ArrayList<>());

    public BearingResource() {
    }

    @GET
    public List<OArrangement> listAllArrangements() {
        return oArrangements;
    }

    @GET
    @Path("/{id}")
    public OArrangement listSingleArrangement(@PathParam("id") UUID id) {
        for (OArrangement e : oArrangements) {
            if (e.getUid().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @POST
    public List<OArrangement> add(OArrangement oArrangement) {
        oArrangement.setUid(UUID.randomUUID());
        oArrangements.add(oArrangement);
        return oArrangements;
    }

    @DELETE
    @Path("/{id}")
    public List<OArrangement> delete(@PathParam("id") UUID id) {
        oArrangements.removeIf(e -> e.getUid().equals(id));
        return oArrangements;
    }

    @POST
    @Path("/{id}")
    public List<OArrangement> update(@PathParam("id") UUID id, OArrangement oArrangement) {
        delete(id);
        oArrangement.setUid(id);
        oArrangements.add(oArrangement);
        return oArrangements;
    }
}
