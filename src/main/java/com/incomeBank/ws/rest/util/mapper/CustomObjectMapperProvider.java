package com.incomeBank.ws.rest.util.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.ws.rs.ext.ContextResolver;

public class CustomObjectMapperProvider implements ContextResolver<ObjectMapper> {

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        final ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(String.class, new HtmlEncodingSerializer());
        mapper.registerModule(simpleModule);
        return mapper;
    }
}
