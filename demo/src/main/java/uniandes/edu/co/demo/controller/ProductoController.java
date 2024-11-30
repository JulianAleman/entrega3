package uniandes.edu.co.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Producto;
import uniandes.edu.co.demo.repository.ProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        try {
            List<Producto> productos = productoRepository.buscarTodosLosProductos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try {
            productoRepository.insertarProducto(producto.getCodigoBarras(), producto.getNombre(), producto.getPrecioUnitarioVenta(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getFechaExpiracion(), producto.getTipo(), producto.getCategoria().toString(), producto.getEspecificacionEmpacado().toString());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarPorCodigoONombre")
    public ResponseEntity<Producto> buscarProducto(@RequestParam(required = false) Integer codigo, @RequestParam(required = false) String nombre) {
        try {
            Producto producto = productoRepository.buscarProductoPorCodigoONombre(codigo, nombre);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<String> actualizarProducto(@PathVariable int codigo, @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(codigo, producto.getNombre(), producto.getPrecioUnitarioVenta(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getFechaExpiracion(), producto.getTipo(), producto.getCategoria().toString(), producto.getEspecificacionEmpacado().toString());
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
