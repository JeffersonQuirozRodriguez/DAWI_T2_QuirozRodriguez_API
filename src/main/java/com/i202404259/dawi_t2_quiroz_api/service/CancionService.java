package com.i202404259.dawi_t2_quiroz_api.service;

import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import com.i202404259.dawi_t2_quiroz_api.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> listarCanciones() {
        return cancionRepository.findAll();
    }

    public Optional<Cancion> obtenerCancion(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        return cancionRepository.findById(id);
    }

    public Cancion crearCancion(Cancion cancion) {
        if (cancion.getTitulo() == null || cancion.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título de la canción es obligatorio");
        }
        if (cancionRepository.existsByTituloAndArtista(cancion.getTitulo(), cancion.getArtista().getIdArtista())) {
            throw new IllegalArgumentException("Ya existe una canción con ese título para este artista");
        }
        cancion.setTitulo(cancion.getTitulo().trim());
        return cancionRepository.save(cancion);
    }

    public void eliminarCancion(Integer id) {
        if (!cancionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe la canción con ID " + id);
        }
        cancionRepository.deleteById(id);
    }
}