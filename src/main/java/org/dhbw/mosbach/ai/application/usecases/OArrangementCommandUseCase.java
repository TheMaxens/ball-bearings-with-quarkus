package org.dhbw.mosbach.ai.application.usecases;

import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;

public interface OArrangementCommandUseCase {
    OArrangement create(OArrangement oArrangement);

    OArrangement update(Id id, OArrangement oArrangement);

    boolean delete(Id id);
}
