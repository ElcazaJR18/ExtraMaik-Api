package mx.edu.utez.extramike.model.pago;

import mx.edu.utez.extramike.model.Repository;
import mx.edu.utez.extramike.model.empleado.DaoEmpleado;
import mx.edu.utez.extramike.utils.MySQLConnection;
import mx.edu.utez.extramike.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

public class DaoPago implements Repository {


    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection mysql = new MySQLConnection();


    private final String PUNTO_OCHO = "SELECT AVG(total) as pago_medio_2009\n" +
                                      "FROM pago\n" +
                                      "WHERE fecha_pago >= '2009-01-01' AND fecha_pago <= '2009-12-31';";


    @Override
    public Response<List> puntoUno() {
        return null;
    }

    @Override
    public Response<List> puntoDos() {
        return null;
    }

    @Override
    public Response<List> puntoTres() {
        return null;
    }

    @Override
    public Response<List> puntoCuatro() {
        return null;
    }

    @Override
    public Response<List> puntoCinco() {
        return null;
    }

    @Override
    public Response<Integer> puntoSeis() {
        return null;
    }

    @Override
    public Response<List> puntoSiete() {
        return null;
    }

    @Override
    public Response<Double> puntoOcho() {
        Response<Double> response = new Response<>();
        Double avg = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_OCHO;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {

                avg = rs.getDouble("pago_medio_2009");
                System.out.println(avg);


            }

            if (avg == null) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(avg);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoOcho DaoPago" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoOcho DaoPago");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }

    @Override
    public Response<List> puntoNueve() {
        return null;
    }

    @Override
    public Response<String> puntoDiez() {
        return null;
    }
}
