package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.OrdenCompra;
import uniandes.edu.co.demo.modelo.InfoOrden;
import uniandes.edu.co.demo.repository.OrdenCompraRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ordenesCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> crearOrdenCompra(@RequestParam int id, @RequestParam Date FechaEntrega, @RequestParam int Proveedor, @RequestParam List<InfoOrden> productos, @RequestParam int idSucursal) {
        try {
            Date FechaCreacion = new Date();
            String Estado = "vigente";
            OrdenCompra nuevaOrden = new OrdenCompra(id, FechaCreacion, Estado, FechaEntrega, Proveedor, productos, idSucursal);
            ordenCompraRepository.save(nuevaOrden);
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todas")
    public ResponseEntity<List<OrdenCompra>> obtenerTodasLasOrdenesCompra() {
        try {
            List<OrdenCompra> ordenesCompra = ordenCompraRepository.buscarTodasLasOrdenesCompra();
            return ResponseEntity.ok(ordenesCompra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/leer/{id}")
    public ResponseEntity<OrdenCompra> leerOrdenCompra(@PathVariable int id) {
        try {
            OrdenCompra ordenCompra = ordenCompraRepository.buscarOrdenCompraPorId(id);
            if (ordenCompra != null) {
                return ResponseEntity.ok(ordenCompra);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
