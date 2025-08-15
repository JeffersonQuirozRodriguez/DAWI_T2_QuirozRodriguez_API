package com.i202404259.dawi_t2_quiroz_api.service;

import com.i202404259.dawi_t2_quiroz_api.entity.Artista;
import com.i202404259.dawi_t2_quiroz_api.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }
    public Optional<Artista> obtenerArtista(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        return artistaRepository.findById(id);
    }
    public Artista crearArtista(Artista artista) {
        if (artista.getNombreArtista() == null || artista.getNombreArtista().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del artista es obligatorio");
        }
        if (artistaRepository.existsByNombreIgnoreCase(artista.getNombreArtista().trim())) {
            throw new IllegalArgumentException("Ya existe un artista con el nombre: " + artista.getNombreArtista());
        }
        artista.setNombreArtista(artista.getNombreArtista().trim());
        return artistaRepository.save(artista);
    }
    public Artista actualizarArtista(Integer id, Artista artista) {
        if (!artistaRepository.existsById(id)) {
            throw new IllegalArgumentException("El artista con ID " + id + " no existe");
        }
        if (artistaRepository.existsByNombreIgnoreCaseAndIdNot(artista.getNombreArtista(), id)) {
            throw new IllegalArgumentException("Ya existe un artista con ese nombre");
        }
        artista.setIdArtista(id);
        return artistaRepository.save(artista);
    }

    public void eliminarArtista(Integer id) {
        if (!artistaRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe el artista con ID " + id);
        }
        artistaRepository.deleteById(id);
    }
}
