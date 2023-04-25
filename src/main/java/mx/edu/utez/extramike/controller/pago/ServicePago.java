package mx.edu.utez.extramike.controller.pago;

import mx.edu.utez.extramike.model.pago.DaoPago;
import mx.edu.utez.extramike.utils.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/pago")
public class ServicePago {

    @GET
    @Path("/puntoOcho/")
    @Produces(MediaType.APPLICATION_JSON)

    public Response<Double> puntoOcho(){
        return new DaoPago().puntoOcho();
    }

}
