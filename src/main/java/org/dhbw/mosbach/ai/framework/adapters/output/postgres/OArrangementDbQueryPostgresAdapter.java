package org.dhbw.mosbach.ai.framework.adapters.output.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dhbw.mosbach.ai.application.ports.output.OArrangementDbQueryOutputPort;
import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.OArrangementData;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.mapper.OArrangementMapper;
import org.dhbw.mosbach.ai.framework.adapters.output.postgres.repository.OArrangementRepository;

@ApplicationScoped
public class OArrangementDbQueryPostgresAdapter implements OArrangementDbQueryOutputPort {

    @Inject
    OArrangementRepository oArrangementRepository;

    @Override
    public OArrangement findOArrangementById(Id id) {
        OArrangementData oArrangementData = oArrangementRepository.findById(id.getUuid());
        return OArrangementMapper.oArrangementDataToDomain(oArrangementData);
    }

    @Override
    public List<OArrangement> findAllOArrangement() {
        List<OArrangementData> oArrangementDatas = oArrangementRepository.listAll();
        List<OArrangement> oArrangements = new ArrayList<>(); 
        for (OArrangementData element : oArrangementDatas) {
            oArrangements.add(OArrangementMapper.oArrangementDataToDomain(element));
        }
        return oArrangements;
    }

}
