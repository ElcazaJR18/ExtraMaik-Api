package mx.edu.utez.extramike.model.pedido;

public class PedidoCount {

    private String estado;
    private int cantidad_pedidos;

    public PedidoCount() {
    }

    public PedidoCount(String estado, int cantidad_pedidos) {
        this.estado = estado;
        this.cantidad_pedidos = cantidad_pedidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad_pedidos() {
        return cantidad_pedidos;
    }

    public void setCantidad_pedidos(int cantidad_pedidos) {
        this.cantidad_pedidos = cantidad_pedidos;
    }


}
