package org.dhbw.mosbach.ai.adapter.in;

import org.dhbw.mosbach.ai.adapter.in.resource.BearingResource;
import org.dhbw.mosbach.ai.adapter.in.resource.LoadResource;
import org.dhbw.mosbach.ai.adapter.in.resource.OArrangementResource;
import org.dhbw.mosbach.ai.domain.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OArrangToOArrangResourceMapper {

    @Mapping(source = "bearingA", target = "bearingA")
    @Mapping(source = "bearingB", target = "bearingB")
    @Mapping(source = "xD1", target = "xD1")
    @Mapping(source = "xD2", target = "xD2")
    @Mapping(source = "load", target = "load")
    @Mapping(source = "a", target = "a")
    @Mapping(source = "b", target = "b")
    @Mapping(source = "c", target = "c")
    @Mapping(source = "lh10", target = "lh10")
    OArrangement mapOArrangementResourceToOArrangement(OArrangementResource resource);

    @Mapping(source = "cdyn", target = "cdyn")
    @Mapping(source = "y", target = "y")
    @Mapping(source = "e", target = "e")
    @Mapping(source = "xB1", target = "xB1")
    @Mapping(source = "p", target = "p")
    @Mapping(source = "fr", target = "fr")
    @Mapping(source = "fa", target = "fa")
    @Mapping(source = "lh10", target = "lh10")
    Bearing mapBearingResourceToBearing(BearingResource resource);

    @Mapping(source = "fr", target = "fr")
    @Mapping(source = "fa", target = "fa")
    @Mapping(source = "n", target = "n")
    @Mapping(source = "xr", target = "xr")
    @Mapping(source = "ya", target = "ya")
    Load mapLoadResourceToLoad(LoadResource resource);

    @Mapping(source = "bearingA", target = "bearingA")
    @Mapping(source = "bearingB", target = "bearingB")
    @Mapping(source = "xD1", target = "xD1")
    @Mapping(source = "xD2", target = "xD2")
    @Mapping(source = "load", target = "load")
    @Mapping(source = "a", target = "a")
    @Mapping(source = "b", target = "b")
    @Mapping(source = "c", target = "c")
    @Mapping(source = "lh10", target = "lh10")
    OArrangementResource mapOArrangementToOArrangementResource(OArrangement entity);

    @Mapping(source = "cdyn", target = "cdyn")
    @Mapping(source = "y", target = "y")
    @Mapping(source = "e", target = "e")
    @Mapping(source = "xB1", target = "xB1")
    @Mapping(source = "p", target = "p")
    @Mapping(source = "fr", target = "fr")
    @Mapping(source = "fa", target = "fa")
    @Mapping(source = "lh10", target = "lh10")
    BearingResource mapBearingToBearingResource(Bearing equipment);

    @Mapping(source = "fr", target = "fr")
    @Mapping(source = "fa", target = "fa")
    @Mapping(source = "n", target = "n")
    @Mapping(source = "xr", target = "xr")
    @Mapping(source = "ya", target = "ya")
    LoadResource mapLoadToLoadResource(Load equipment);
}