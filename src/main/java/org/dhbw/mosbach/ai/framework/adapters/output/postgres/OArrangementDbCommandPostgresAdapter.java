package org.dhbw.mosbach.ai.framework.adapters.output.postgres;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbCommandOutputPort;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.mapper.OArrangementMapper;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.repository.OArrangementRepository;

@ApplicationScoped
public class OArrangementDbCommandPostgresAdapter implements OArrangementDbCommandOutputPort {

    @Inject
    OArrangementRepository oArrangementRepository;

    @Override
    public OArrangement saveOArrangement(OArrangement oArrangement) {
        var OArrangementData = OArrangementMapper.oArrangementDomainToData(oArrangement);
        oArrangementRepository.persist(OArrangementData);
        return oArrangement;
    }

    @Override
    public OArrangement updateOArrangement(Id id, OArrangement oArrangement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOArrangement'");
    }

    @Override
    public boolean deleteOArrangement(Id id) {
        return oArrangementRepository.deleteById(id.getUuid());
    }
}
