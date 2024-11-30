package uniandes.edu.co.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class OrdenCompra {
    @Id
    private int id; 
    private Date FechaCreacion; 
    private String Estado; 
    private Date FechaEntrega;
    private int Proveedor; 
    private List<InfoOrden> Productos; 
    private int idSucursal;
    
    public OrdenCompra (int id, Date FechaCreacion, String Estado, Date FechaEntrega, int Proveedor, List<InfoOrden> productos, int idSucursal){
        this.id=id; 
        this.FechaCreacion=FechaCreacion;
        this.Estado=Estado; 
        this.FechaEntrega=FechaEntrega; 
        this.Proveedor=Proveedor; 
        this.Productos=productos; 
        this.idSucursal=idSucursal;
    }

    public OrdenCompra(){}

    public int getId(){
        return this.id; 
    }

    public void setId(int id){
        this.id=id; 
    }

    public Date getFechaCracion(){
        return this.FechaCreacion; 
    }

    public void setFechaCreacion(Date FechaCreacion){
        this.FechaCreacion=FechaCreacion; 
    }

    public String getEstado(){
        return this.Estado; 
    }

    public void setEstado(String Estado){
        this.Estado=Estado;
    }

    public Date getFechaEntrega(){
        return this.FechaEntrega; 
    }

    public void setFechaEntrega(Date FechaEntrega){
        this.FechaEntrega=FechaEntrega; 
    }

    public int geProveedor(){
        return this.Proveedor; 
    }

    public void setProveedor(int Proveedor){
        this.Proveedor=Proveedor;
    }


    public List<InfoOrden> getProductos(){
        return this.Productos; 
    }

    public void setEstado(List<InfoOrden> Productos){
        this.Productos=Productos;
    }

    public int getIdSucursal(){
        return this.idSucursal; 
    }

    public void setIdSucursal(int idSucursal){
        this.idSucursal=idSucursal;
    }
}
