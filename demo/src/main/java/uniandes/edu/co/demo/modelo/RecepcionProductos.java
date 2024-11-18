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

    public RecepcionProductos(){}
    
    public Integer getId(){
        return this.id; 
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha(){
        return this.FechaRecepcion; 
    }

    public void setFecha(Date FechaRecepcion){
        this.FechaRecepcion=FechaRecepcion; 
    }

    public OrdenCompra getOrden(){
        return this.OrdenCompra; 
    }

    public void setOrden(OrdenCompra OrdenCompra){
        this.OrdenCompra=OrdenCompra;
    }

}
