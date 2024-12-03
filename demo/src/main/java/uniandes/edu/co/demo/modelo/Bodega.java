package uniandes.edu.co.demo.modelo;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "bodegas")
@ToString
public class Bodega {

    @Id
    @JsonProperty("_id")
    private int _id;
    @JsonProperty("Nombre")
    private String Nombre;
    @JsonProperty("Tamano")
    private Double Tamano;
    private List<InfoProducto> Productos;
    private List<RecepcionProductos> Recepciones;

    // Constructor vacío
    public Bodega() {
    }

    // Constructor con parámetros
    public Bodega(int id, String nombre, Double tamano, List<InfoProducto> productos, List<RecepcionProductos> recepciones) {
        this._id = id;
        this.Nombre = nombre;
        this.Tamano = tamano;
        this.Productos = productos;
        this.Recepciones = recepciones;
    }

    // Getter y setter para _id
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    // Getter y setter para Nombre
    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    // Getter y setter para Tamano
    public Double getTamano() {
        return this.Tamano;
    }

    public void setTamano(Double tamano) {
        this.Tamano = tamano;
    }

    // Getter y setter para Productos
    public List<InfoProducto> getProductos() {
        return this.Productos;
    }

    public void setProductos(List<InfoProducto> productos) {
        this.Productos = productos;
    }

    // Getter y setter para Recepciones
    public List<RecepcionProductos> getRecepciones() {
        return this.Recepciones;
    }

    public void setRecepciones(List<RecepcionProductos> recepciones) {
        this.Recepciones = recepciones;
    }
}
