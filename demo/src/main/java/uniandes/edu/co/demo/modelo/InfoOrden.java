package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class InfoOrden {
    private Integer Cantidad; 
    private Double CostoUnitarioCompra; 
    private Producto Producto; 

    public InfoOrden(Integer Cantidad, Double CostoUnitarioCompra, Producto Producto){
        this.Cantidad=Cantidad; 
        this.CostoUnitarioCompra=CostoUnitarioCompra; 
        this.Producto=Producto; 
    }

    public InfoOrden(){}
    
    public Integer getCantidaf(){
        return this.Cantidad; 
    }

    public void setCantidad(Integer Cantidad){
        this.Cantidad=Cantidad; 
    }

    public Double getCosto(){
        return this.CostoUnitarioCompra; 
    }

    public void serCosto(Double CostoUnitarioCompra){
        this.CostoUnitarioCompra=CostoUnitarioCompra; 
    }

    public Producto getProducto(){
        return this.Producto; 
    }

    public void setProducto(Producto Producto){
        this.Producto=Producto; 
    }
}
