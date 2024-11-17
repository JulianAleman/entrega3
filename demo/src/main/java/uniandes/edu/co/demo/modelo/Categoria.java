package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Categoria {
    @Id
    private Long Codigo;
    private String Nombre; 
    private String Descripcion; 
    private String CaracteristicasAlmacenamiento; 

    public Categoria (Long Codigo, String Nombre, String Descripcion, String CaracteristicasAlmacenamiento){
        this.Codigo=Codigo; 
        this.Nombre=Nombre;
        this.Descripcion=Descripcion;
        this.CaracteristicasAlmacenamiento=CaracteristicasAlmacenamiento;
    }

    public Categoria(){}
    
    public Long getCodigo(){
        return this.Codigo; 
    }

    public void setCodigo(Long Codigo){
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
        return this.CaracteristicasAlmacenamiento;
    }

    public void setCaracteristica( String CaracteristicasAlmacenamiento){
        this.CaracteristicasAlmacenamiento=CaracteristicasAlmacenamiento; 
    }
}
