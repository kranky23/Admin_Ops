package com.example.admin_ops.controller;


import com.example.admin_ops.bean.Employee;
import com.example.admin_ops.service.EmployeeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("admin")
public class EmployeeController
{
    EmployeeService es = new EmployeeService();
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAdmin(Employee e) throws URISyntaxException
    {
        Employee result = es.userIDVerify(e);

        if(result == null)
        {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
}
