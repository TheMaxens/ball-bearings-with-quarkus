package org.dhbw.mosbach.ai.application.ports.output;

import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;

public interface OArrangementDbCommandOutputPort {
    OArrangement saveOArrangement(OArrangement oArrangement);

    OArrangement updateOArrangement(Id id, OArrangement oArrangement);

    boolean deleteOArrangement(Id id);
}
