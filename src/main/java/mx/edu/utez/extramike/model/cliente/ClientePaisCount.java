package mx.edu.utez.extramike.model.cliente;

public class ClientePaisCount {

    private String pais;
    private int cantidad_clientes;

    public ClientePaisCount() {
    }

    public ClientePaisCount(String pais, int cantidad_clientes) {
        this.pais = pais;
        this.cantidad_clientes = cantidad_clientes;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantidad_clientes() {
        return cantidad_clientes;
    }

    public void setCantidad_clientes(int cantidad_clientes) {
        this.cantidad_clientes = cantidad_clientes;
    }

}
