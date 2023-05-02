package org.dhbw.mosbach.ai.application.usecases;

import java.util.List;

import org.dhbw.mosbach.ai.domain.entity.OArrangement;
import org.dhbw.mosbach.ai.domain.vo.Id;

public interface OArrangementQueryUseCase {
    OArrangement getSingle(Id id);

    List<OArrangement> get();
}
