package org.dhbw.mosbach.ai.domain.service;

import org.dhbw.mosbach.ai.domain.model.OArrangement;
import org.dhbw.mosbach.ai.usecase.in.OArrangementCommand;
import org.dhbw.mosbach.ai.usecase.out.OArrangementDbCommand;

public class OArrangementCommandService implements OArrangementCommand {

    private OArrangementDbCommand dbCommand;


    public OArrangementCommandService(OArrangementDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public OArrangement create(OArrangement oArrangement) {
        return dbCommand.saveOArrangement(oArrangement);
    }

    @Override
    public OArrangement update(Long id, OArrangement oArrangement) {
        return dbCommand.updateOArrangement(id, oArrangement);
    }

    @Override
    public boolean delete(Long id) {
        return dbCommand.deleteOArrangement(id);
    }
}