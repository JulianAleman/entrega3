package uniandes.edu.co.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Integer>{

    @Query(value="{}")
    List<Producto> buscarTodosLosProductos();

    @Query("{ $insertOne: {CodigoBarras:?0, Nombre:?1, PrecioUnitarioVenta:?2, Presentacion:?3, CantidadPresentacion:?4, UnidadMedida:?5, FechaExpiracion:?6, tipo:?7, Categoria:?8, EspecificacionEmpacado:?9}}")
    void insertarProducto(int codigoBarras, String nombre, Double PrecioUnitarioVenta, String presentacion, Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, String tipo, String categoria, String especificacionEmpacado);

    @Query("{ $or: [ { 'CodigoBarras': ?0 }, { 'Nombre': ?1 } ] }")
    Producto buscarProductoPorCodigoONombre(int codigo, String nombre);

    @Query("{ _id: ?0 }")
    @Update("{ $set: { Nombre: ?1, PrecioUnitarioVenta: ?2, Presentacion: ?3, CantidadPresentacion: ?4, UnidadMedida: ?5, FechaExpiracion: ?6, tipo: ?7, Categoria: ?8, EspecificacionEmpacado: ?9 } }")
    void actualizarProducto(int codigoBarras, String nombre, Double PrecioUnitarioVenta, String presentacion, Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, String tipo, String categoria, String especificacionEmpacado);
    
    @Query("{ 'PrecioUnitarioVenta': { $gte: ?0, $lte: ?1 } }")
    List<Producto> buscarProductosPorRangoDePrecio(double precioMin, double precioMax);

    @Query("{ 'FechaExpiracion': { $gte: ?0 } }")
    List<Producto> buscarProductosPorFechaExpiracionPosterior(Date fecha);

    @Query("{ 'FechaExpiracion': { $lte: ?0 } }")
    List<Producto> buscarProductosPorFechaExpiracionInferior(Date fecha);

    @Query("{ 'idSucursal': ?0 }")
    List<Producto> buscarProductosPorSucursal(int idSucursal);

    @Query("{ 'Categoria': ?0 }")
    List<Producto> buscarProductosPorCategoria(String categoria);

    @Query("{ 'precio' : { $gte: ?0, $lte: ?1 },  'categoria.id' : ?2}")
    List<Producto> buscarProductosPorCriterios(Double precioMin, Double precioMax, int idCategoria);
}
