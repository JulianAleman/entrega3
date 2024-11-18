package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class Ciudad {
    @Id
    private int Codigo;
    private String Nombre; 

    public Ciudad(int Codigo, String Nombre){
        this.Codigo=Codigo; 
        this.Nombre=Nombre; 
    }

    public Ciudad(){}

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
}
