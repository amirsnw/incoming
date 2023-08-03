package com.incomeBank.ws.rest.util.mapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.owasp.encoder.Encode;

import java.io.IOException;

public class HtmlEncodingSerializer extends StdSerializer<String> {

    protected HtmlEncodingSerializer(Class<String> t) {
        super(t);
    }

    public HtmlEncodingSerializer() {
        this(null);
    }

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(Encode.forHtmlContent(s));
    }
}
