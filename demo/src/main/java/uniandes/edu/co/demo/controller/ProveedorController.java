package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Proveedor;
import uniandes.edu.co.demo.repository.ProveedorRepository;


@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/todos")
    public ResponseEntity<List<Proveedor>> obtenerTodosLosBares() {
        try {
            List<Proveedor> bodegas = proveedorRepository.buscarTodasLosProveedores();
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/new/save")
    public ResponseEntity<String> crearProveedor(@RequestBody Proveedor proveedor) {
        try {
        proveedorRepository.save(proveedor);
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la sucursal: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarProveedor( @RequestBody Proveedor proveedor) {
        try{
            proveedorRepository.actualizarProveedor(proveedor.getNit(), proveedor.getNombreContacto());
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>("null"+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
