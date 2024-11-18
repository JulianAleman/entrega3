package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class InfoProducto {
    private int TotalExistencias;
    private Double CostoPromedio; 
    private int NivelMinimoReOrden; 
    private int CapacidadAlmacenamiento; 
    private int CantidadExistenacias;
    private int Producto; 
    
    public InfoProducto(Integer TotalExistencias,Double CostoPromedio,  Integer NivelMinimoReOrden, Integer CapacidadAlmacenamiento, Integer CantidadExistenacias,int Producto ){
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
    
    public int getProducto() {
        return Producto;
    }
    
    public void setProducto(int Producto) {
        this.Producto = Producto;
    } 
}
