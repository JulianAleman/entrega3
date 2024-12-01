package uniandes.edu.co.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Bodega;

public interface BodegaRepository extends MongoRepository<Bodega, Integer>{

    @Query(value="{}")
    List<Bodega> buscarTodasLasBodegas();

    @Query(value="{_id:?0}", delete =true)
    void eliminarBodegaPorId(int id);

    @Query("{ $insertOne:{_id:?0, Nombre:?1, Tamano:?2}}")
    void crearBodega(int id, String nombre, Double tamano);

    
}
