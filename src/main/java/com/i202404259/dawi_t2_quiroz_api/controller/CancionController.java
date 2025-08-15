package com.i202404259.dawi_t2_quiroz_api.controller;

import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import com.i202404259.dawi_t2_quiroz_api.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
@CrossOrigin(origins = "*")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping
    public ResponseEntity<List<Cancion>> listarCanciones() {
        return ResponseEntity.ok(cancionService.listarCanciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCancion(@PathVariable Integer id) {
        return cancionService.obtenerCancion(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Canción no encontrada"));
    }
    @PostMapping
    public ResponseEntity<?> crearCancion(@RequestBody Cancion cancion) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.crearCancion(cancion));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCancion(@PathVariable Integer id) {
        try {
            cancionService.eliminarCancion(id);
            return ResponseEntity.ok("Canción eliminada correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

