package org.dhbw.mosbach.ai.application.ports.input;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbCommandOutputPort;
import org.dhbw.mosbach.ai.application.usecases.OArrangementCommandUseCase;
import org.dhbw.mosbach.ai.domain.entity.Bearing;
import org.dhbw.mosbach.ai.domain.entity.Load;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;

@ApplicationScoped
public class OArrangementCommandInputPort implements OArrangementCommandUseCase {

    @Inject
    OArrangementDbCommandOutputPort dbCommand;

    @Override
    public OArrangement create(CreateOArrangement createOArrangement) {
        Bearing bearingA = new Bearing(null, createOArrangement.getBearingA().getCdyn(),
                createOArrangement.getBearingA().getY(), createOArrangement.getBearingA().getE(),
                createOArrangement.getBearingA().getXB1());
        Bearing bearingB = new Bearing(null, createOArrangement.getBearingB().getCdyn(),
                createOArrangement.getBearingB().getY(), createOArrangement.getBearingB().getE(),
                createOArrangement.getBearingB().getXB1());
        Load load = new Load(null, createOArrangement.getLoad().getFr(), createOArrangement.getLoad().getFa(),
                createOArrangement.getLoad().getN(), createOArrangement.getLoad().getXr(),
                createOArrangement.getLoad().getYa());
        OArrangement oArrangement = new OArrangement(null, bearingA, bearingB,
                createOArrangement.getXD1(), createOArrangement.getXD2(), load,
                createOArrangement.getA(), createOArrangement.getA(), createOArrangement.getA());
        return dbCommand.saveOArrangement(oArrangement);
    }

    @Override
    public OArrangement update(Id id, CreateOArrangement createOArrangement) {
        Bearing bearingA = new Bearing(null, createOArrangement.getBearingA().getCdyn(),
                createOArrangement.getBearingA().getY(), createOArrangement.getBearingA().getE(),
                createOArrangement.getBearingA().getXB1());
        Bearing bearingB = new Bearing(null, createOArrangement.getBearingB().getCdyn(),
                createOArrangement.getBearingB().getY(), createOArrangement.getBearingB().getE(),
                createOArrangement.getBearingB().getXB1());
        Load load = new Load(null, createOArrangement.getLoad().getFr(), createOArrangement.getLoad().getFa(),
                createOArrangement.getLoad().getN(), createOArrangement.getLoad().getXr(),
                createOArrangement.getLoad().getYa());
        OArrangement oArrangement = new OArrangement(null, bearingA, bearingB,
                createOArrangement.getXD1(), createOArrangement.getXD2(), load,
                createOArrangement.getA(), createOArrangement.getA(), createOArrangement.getA());
        return dbCommand.updateOArrangement(id, oArrangement);
    }

    @Override
    public boolean delete(Id id) {
        return dbCommand.deleteOArrangement(id);
    }
}