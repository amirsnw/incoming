package com.incomeBank.util;

import com.incomeBank.util.annotation.MessageBundle;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Inject
    @MessageBundle
    Bundle messageBundle;

    @Override
    public Response toResponse(WebApplicationException exception) {
        String message = null;
        if (!"".equals(exception.getMessage())) {
            message = exception.getMessage();
        } else {
            message = messageBundle.getProperty("financialDoc.filterIsEmpty");
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .header("X-Internal-Server-Error", message)
                .entity(exception.getMessage())
                .build();
    }
}
