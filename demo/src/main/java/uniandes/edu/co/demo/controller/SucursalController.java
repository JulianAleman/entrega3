package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;
import uniandes.edu.co.demo.modelo.InfoProducto;
import uniandes.edu.co.demo.modelo.Producto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/todas")
    public ResponseEntity<List<Sucursal>> obtenerTodasLasSucursales() {
        try {
            List<Sucursal> sucursales = sucursalRepository.buscarTodasLasSucursales();
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> crearSucursal(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(sucursal.getId(), sucursal.getNombre(), sucursal.getTamano(), sucursal.getDireccion(), sucursal.getTelefono(), sucursal.getCiudad());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sucursal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/inventario/{idSucursal}")
    public ResponseEntity<?> obtenerInventarioDeSucursal(@PathVariable int idSucursal) {
        try {
            Sucursal sucursal = sucursalRepository.buscarSucursalPorId(idSucursal);
            if (sucursal == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sucursal no encontrada");
            }

            List<Bodega> bodegas = sucursal.getBodegas();
            if (bodegas == null || bodegas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay bodegas asociadas a esta sucursal");
            }

            List<InfoProducto> inventario = bodegas.stream()
                            .map(bodega -> {
                                InfoProducto infoProducto = new InfoProducto();
                                infoProducto.setProducto(bodega.getId());
                                int totalExistencias = bodega.getProductos().stream()
                                        .mapToInt(InfoProducto::getCantidadExistenacias)
                                        .sum();
                                infoProducto.setTotalExistencias(totalExistencias);
                                infoProducto.setNivelMinimoReOrden(infoProducto.getNivelMinimoReOrden());
                                infoProducto.setCostoPromedio(infoProducto.getCostoPromedio());
                                return infoProducto;
                            })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(inventario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
