package org.dhbw.mosbach.ai.usecase.in;

import java.util.List;

import org.dhbw.mosbach.ai.domain.model.OArrangement;

public interface OArrangementQuery {
    OArrangement getSingle(Long id);

    List<OArrangement> get();
}
