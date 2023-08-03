/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incomeBank.ws.rest.controller;

import com.incomeBank.entity.ReportEntity;
import com.incomeBank.service.ReportService;
import com.incomeBank.util.ResponseHelper;
import com.incomeBank.ws.rest.util.FilterWrapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.sql.SQLException;

@Path("/report")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ReportController {

    @Inject
    ReportService service;

    @GET
    @Path("/v1/search")
    public Response search(@QueryParam("filter") FilterWrapper filterWrapper,
                           @QueryParam("start") Integer start,
                           @QueryParam("limit") Integer limit,
                           @Context UriInfo ui,
                           @Context HttpServletRequest request,
                           @Context SecurityContext sc)
            throws WebApplicationException {

        return ResponseHelper.ok(service.getAll(filterWrapper, start, limit));
    }

    @POST
    @Path("/v1/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(@Valid @NotNull ReportEntity reportEntity) {
        return ResponseHelper.ok(service.create(reportEntity));
    }
}
