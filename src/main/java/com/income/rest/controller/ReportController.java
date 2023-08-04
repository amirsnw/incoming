/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.income.rest.controller;

import com.income.dto.FilterWrapper;
import com.income.entity.ReportEntity;
import com.income.rest.util.ResponseHelper;
import com.income.service.ReportService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

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
    public Response createCar(@Valid @NotNull ReportEntity reportEntity) throws WebApplicationException {
        return ResponseHelper.ok(service.create(reportEntity));
    }
}
