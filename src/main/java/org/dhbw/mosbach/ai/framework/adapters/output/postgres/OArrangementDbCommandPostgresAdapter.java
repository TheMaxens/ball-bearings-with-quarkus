package org.dhbw.mosbach.ai.framework.adapters.output.postgres;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbCommandOutputPort;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.OArrangementData;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.mapper.OArrangementMapper;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.repository.OArrangementRepository;

@ApplicationScoped
public class OArrangementDbCommandPostgresAdapter implements OArrangementDbCommandOutputPort {

    @Inject
    OArrangementRepository oArrangementRepository;

    @Override
    public CreateOArrangement saveOArrangement(CreateOArrangement createOArrangement) {
        OArrangementData oArrangementData = OArrangementMapper.createOArrangementToData(createOArrangement);
        oArrangementRepository.persist(oArrangementData);
        return createOArrangement;
    }

    @Override
    public CreateOArrangement updateOArrangement(Id id, CreateOArrangement createOArrangement) {
        OArrangementData oArrangementDataToDelete = oArrangementRepository.findById(id.getUuid());
        if (oArrangementDataToDelete != null) {
            oArrangementRepository.delete(oArrangementDataToDelete);
            OArrangementData oArrangementDataToCreate = OArrangementMapper.createOArrangementToData(createOArrangement);
            oArrangementRepository.persist(oArrangementDataToCreate);
            return createOArrangement;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteOArrangement(Id id) {
        return oArrangementRepository.deleteById(id.getUuid());
    }
}
