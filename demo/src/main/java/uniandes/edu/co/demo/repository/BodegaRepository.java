package uniandes.edu.co.demo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import uniandes.edu.co.demo.modelo.Bodega;

public interface BodegaRepository extends MongoRepository<Bodega, Integer>{

    @Query(value="{}", fields="{}")
    List<Bodega> buscarTodasLasBodegas();


    
}
