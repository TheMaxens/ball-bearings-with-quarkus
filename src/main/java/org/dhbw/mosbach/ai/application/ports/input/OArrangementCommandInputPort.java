package org.dhbw.mosbach.ai.application.ports.input;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbCommandOutputPort;
import org.dhbw.mosbach.ai.application.usecases.OArrangementCommandUseCase;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;

@ApplicationScoped
public class OArrangementCommandInputPort implements OArrangementCommandUseCase {

    @Inject
    private OArrangementDbCommandOutputPort dbCommand;

    @Override
    public OArrangement create(OArrangement oArrangement) {
        return dbCommand.saveOArrangement(oArrangement);
    }

    @Override
    public OArrangement update(Id id, OArrangement oArrangement) {
        return dbCommand.updateOArrangement(id, oArrangement);
    }

    @Override
    public boolean delete(Id id) {
        return dbCommand.deleteOArrangement(id);
    }
}