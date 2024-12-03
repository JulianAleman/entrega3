package uniandes.edu.co.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Bodega;
import uniandes.edu.co.demo.modelo.InfoProducto;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;


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
            sucursalRepository.save(sucursal);
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sucursal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* @GetMapping("/inventario/{idSucursal}")
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
    } */




private static final Logger logger = LoggerFactory.getLogger(SucursalController.class);

@GetMapping("/inventario/sucursal/{idSucursal}")
public ResponseEntity<?> obtenerInventarioDeSucursal(@PathVariable int idSucursal) {
    try {
        logger.info("Iniciando consulta del inventario para la sucursal con ID: {}", idSucursal);

        Optional<Sucursal> sucursal = sucursalRepository.findById(idSucursal);

        if (sucursal.isEmpty()) {
            logger.error("Sucursal con ID {} no encontrada", idSucursal);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sucursal no encontrada");
        }

        List<Bodega> bodegas = sucursal.get().getBodegas();

        if (bodegas == null || bodegas.isEmpty()) {
            logger.warn("No hay bodegas asociadas a la sucursal con ID {}", idSucursal);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay bodegas asociadas a esta sucursal");
        }

        logger.info("Bodegas encontradas para la sucursal con ID {}: {}", idSucursal, bodegas.size());


        List<InfoProducto> inventario = new ArrayList<>();
        for (Bodega bodega : bodegas) {
            List<InfoProducto> productos = bodega.getProductos();
            if (productos != null) {
                for (InfoProducto producto : productos) {
                    InfoProducto infoProducto = new InfoProducto();
                    infoProducto.setProducto(producto.getProducto());
                    infoProducto.setCostoPromedio(producto.getCostoPromedio());
                    inventario.add(infoProducto);
                }
            }
        }

        logger.info("Total de productos recopilados: {}", inventario.size());

        return ResponseEntity.ok(inventario);

    } catch (Exception e) {
        logger.error("Error procesando la consulta para la sucursal con ID {}: {}", idSucursal, e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error procesando la consulta");
    }
}


    @GetMapping("/OrdenesCompra/Sucursal")
    public ResponseEntity<List<OrdenCompra>> obtenerTodasLasOrdenes(@PathVariable int idSucursal) {
        try {
            List<OrdenCompra> sucursales = sucursalRepository.findOrdenesDeCompraBySucursalId(idSucursal);
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/OrdenCompra")
    public ResponseEntity<Sucursal> obtenerOrdenCompra(@PathVariable int idOrden) {
        try {
            Sucursal sucursales = sucursalRepository.findOrdenDeCompraById(idOrden);
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/Ordenescompra/todas")
    public ResponseEntity<List<OrdenCompra>> obtenerOrdenesCompra() {
        try {
            List<OrdenCompra> sucursales = sucursalRepository.findAllOrdenes();
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{id}/ordenes")
    public ResponseEntity<String> agregarOrdenCompra(
        @PathVariable int id,
        @RequestBody OrdenCompra nuevaOrden
    ) {
        sucursalRepository.agregarOrdenCompra(id, nuevaOrden);
        return ResponseEntity.ok("Orden de compra agregada con éxito a la sucursal con ID: " + id);
    }
}
