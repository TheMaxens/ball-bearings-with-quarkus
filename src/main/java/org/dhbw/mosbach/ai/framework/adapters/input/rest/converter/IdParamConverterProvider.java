package org.dhbw.mosbach.ai.framework.adapters.input.rest.converter;

import javax.inject.Singleton;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.dhbw.mosbach.ai.domain.vo.Id;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Singleton
public class IdParamConverterProvider implements ParamConverterProvider {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType,
            Type genericType,
            Annotation[] annotations) {
        if (rawType.isAssignableFrom(Id.class)) {
            return (ParamConverter<T>) new IdParamConverter();
        }
        return null;
    }
}
