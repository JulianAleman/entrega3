package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "proveedores")
@ToString
public class Proveedor {
    @Id
    private Long Nit;
    private String Nombre; 
    private String Direccion; 
    private String NombreContacto; 
    private Long TelefonoContacto; 
    private List<Producto> Productos; 

    public Proveedor(Long Nit, String Nombre, String Direccion, String NombreContacto, Long TelefonoContacto, List<Producto> productos){
        this.Nit=Nit; 
        this.Nombre=Nombre; 
        this.Direccion=Direccion; 
        this.NombreContacto=NombreContacto; 
        this.TelefonoContacto=TelefonoContacto;
        this.Productos=productos; 
    }

    public Proveedor(){}

    public Long getNit() {
        return this.Nit;
    }
    
    public void setNit(Long Nit) {
        this.Nit = Nit;
    }
    
    public String getNombre() {
        return this.Nombre;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getDireccion() {
        return this.Direccion;
    }
    
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public String getNombreContacto() {
        return this.NombreContacto;
    }
    
    public void setNombreContacto(String NombreContacto) {
        this.NombreContacto = NombreContacto;
    }
    
    public Long getTelefonoContacto() {
        return this.TelefonoContacto;
    }
    
    public void setTelefonoContacto(Long TelefonoContacto) {
        this.TelefonoContacto = TelefonoContacto;
    }
    
    public List<Producto> getProductos() {
        return this.Productos;
    }
    
    public void setProductos(List<Producto> productos) {
        this.Productos = productos;
    }
    

}
