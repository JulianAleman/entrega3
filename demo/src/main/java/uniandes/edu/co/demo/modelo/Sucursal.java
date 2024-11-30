package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.ToString;

@Document(collection = "sucursales")
@ToString
public class Sucursal {
    @Id
    private int id; 
    private String Nombre; 
    private Double Tamano; 
    private String Direccion; 
    private String Telefono;
    private Ciudad Ciudad; 
    private List<OrdenCompra> OrdenCompra; 
    private List<Bodega> Bodegas;

    public Sucursal(int id, String Nombre, Double Tamano, String Direccion, String Telefono, Ciudad Ciudad, List<OrdenCompra> OrdenCompra, List<Bodega> Bodegas){
        this.id=id; 
        this.Nombre=Nombre; 
        this.Tamano=Tamano;
        this.Direccion=Direccion;
        this.Telefono=Telefono; 
        this.Ciudad=Ciudad; 
        this.OrdenCompra=OrdenCompra;
    }

    public Sucursal(){}

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return this.Nombre;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public Double getTamano() {
        return this.Tamano;
    }
    
    public void setTamano(Double Tamano) {
        this.Tamano = Tamano;
    }
    
    public String getDireccion() {
        return this.Direccion;
    }
    
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public String getTelefono() {
        return this.Telefono;
    }
    
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public Ciudad getCiudad() {
        return this.Ciudad;
    }
    
    public void setCiudad(Ciudad Ciudad) {
        this.Ciudad = Ciudad;
    }

    public List<OrdenCompra> getOrden(){
        return this.OrdenCompra;
    }

    public void serOrden(List<OrdenCompra> OrdenCompra){
        this.OrdenCompra=OrdenCompra;
    }
    
    public List<Bodega> getBodegas() {
        return this.Bodegas;
    }

    public void setBodegas(List<Bodega> Bodegas) {
        this.Bodegas = Bodegas;
    }

}
