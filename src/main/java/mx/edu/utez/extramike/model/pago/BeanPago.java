package mx.edu.utez.extramike.model.pago;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@XmlRootElement(name = "BeanPago")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanPago {

    private int codigo_cliente;
    private String forma_pago;
    private String id_transaccion;
    private Date fecha_pago;
    private double total;

    public BeanPago() {
    }

    public BeanPago(int codigo_cliente, String forma_pago, String id_transaccion, Date fecha_pago, double total) {
        this.codigo_cliente = codigo_cliente;
        this.forma_pago = forma_pago;
        this.id_transaccion = id_transaccion;
        this.fecha_pago = fecha_pago;
        this.total = total;
    }


    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(String id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
