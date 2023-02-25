package org.dhbw.mosbach.ai.usecase.in;

import org.dhbw.mosbach.ai.domain.model.OArrangement;

public interface OArrangementCommand {
    OArrangement create(OArrangement oArrangement);

    OArrangement update(Long id, OArrangement oArrangement);

    boolean delete(Long id);
}
