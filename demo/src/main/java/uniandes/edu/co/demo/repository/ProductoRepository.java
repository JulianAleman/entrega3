package uniandes.edu.co.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.demo.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Integer>{

    @Query(value="{}")
    List<Producto> buscarTodosLosProductos();

    @Query("{ $insertOne: {CodigoBarras:?0, Nombre:?1, PrecioUnitarioVenta:?2, Presentacion:?3, CantidadPresentacion:?4, UnidadMedida:?5, FechaExpiracion:?6, tipo:?7, Categoria:?8, EspecificacionEmpacado:?9}}")
    void insertarProducto(int codigoBarras, String nombre, Double PrecioUnitarioVenta, String presentacion, Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, String tipo, String categoria, String especificacionEmpacado);

    @Query("{ $or: [ { 'CodigoBarras': ?0 }, { 'Nombre': ?1 } ] }")
    Producto buscarProductoPorCodigoONombre(int codigo, String nombre);
}
