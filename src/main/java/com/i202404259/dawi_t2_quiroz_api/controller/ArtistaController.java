package com.i202404259.dawi_t2_quiroz_api.controller;

import com.i202404259.dawi_t2_quiroz_api.entity.Artista;
import com.i202404259.dawi_t2_quiroz_api.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
@CrossOrigin(origins = "*")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public ResponseEntity<List<Artista>> listarArtistas() {
        return ResponseEntity.ok(artistaService.listarArtistas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerArtista(@PathVariable Integer id) {
        return artistaService.obtenerArtista(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Artista no encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> crearArtista(@RequestBody Artista artista) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(artistaService.crearArtista(artista));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarArtista(@PathVariable Integer id, @RequestBody Artista artista) {
        try {
            return ResponseEntity.ok(artistaService.actualizarArtista(id, artista));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarArtista(@PathVariable Integer id) {
        try {
            artistaService.eliminarArtista(id);
            return ResponseEntity.ok("Artista eliminado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}