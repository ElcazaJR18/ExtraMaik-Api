package mx.edu.utez.extramike.model.pedido;

import mx.edu.utez.extramike.model.Repository;
import mx.edu.utez.extramike.model.cliente.ClientePaisCount;
import mx.edu.utez.extramike.model.cliente.DaoCliente;
import mx.edu.utez.extramike.utils.MySQLConnection;
import mx.edu.utez.extramike.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DaoPedido implements Repository {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection mysql = new MySQLConnection();


    private final String PUNTO_NUEVE = "SELECT estado, COUNT(*) as cantidad_pedidos\n" +
                                       "FROM pedido\n" +
                                       "GROUP BY estado\n" +
                                       "ORDER BY cantidad_pedidos DESC;";


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
        return null;
    }

    @Override
    public Response<List> puntoNueve() {
        List<PedidoCount> pedidoList = new ArrayList<>();
        Response<List> response = new Response<>();
        PedidoCount pedido = null;

        try {

            conn = mysql.getConnection();
            String query = PUNTO_NUEVE;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                pedido = new PedidoCount();

                pedido.setEstado(rs.getString("estado"));
                pedido.setCantidad_pedidos(rs.getInt("cantidad_pedidos"));

                pedidoList.add(pedido);
                System.out.println(pedido.toString());
            }

            if (pedidoList.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing Found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("OK");
                response.setData(pedidoList);
            }

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(java.util.logging.Level.SEVERE, "Error -> puntoNueve DaoPedido" , e.getMessage());

            response.setError(true);
            response.setStatus(400);
            response.setMessage("Error -> puntoNueve DaoPedido");
            response.setData(null);
        } finally {
            mysql.close(conn, pstm, rs);
        }
        return response;
    }

    @Override
    public Response<String> puntoDiez() {
        return null;
    }
}
