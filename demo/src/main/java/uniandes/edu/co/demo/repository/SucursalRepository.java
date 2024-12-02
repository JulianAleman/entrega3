package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Ciudad;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal, Integer>{
    @Query(value="{}")
    List<Sucursal> buscarTodasLasSucursales();

    @Query("{$insertOne:{_id:?0, Nombre:?1, Tamamo:?2, Direccion:?3, Telefono:?4}}")
    void insertarSucursal(int id, String Nombre, Double Tamano, String Direccion, String Telefono);

    @Query("{ '_id': ?0 }")
    Sucursal buscarSucursalPorId(int id);

    @Query(value = "{ '_id': ?0 }", fields = "{ 'ordenesDeCompra': 1, '_id': 0 }")
    List<OrdenCompra> findOrdenesDeCompraBySucursalId(int id);

    @Query(value = "{ 'ordenesDeCompra.id': ?0 }", fields = "{ 'ordenesDeCompra.$': 1 }")
    Sucursal findOrdenDeCompraById(int ordenId);

    @Aggregation(pipeline = {
        "{ $unwind: '$OrdenCompra' }", 
        "{ $replaceRoot: { newRoot: '$OrdenCompra' } }" 
    })
    List<OrdenCompra> findAllOrdenes();

    @Query("{ '_id': ?0 }")
    @Update("{ $push: { 'OrdenCompra': ?1 } }")
    void agregarOrdenCompra(int idSucursal, OrdenCompra nuevaOrden);
}
