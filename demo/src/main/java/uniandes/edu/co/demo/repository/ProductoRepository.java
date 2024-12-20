package uniandes.edu.co.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Categoria;
import uniandes.edu.co.demo.modelo.EspecificacionEmpacado;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.modelo.Sucursal;

public interface ProductoRepository extends MongoRepository<Producto, Integer>{

    @Query(value="{}")
    List<Producto> buscarTodosLosProductos();

    @Query("{ insertOne: { _id: ?0, Nombre: ?1, PrecioUnitarioVenta: ?2, Presentacion: ?3, CantidadPresentacion: ?4, UnidadMedida: ?5, FechaExpiracion: ?6, tipo: ?7, Categoria: ?8, EspecificacionEmpacado: ?9 }}")
    void insertarProducto(int _id, String Nombre, Double PrecioUnitarioVenta, String Presentacion, Integer CantidadPresentacion, String UnidadMedida, Date FechaExpiracion, String tipo, Categoria Categoria, EspecificacionEmpacado EspecificacionEmpacado);

    @Query("{ $or: [ { 'CodigoBarras': ?0 }, { 'Nombre': ?1 } ] }")
    Producto buscarProductoPorCodigoONombre(int codigo, String nombre);

    @Query("{ _id: ?0 }")
    @Update("{ $set: { Nombre: ?1, PrecioUnitarioVenta: ?2, Presentacion: ?3, CantidadPresentacion: ?4, UnidadMedida: ?5, FechaExpiracion: ?6, tipo: ?7, Categoria: ?8, EspecificacionEmpacado: ?9 } }")
    void actualizarProducto(int codigoBarras, String nombre, Double PrecioUnitarioVenta, String presentacion, Integer cantidadPresentacion, String unidadMedida, Date fechaExpiracion, String tipo, String categoria, String especificacionEmpacado);
    
    @Query(value = "{ '_id': ?0 }", fields = "{ 'Categoria': 1, '_id': 0 }")
    Categoria buscarCategoriaporProducto(int CodigoBarras);

    @Query(value = "{ '_id': ?0 }", fields = "{ 'categoria': 1 }")
    Producto encontrarCategoriaPorCodigoBarras(int codigoBarras);

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

    @Query("{ '_id': ?0 }")
    @Update("{ $set: { 'Categoria': ?1 } }")
    void agregarOrdenCompra(int idSucursal, Categoria nuevaOrden);
}
