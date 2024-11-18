package uniandes.edu.co.demo.modelo;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.ToString;

@Document(collection = "productos")
@ToString
public class Producto {
    @Id
    private int CodigoBarras;
    private String Nombre; 
    private Double PrecioUnitarioVenta;
    private String Presentacion;
    private Integer CantidadPresentacion;
    private String UnidadMedida; 
    private Date FechaExpiracion;
    private String tipo;
    private Categoria Categoria;
    private EspecificacionEmpacado EspecificacionEmpacado;
    
    public Producto(int CodigoBarras,String Nombre, Double PrecioUnitarioVenta,String Presentacion,Integer CantidadPresentacion,String UnidadMedida,Date FechaExpiracion,String tipo,Categoria Categoria,EspecificacionEmpacado EspecificacionEmpacado){
        this.CodigoBarras=CodigoBarras;
        this.Nombre=Nombre;
        this.PrecioUnitarioVenta=PrecioUnitarioVenta;
        this.Presentacion=Presentacion;
        this.CantidadPresentacion=CantidadPresentacion;
        this.UnidadMedida=UnidadMedida;
        this.FechaExpiracion=FechaExpiracion;
        this.tipo=tipo;
        this.Categoria=Categoria;
        this.EspecificacionEmpacado=EspecificacionEmpacado;
    }
    public Producto(){}
    
    public int getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(int CodigoBarras) {
        this.CodigoBarras = CodigoBarras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getPrecioUnitarioVenta() {
        return PrecioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double PrecioUnitarioVenta) {
        this.PrecioUnitarioVenta = PrecioUnitarioVenta;
    }

    public String getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(String Presentacion) {
        this.Presentacion = Presentacion;
    }

    public Integer getCantidadPresentacion() {
        return CantidadPresentacion;
    }

    public void setCantidadPresentacion(Integer CantidadPresentacion) {
        this.CantidadPresentacion = CantidadPresentacion;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public Date getFechaExpiracion() {
        return FechaExpiracion;
    }

    public void setFechaExpiracion(Date FechaExpiracion) {
        this.FechaExpiracion = FechaExpiracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public EspecificacionEmpacado getEspecificacionEmpacado() {
        return EspecificacionEmpacado;
    }

    public void setEspecificacionEmpacado(EspecificacionEmpacado EspecificacionEmpacado) {
        this.EspecificacionEmpacado = EspecificacionEmpacado;
    }
}
