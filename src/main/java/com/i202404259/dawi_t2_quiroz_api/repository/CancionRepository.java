package com.i202404259.dawi_t2_quiroz_api.repository;

import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    // Validar que no exista canción con mismo título para el mismo artista
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
            "FROM Cancion c WHERE LOWER(c.titulo) = LOWER(:titulo) AND c.artista.idArtista = :idArtista")
    boolean existsByTituloAndArtista(@Param("titulo") String titulo, @Param("idArtista") Integer idArtista);
}
