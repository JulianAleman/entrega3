package uniandes.edu.co.demo.modelo;

import java.util.Date;

public class ProductoPerecedero extends Producto{
    private Date FechaVencimiento;

    public ProductoPerecedero(int CodigoBarras,String Nombre, Double PrecioUnitarioVenta,String Presentacion,Integer CantidadPresentacion,String UnidadMedida,Date FechaExpiracion,String tipo,Categoria Categoria,EspecificacionEmpacado EspecificacionEmpacado, Date FechaVencimiento){
        super( CodigoBarras,Nombre,PrecioUnitarioVenta,Presentacion,CantidadPresentacion,UnidadMedida,FechaExpiracion,tipo,Categoria,EspecificacionEmpacado);
        this.FechaVencimiento=FechaVencimiento;
    }

    public ProductoPerecedero(){}
    
    public Date getFechaV(){
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento){
        this.FechaVencimiento=FechaVencimiento; 
    }
}
