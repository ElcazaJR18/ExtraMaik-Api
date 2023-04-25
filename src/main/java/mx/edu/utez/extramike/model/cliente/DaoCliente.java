package mx.edu.utez.extramike.model.cliente;

import mx.edu.utez.extramike.model.Repository;
import mx.edu.utez.extramike.model.empleado.DaoEmpleado;
import mx.edu.utez.extramike.utils.MySQLConnection;
import mx.edu.utez.extramike.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DaoCliente implements Repository<BeanCliente> {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection mysql = new MySQLConnection();


    private final String PUNTO_UNO = "SELECT * \n" +
                                     "FROM cliente\n" +
                                     "WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)";

    private final String PUNTO_DOS = "SELECT *\n" +
                                     "FROM cliente\n" +
                                     "WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido)";

    private final String PUNTO_TRES = "SELECT *\n" +
                                      "FROM cliente\n" +
                                      "WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pago)\n" +
                                      "UNION\n" +
                                      "SELECT *\n" +
                                      "FROM cliente\n" +
                                      "WHERE codigo_cliente NOT IN (SELECT codigo_cliente FROM pedido);";


    private final String PUNTO_SIETE ="SELECT pais, COUNT(*) as cantidad_clientes\n" +
                                      "FROM cliente\n" +
                                      "GROUP BY pais;";

    private final String PUNTO_DIEZ = "SELECT nombre_cliente\n" +
                                      "FROM cliente\n" +
                                      "WHERE limite_credito = (\n" +
                                      "  SELECT MAX(limite_credito)\n" +
                                      "  FROM cliente\n" +
                                      ");";




    @Override
    public Response<List> puntoUno() {
        List<BeanCliente> clienteList = new ArrayList<>();
        Response<List> response = new Response<>();
        BeanCliente cliente = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_UNO;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new BeanCliente();
                cliente.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setNombre_contacto(rs.getString("nombre_contacto"));
                cliente.setApellido_contacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLinea_direccion1(rs.getString("linea_direccion1"));
                cliente.setLinea_direccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigo_postal(rs.getString("codigo_postal"));
                cliente.setCodigo_empleado_rep_ventas(rs.getInt("codigo_empleado_rep_ventas"));
                cliente.setLimite_credito(rs.getDouble("limite_credito"));

                clienteList.add(cliente);
                System.out.println(cliente.toString());
            }

            if (clienteList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(clienteList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoUno DaoCliente" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoUno DaoCliente");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }


    @Override
    public Response<List> puntoDos() {
        List<BeanCliente> clienteList = new ArrayList<>();
        Response<List> response = new Response<>();
        BeanCliente cliente = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_DOS;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new BeanCliente();
                cliente.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setNombre_contacto(rs.getString("nombre_contacto"));
                cliente.setApellido_contacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLinea_direccion1(rs.getString("linea_direccion1"));
                cliente.setLinea_direccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigo_postal(rs.getString("codigo_postal"));
                cliente.setCodigo_empleado_rep_ventas(rs.getInt("codigo_empleado_rep_ventas"));
                cliente.setLimite_credito(rs.getDouble("limite_credito"));

                clienteList.add(cliente);
                System.out.println(cliente.toString());
            }

            if (clienteList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(clienteList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoDos DaoCliente" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoDos DaoCliente");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }


    @Override
    public Response<List> puntoTres() {
        List<BeanCliente> clienteList = new ArrayList<>();
        Response<List> response = new Response<>();
        BeanCliente cliente = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_TRES;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new BeanCliente();
                cliente.setCodigo_cliente(rs.getInt("codigo_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setNombre_contacto(rs.getString("nombre_contacto"));
                cliente.setApellido_contacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLinea_direccion1(rs.getString("linea_direccion1"));
                cliente.setLinea_direccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigo_postal(rs.getString("codigo_postal"));
                cliente.setCodigo_empleado_rep_ventas(rs.getInt("codigo_empleado_rep_ventas"));
                cliente.setLimite_credito(rs.getDouble("limite_credito"));

                clienteList.add(cliente);
                System.out.println(cliente.toString());
            }

            if (clienteList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(clienteList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoTres DaoCliente" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoTres DaoCliente");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
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
        List<ClientePaisCount> clienteList = new ArrayList<>();
        Response<List> response = new Response<>();
        ClientePaisCount cliente = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_SIETE;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new ClientePaisCount();

                cliente.setPais(rs.getString("pais"));
                cliente.setCantidad_clientes(rs.getInt("cantidad_clientes"));

                clienteList.add(cliente);
                System.out.println(cliente.toString());
            }

            if (clienteList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(clienteList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoSiente DaoCliente" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoSiete DaoCliente");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
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
        Response<String> response = new Response<>();
        String cliente = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_DIEZ;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {

                cliente = rs.getString("nombre_cliente");
                System.out.println(cliente);


            }

            if (cliente == null) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(cliente);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoDiez DaoCliente" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoDiez DaoCliente");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }

}
