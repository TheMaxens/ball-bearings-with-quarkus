package org.dhbw.mosbach.ai.domain.service;

import java.util.List;

import org.dhbw.mosbach.ai.domain.model.OArrangement;
import org.dhbw.mosbach.ai.usecase.in.OArrangementQuery;
import org.dhbw.mosbach.ai.usecase.out.OArrangementDbQuery;

public class OArrangementQueryService implements OArrangementQuery {

    private OArrangementDbQuery dbQuery;

    public OArrangementQueryService(OArrangementDbQuery dbQuery) {
        this.dbQuery = dbQuery;
    }

    @Override
    public OArrangement getSingle(Long id) {
        return dbQuery.findOArrangementById(id);
    }

    @Override
    public List<OArrangement> get() {
        return dbQuery.findAllOArrangement();
    }
}
