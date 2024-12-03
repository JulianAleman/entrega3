package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Categoria {
    private int Codigo;
    private String Nombre; 
    private String Descripcion; 
    private String Caracteristicas; 

    public Categoria (int Codigo, String Nombre, String Descripcion, String CaracteristicasAlmacenamiento){
        this.Codigo=Codigo; 
        this.Nombre=Nombre;
        this.Descripcion=Descripcion;
        this.Caracteristicas=CaracteristicasAlmacenamiento;
    }

    public Categoria(){}
    
    public int getCodigo(){
        return this.Codigo; 
    }

    public void setCodigo(int Codigo){
        this.Codigo=Codigo;
    }

    public String getNombre(){
        return this.Nombre; 
    }
    
    public void setNombre(String Nombre){
        this.Nombre=Nombre; 
    }

    public String getDescripcion(){
        return this.Descripcion;
    }

    public void setDescripcion( String Descripcion){
        this.Descripcion=Descripcion; 
    }
    public String getCaracteristica(){
        return this.Caracteristicas;
    }

    public void setCaracteristica( String CaracteristicasAlmacenamiento){
        this.Caracteristicas=CaracteristicasAlmacenamiento; 
    }
}
