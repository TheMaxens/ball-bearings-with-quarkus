package org.dhbw.mosbach.ai.application.usecases;

import org.dhbw.mosbach.ai.domain.vo.Id;
import org.dhbw.mosbach.ai.framework.adapters.input.rest.request.CreateOArrangement;

public interface OArrangementCommandUseCase {
    CreateOArrangement create(CreateOArrangement oArrangement);

    CreateOArrangement update(Id id, CreateOArrangement oArrangement);

    boolean delete(Id id);
}
