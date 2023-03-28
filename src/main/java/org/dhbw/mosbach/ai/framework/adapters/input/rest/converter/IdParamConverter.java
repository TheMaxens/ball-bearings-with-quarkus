package org.dhbw.mosbach.ai.framework.adapters.input.rest.converter;

import javax.ws.rs.ext.ParamConverter;

import org.dhbw.mosbach.ai.domain.vo.Id;

public class IdParamConverter implements ParamConverter<Id> {

    @Override
    public Id fromString(String value) {
        return Id.withId(value);
    }

    @Override
    public String toString(Id id) {
        return id.getUuid().toString();
    }
}
