package uniandes.edu.co.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.demo.modelo.Ciudad;
import uniandes.edu.co.demo.modelo.Sucursal;

public interface SucursalRepository extends MongoRepository<Sucursal, Integer>{
    @Query(value="{}")
    List<Sucursal> buscarTodasLasSucursales();

    @Query("{$insertOne:{_id:?0, Nombre:?1, Tamamo:?2, Direccion:?3, Telefono:?4, Ciudad: ?5}}")
    void insertarSucursal(int id, String Nombre, Double Tamano, String Direccion, String Telefono, Ciudad Ciudad);

    @Query("{ '_id': ?0 }")
    Sucursal buscarSucursalPorId(int id);
}
