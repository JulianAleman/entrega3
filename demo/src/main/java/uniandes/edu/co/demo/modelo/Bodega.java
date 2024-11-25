package uniandes.edu.co.demo.modelo;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.ToString;

@Document(collection = "bodegas")
@ToString
public class Bodega {
    @Id
    private int _id; 
    private String Nombre; 
    private Double Tamano; 
    private List<InfoProducto> Productos; 
    private List<RecepcionProductos> Recepciones; 

    public Bodega(int id, String nombre, Double capacidadAlmacenamiento, Double tamaño, int totalExistencias, List<InfoProducto> productos, List<RecepcionProductos> recepciones ){
        this._id=id;
        this.Nombre=nombre;  
        this.Tamano=tamaño;  
        this.Productos=productos; 
        this.Recepciones=recepciones; 
    }

    public Bodega(){}
    
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public Double getTamano() {
        return this.Tamano;
    }

    public void setTamano(Double tamano) {
        this.Tamano = tamano;
    }

    public List<InfoProducto> getProductos() {
        return this.Productos;
    }

    public void setProductos(List<InfoProducto> productos) {
        this.Productos = productos;
    }

    public List<RecepcionProductos> getRecepciones() {
        return this.Recepciones;
    }

    public void setRecepciones(List<RecepcionProductos> recepciones) {
        this.Recepciones = recepciones;
    }

}
