package mx.edu.utez.extramike.controller.cliente;

import mx.edu.utez.extramike.model.cliente.DaoCliente;
import mx.edu.utez.extramike.utils.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/cliente")
public class ServiceCliente {
    @GET
    @Path("/puntoUno/")
    @Produces(value = {"application/json"})

    //@Produces(MediaType.APPLICATION_JSON)
    public Response<List> puntoUno(){
        return new DaoCliente().puntoUno();
    }

    @GET
    @Path("/puntoDos/")
    //@Produces(value = {"application/json"})
    @Produces(MediaType.APPLICATION_JSON)

    public Response<List> puntoDos(){
        return new DaoCliente().puntoDos();
    }

    @GET
    @Path("/puntoTres/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<List> puntoTres(){
        return new DaoCliente().puntoTres();
    }

    @GET
    @Path("/puntoSiete/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<List> puntoSiete(){
        return new DaoCliente().puntoSiete();
    }



    @GET
    @Path("/puntoDiez/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<String> puntoDiez(){
        return new DaoCliente().puntoDiez();
    }


}
