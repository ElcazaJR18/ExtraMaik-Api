package mx.edu.utez.extramike.model.empleado;

import mx.edu.utez.extramike.model.Repository;
import mx.edu.utez.extramike.model.cliente.BeanCliente;
import mx.edu.utez.extramike.model.cliente.DaoCliente;
import mx.edu.utez.extramike.utils.MySQLConnection;
import mx.edu.utez.extramike.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DaoEmpleado  implements Repository<BeanEmpleado> {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection mysql = new MySQLConnection();



    private final String PUNTO_CUATRO = "SELECT *\n" +
                                        "FROM empleado\n" +
                                        "LEFT JOIN oficina ON empleado.codigo_oficina = oficina.codigo_oficina\n" +
                                        "WHERE oficina.codigo_oficina IS NULL;";

    private final String PUNTO_CINCO = "SELECT *\n" +
                                       "FROM empleado\n" +
                                       "LEFT JOIN cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas\n" +
                                       "WHERE cliente.codigo_empleado_rep_ventas IS NULL;";

    private final String PUNTO_SEIS = "SELECT COUNT(*) as cantidad_empleados\n" +
                                      "FROM empleado;";


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
        List<BeanEmpleado> empleadoList = new ArrayList<>();
        Response<List> response = new Response<>();
        BeanEmpleado empleado = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_CUATRO;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                empleado = new BeanEmpleado();

                empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido1(rs.getString("apellido1"));
                empleado.setApellido2(rs.getString("apellido2"));
                empleado.setExtension(rs.getString("extension"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCodigo_oficina(rs.getString("codigo_oficina"));
                empleado.setCodigo_jefe(rs.getInt("codigo_jefe"));
                empleado.setPuesto(rs.getString("puesto"));

                empleadoList.add(empleado);
                System.out.println(empleado.toString());


            }

            if (empleadoList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(empleadoList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoCuatro DaoEmpleado" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoCuatro DaoEmpleado");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }

    @Override
    public Response<List> puntoCinco() {
        List<BeanEmpleado> empleadoList = new ArrayList<>();
        Response<List> response = new Response<>();
        BeanEmpleado empleado = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_CINCO;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                empleado = new BeanEmpleado();

                empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido1(rs.getString("apellido1"));
                empleado.setApellido2(rs.getString("apellido2"));
                empleado.setExtension(rs.getString("extension"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCodigo_oficina(rs.getString("codigo_oficina"));
                empleado.setCodigo_jefe(rs.getInt("codigo_jefe"));
                empleado.setPuesto(rs.getString("puesto"));

                empleadoList.add(empleado);
                System.out.println(empleado.toString());


            }

            if (empleadoList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(empleadoList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoCinco DaoEmpleado" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoCinco DaoEmpleado");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }

    @Override
    public Response<Integer> puntoSeis() {

        Response<Integer> response = new Response<>();
        Integer total = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_SEIS;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {

                total = rs.getInt("cantidad_empleados");
                System.out.println(total);


            }

            if (total == null) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(total);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoSeis DaoEmpleado" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoSeis DaoEmpleado");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }

    @Override
    public Response<List> puntoSiete() {
        return null;
    }

    @Override
    public Response<Double> puntoOcho() {
        return null;
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
