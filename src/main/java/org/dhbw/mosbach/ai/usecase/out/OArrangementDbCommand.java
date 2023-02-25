package org.dhbw.mosbach.ai.usecase.out;

import org.dhbw.mosbach.ai.domain.model.OArrangement;

public interface OArrangementDbCommand {
    OArrangement saveOArrangement(OArrangement oArrangement);

    OArrangement updateOArrangement(Long id, OArrangement oArrangement);

    boolean deleteOArrangement(Long id);
}
