package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class InfoOrden {
    private Integer Cantidad; 
    private Double CostoUnitarioCompra; 
    private Long Producto; 

    public InfoOrden(Integer Cantidad, Double CostoUnitarioCompra, Long Producto){
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

    public Long getProducto(){
        return this.Producto; 
    }

    public void setProducto(long Producto){
        this.Producto=Producto; 
    }
}
