package com.incomeBank.ws.rest.util.feature;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;
import org.glassfish.jersey.jackson.internal.FilteringJacksonJaxbJsonProvider;
import org.glassfish.jersey.jackson.internal.JacksonFilteringFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

public class JacksonFeature implements Feature {
    private static final String JSON_FEATURE = org.glassfish.jersey.jackson.JacksonFeature.class.getSimpleName();

    public JacksonFeature() {
    }

    public boolean configure(FeatureContext context) {
        Configuration config = context.getConfiguration();
        String jsonFeature = CommonProperties.getValue(config.getProperties(),
                config.getRuntimeType(),
                "jersey.config.jsonFeature",
                JSON_FEATURE,
                String.class);
        if (!JSON_FEATURE.equalsIgnoreCase(jsonFeature)) {
            return false;
        } else {
            context.property(PropertiesHelper
                    .getPropertyNameForRuntime("jersey.config.jsonFeature",
                            config.getRuntimeType()), JSON_FEATURE);
            if (!config.isRegistered(JacksonJaxbJsonProvider.class)) {
                /*context.register(JsonParseExceptionMapper.class);
                context.register(JsonMappingExceptionMapper.class);*/
                if (EntityFilteringFeature.enabled(config)) {
                    context.register(JacksonFilteringFeature.class);
                    context.register(FilteringJacksonJaxbJsonProvider.class,
                            new Class[]{MessageBodyReader.class, MessageBodyWriter.class});
                } else {
                    context.register(JacksonJaxbJsonProvider.class,
                            new Class[]{MessageBodyReader.class, MessageBodyWriter.class});
                }
            }
            return true;
        }
    }
}
