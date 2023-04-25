package mx.edu.utez.extramike.controller.empleado;


import mx.edu.utez.extramike.model.empleado.DaoEmpleado;
import mx.edu.utez.extramike.utils.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/empleado")
public class ServiceEmpleado {

    @GET
    @Path("/puntoCuatro/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<List> puntoCuatro(){
        return new DaoEmpleado().puntoCuatro();
    }

    @GET
    @Path("/puntoCinco/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<List> puntoCinco(){
        return new DaoEmpleado().puntoCinco();
    }


    @GET
    @Path("/puntoSeis/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<Integer> puntoSeis(){
        return new DaoEmpleado().puntoSeis();
    }

}
