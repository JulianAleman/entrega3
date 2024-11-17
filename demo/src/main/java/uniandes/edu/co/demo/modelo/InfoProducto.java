package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class InfoProducto {
    private Integer TotalExistencias;
    private Double CostoPromedio; 
    private Integer NivelMinimoReOrden; 
    private Integer CapacidadAlmacenamiento; 
    private Integer CantidadExistenacias;
    private Producto Producto; 
    
    public InfoProducto(Integer TotalExistencias,Double CostoPromedio,  Integer NivelMinimoReOrden, Integer CapacidadAlmacenamiento, Integer CantidadExistenacias,Producto Producto ){
        this.TotalExistencias=TotalExistencias; 
        this.CostoPromedio=CostoPromedio; 
        this.NivelMinimoReOrden=NivelMinimoReOrden; 
        this.CapacidadAlmacenamiento=CapacidadAlmacenamiento; 
        this.CantidadExistenacias=CantidadExistenacias; 
        this.Producto=Producto;
    }

    public InfoProducto(){}
    
    public Integer getTotalExistencias() {
        return TotalExistencias;
    }
    
    public void setTotalExistencias(Integer TotalExistencias) {
        this.TotalExistencias = TotalExistencias;
    }
    
    public Double getCostoPromedio() {
        return CostoPromedio;
    }
    
    public void setCostoPromedio(Double CostoPromedio) {
        this.CostoPromedio = CostoPromedio;
    }
    
    public Integer getNivelMinimoReOrden() {
        return NivelMinimoReOrden;
    }
    
    public void setNivelMinimoReOrden(Integer NivelMinimoReOrden) {
        this.NivelMinimoReOrden = NivelMinimoReOrden;
    }
    
    public Integer getCapacidadAlmacenamiento() {
        return CapacidadAlmacenamiento;
    }
    
    public void setCapacidadAlmacenamiento(Integer CapacidadAlmacenamiento) {
        this.CapacidadAlmacenamiento = CapacidadAlmacenamiento;
    }
    
    public Integer getCantidadExistenacias() {
        return CantidadExistenacias;
    }
    
    public void setCantidadExistenacias(Integer CantidadExistenacias) {
        this.CantidadExistenacias = CantidadExistenacias;
    }
    
    public Producto getProducto() {
        return Producto;
    }
    
    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    } 
}
