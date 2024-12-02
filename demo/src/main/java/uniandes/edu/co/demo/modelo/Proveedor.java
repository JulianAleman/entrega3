package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "proveedores")
@ToString
public class Proveedor {
    @Id
    private int nit;
    private String Nombre; 
    private String Direccion; 
    private String NombreContacto; 
    private String TelefonoContacto; 
    private List<Integer> Productos; 

    public Proveedor(int Nit, String Nombre, String Direccion, String NombreContacto, String TelefonoContacto, List<Integer> productos){
        this.nit=Nit; 
        this.Nombre=Nombre; 
        this.Direccion=Direccion; 
        this.NombreContacto=NombreContacto; 
        this.TelefonoContacto=TelefonoContacto;
        this.Productos=productos; 
    }

    public Proveedor(){}

    public int getNit() {
        return this.nit;
    }
    
    public void setNit(int Nit) {
        this.nit = Nit;
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
    
    public String getTelefonoContacto() {
        return this.TelefonoContacto;
    }
    
    public void setTelefonoContacto(String TelefonoContacto) {
        this.TelefonoContacto = TelefonoContacto;
    }
    
    public List<Integer> getProductos() {
        return this.Productos;
    }

    
    public void setProductos(List<Integer> productos) {
        this.Productos = productos;
    }
    

}
