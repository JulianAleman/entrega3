package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.demo.modelo.Categoria;

import java.util.List;

public interface CategoriaRepository extends MongoRepository<Categoria, Integer> {

    @Query(value="{}")
    List<Categoria> buscarTodasLasCategorias();

    @Query("{ $insertOne:{codigo:?0, nombre:?1, descripcion:?2, caracteristicasAlmacenamiento:?3}}")
    void insertarCategoria(int codigo, String nombre, String descripcion, String caracteristicasAlmacenamiento);
}
