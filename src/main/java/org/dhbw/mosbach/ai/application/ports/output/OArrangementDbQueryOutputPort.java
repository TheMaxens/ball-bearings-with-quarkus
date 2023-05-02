package org.dhbw.mosbach.ai.application.ports.output;

import java.util.List;

import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;

public interface OArrangementDbQueryOutputPort {
    OArrangement findOArrangementById(Id id);

    List<OArrangement> findAllOArrangement();
}
