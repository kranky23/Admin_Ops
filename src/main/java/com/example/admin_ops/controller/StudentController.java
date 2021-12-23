package com.example.admin_ops.controller;


import com.example.admin_ops.bean.Student;
import com.example.admin_ops.service.StudentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("admin")
public class StudentController
{
    StudentService ss = new StudentService();
    @POST
    @Path("/view")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewDetails(Student s) throws URISyntaxException
    {
        List<Student> result = ss.viewDetails(s);
        if(result == null)
        {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDetails(Student s) throws URISyntaxException
    {
        boolean result = ss.updateDetails(s);
        if(result == false)
        {
            return Response.noContent().build();
        }

        return Response.ok().build();
    }
}
