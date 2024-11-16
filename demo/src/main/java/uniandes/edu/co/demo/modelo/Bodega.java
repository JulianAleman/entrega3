package uniandes.edu.co.demo.modelo;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.ToString;

@Document(collection = "bodegas")
@ToString
public class Bodega {
    @Id
    private int id; 
    private String nombre; 
    private Double capacidadAlmacenamiento; 
    private Double tamano; 
    private int totalExistencias; 
    private List<Producto> productos; 
    private List<RecepcionProductos> recepciones; 

    public Bodega(int id, String nombre, Double capacidadAlmacenamiento, Double tamaño, int totalExistencias, List<Producto> productos, List<RecepcionProductos> recepciones ){
        this.id=id;
        this.nombre=nombre; 
        this.capacidadAlmacenamiento=capacidadAlmacenamiento; 
        this.tamano=tamaño; 
        this.totalExistencias=totalExistencias; 
        this.productos=productos; 
        this.recepciones=recepciones; 
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(Double capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public int getTotalExistencias() {
        return totalExistencias;
    }

    public void setTotalExistencias(int totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<RecepcionProductos> getRecepciones() {
        return recepciones;
    }

    public void setRecepciones(List<RecepcionProductos> recepciones) {
        this.recepciones = recepciones;
    }

}
