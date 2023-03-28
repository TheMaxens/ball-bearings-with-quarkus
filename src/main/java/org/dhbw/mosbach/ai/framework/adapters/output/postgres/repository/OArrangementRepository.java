package org.dhbw.mosbach.ai.framework.adapters.output.postgres.repository;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import org.dhbw.mosbach.ai.framework.adapters.output.postgres.data.OArrangementData;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class OArrangementRepository implements PanacheRepositoryBase<OArrangementData, UUID>{
    
}
