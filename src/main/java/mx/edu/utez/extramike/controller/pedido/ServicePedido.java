package mx.edu.utez.extramike.controller.pedido;

import mx.edu.utez.extramike.model.pago.DaoPago;
import mx.edu.utez.extramike.model.pedido.DaoPedido;
import mx.edu.utez.extramike.utils.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/pedido")
public class ServicePedido {

    @GET
    @Path("/puntoNueve/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<List> puntoNueve(){
        return new DaoPedido().puntoNueve();
    }
}
