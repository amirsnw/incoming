/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incomeBank.ws.rest.financialDoc;

import com.incomeBank.service.financialDoc.FinancialDocService;
import com.incomeBank.util.ResponseHelper;
import com.incomeBank.ws.rest.util.FilterWrapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.sql.SQLException;

@Path("/financial-doc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class FinancialDocRestService {

    @Inject
    FinancialDocService service;

    @GET
    @Path("/get-all")
    // @RolesAllowed({Roles.MALI_SETAD_DRMD_USER, Roles.MALI_BRANCH_DRMD_USER})
    public Response getAll(@QueryParam("filter") FilterWrapper filterWrapper,
                           @QueryParam("start") Integer start,
                           @QueryParam("limit") Integer limit,
                           @Context UriInfo ui,
                           @Context HttpServletRequest request,
                           @Context SecurityContext sc)
            throws WebApplicationException, IOException, SQLException {

        return ResponseHelper.ok(service.getAll(filterWrapper, start, limit));
    }
}
