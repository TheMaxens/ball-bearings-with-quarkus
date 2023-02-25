package org.dhbw.mosbach.ai.usecase.out;

import java.util.List;

import org.dhbw.mosbach.ai.domain.model.OArrangement;

public interface OArrangementDbQuery {
    OArrangement findOArrangementById(Long id);

    List<OArrangement> findAllOArrangement();
}
