package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.repository.BodegaRepository;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/todas")
    public ResponseEntity<List<Bodega>> obtenerTodasLasBodegas() {
        try {
            List<Bodega> bodegas = bodegaRepository.buscarTodasLasBodegas();
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> crearBodega(@RequestBody Bodega bodega) {
        System.out.println("Bodega recibida: " + bodega);

        if (bodega.getNombre() == null || bodega.getNombre().trim().isEmpty()) {
            return new ResponseEntity<>("Error de validación: El campo 'Nombre' es requerido y no puede estar vacío.",
                    HttpStatus.BAD_REQUEST);
        }

        if (bodega.getTamano() == null || bodega.getTamano() <= 0) {
            return new ResponseEntity<>("Error de validación: El campo 'Tamano' es requerido y debe ser mayor que 0.",
                    HttpStatus.BAD_REQUEST);
        }

        bodegaRepository.save(bodega);
        return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> bodegaBorrar(@PathVariable("id") int id) {
        try {
            bodegaRepository.eliminarBodegaPorId((int) id);
            return ResponseEntity.ok("Bodega eliminada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
