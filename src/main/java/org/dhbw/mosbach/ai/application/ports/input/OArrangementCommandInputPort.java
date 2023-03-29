package org.dhbw.mosbach.ai.application.ports.input;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbCommandOutputPort;
import org.dhbw.mosbach.ai.application.usecases.OArrangementCommandUseCase;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;

@ApplicationScoped
public class OArrangementCommandInputPort implements OArrangementCommandUseCase {

    @Inject
    OArrangementDbCommandOutputPort dbCommand;

    @Override
    public CreateOArrangement create(CreateOArrangement createOArrangement) {
        return dbCommand.saveOArrangement(createOArrangement);
    }

    @Override
    public CreateOArrangement update(Id id, CreateOArrangement createOArrangement) {
        return dbCommand.updateOArrangement(id, createOArrangement);
    }

    @Override
    public boolean delete(Id id) {
        return dbCommand.deleteOArrangement(id);
    }
}