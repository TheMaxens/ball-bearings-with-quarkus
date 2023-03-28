package org.dhbw.mosbach.ai.application.usecases;

import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;

public interface OArrangementCommandUseCase {
    OArrangement create(CreateOArrangement oArrangement);

    OArrangement update(Id id, CreateOArrangement oArrangement);

    boolean delete(Id id);
}
