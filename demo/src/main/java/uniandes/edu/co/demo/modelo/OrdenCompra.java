package uniandes.edu.co.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class OrdenCompra {
    @Id
    private Long id; 
    private Date FechaCreacion; 
    private String Estado; 
    private Date FechaEntrega;
    private Proveedor Proveedor; 
    private List<InfoOrden> Productos; 
    
    public OrdenCompra (Long id, Date FechaCreacion, String Estado, Date FechaEntrega, Proveedor Proveedor, List<InfoOrden> productos){
        this.id=id; 
        this.FechaCreacion=FechaCreacion;
        this.Estado=Estado; 
        this.FechaEntrega=FechaEntrega; 
        this.Proveedor=Proveedor; 
        this.Productos=productos; 
    }

    public OrdenCompra(){}

    public Long getId(){
        return this.id; 
    }

    public void setId(Long id){
        this.id=id; 
    }

    public Date getFechaC(){
        return this.FechaCreacion; 
    }

    public void setFechaC(Date FechaCreacion){
        this.FechaCreacion=FechaCreacion; 
    }

    public String getEstado(){
        return this.Estado; 
    }

    public void setEstado(String Estado){
        this.Estado=Estado;
    }

    public Date getFechaE(){
        return this.FechaEntrega; 
    }

    public void setFechaE(Date FechaEntrega){
        this.FechaEntrega=FechaEntrega; 
    }

    public Proveedor geProveedor(){
        return this.Proveedor; 
    }

    public void setProveedor(Proveedor Proveedor){
        this.Proveedor=Proveedor;
    }


    public List<InfoOrden> getProductos(){
        return this.Productos; 
    }

    public void setEstado(List<InfoOrden> Productos){
        this.Productos=Productos;
    }
}
