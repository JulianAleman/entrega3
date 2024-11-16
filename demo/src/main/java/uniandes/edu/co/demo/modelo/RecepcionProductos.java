package uniandes.edu.co.demo.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class RecepcionProductos {
    @Id
    private int id; 
    private Date FechaRecepcion;
    private OrdenCompra OrdenCompra; 

    public RecepcionProductos(int id, Date FechaRecepcion, OrdenCompra OrdenCompra){
        this.id = id; 
        this.FechaRecepcion=FechaRecepcion; 
        this.OrdenCompra = OrdenCompra;
    }

}
