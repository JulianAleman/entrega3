package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Sucursal;
import uniandes.edu.co.demo.repository.SucursalRepository;


@RestController
@RequestMapping("/sucursales")
public class SucursalController {
     @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/todas")
    public ResponseEntity<List<Sucursal>> obtenerTodasSucursales() {
        try {
            List<Sucursal> bodegas = sucursalRepository.buscarTodasLasSucursales();
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
