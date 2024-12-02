package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor, Integer>{
    @Query(value="{}")
    List<Proveedor> buscarTodasLosProveedores();

    @Query("{_id:?0}")
    @Update("{ $set:{NombreContacto: ?1}}")
    void actualizarProveedor(int id, String nombrec);
}
