package org.dhbw.mosbach.ai.application.ports.input;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbQueryOutputPort;
import org.dhbw.mosbach.ai.application.usecases.OArrangementQueryUseCase;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;

@ApplicationScoped
public class OArrangementQueryInputPort implements OArrangementQueryUseCase {

    @Inject
    OArrangementDbQueryOutputPort dbQuery;

    @Override
    public OArrangement getSingle(Id id) {
        return dbQuery.findOArrangementById(id);
    }

    @Override
    public List<OArrangement> get() {
        return dbQuery.findAllOArrangement();
    }
}
