package org.dhbw.mosbach.ai.application.ports.output;

import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;

public interface OArrangementDbCommandOutputPort {
    CreateOArrangement saveOArrangement(CreateOArrangement createOArrangement);

    CreateOArrangement updateOArrangement(Id id, CreateOArrangement createOArrangement);

    boolean deleteOArrangement(Id id);
}
