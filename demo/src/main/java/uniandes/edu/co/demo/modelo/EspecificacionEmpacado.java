package uniandes.edu.co.demo.modelo;

import lombok.ToString;

@ToString
public class EspecificacionEmpacado {
    private Double Volumen_Cm3; 
    private Double Peso_Gr; 

    public EspecificacionEmpacado(Double Volumen_Cm3, Double Peso_Gr){
        this.Volumen_Cm3=Volumen_Cm3; 
        this.Peso_Gr=Peso_Gr; 
    }

    public EspecificacionEmpacado(){}
    
    public Double getVolumen(){
        return this.Volumen_Cm3; 
    }
    public Double getPeso(){
        return this.Peso_Gr;
    }
    public void setVolumen(Double volumen){
        this.Volumen_Cm3 = volumen;
    }
    public void setPeso(Double Peso){
        this.Peso_Gr=Peso; 
    }

}
