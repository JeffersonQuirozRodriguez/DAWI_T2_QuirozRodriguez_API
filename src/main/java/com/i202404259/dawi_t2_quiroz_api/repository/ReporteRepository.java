package com.i202404259.dawi_t2_quiroz_api.repository;

import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Cancion, Integer> {
    @Query("SELECT c FROM Cancion c " +
            "JOIN FETCH c.artista a " +
            "WHERE LOWER(a.generoMusical) = LOWER(:genero)")
    List<Cancion> findCancionesByGenero(@Param("genero") String genero);

    @Query("SELECT SUM(c.numeroReproducciones) " +
            "FROM Cancion c WHERE LOWER(c.artista.generoMusical) = LOWER(:genero)")
    Long totalReproduccionesByGenero(@Param("genero") String genero);

    //TOP ARTISTAS:
    @Query("SELECT a.nombreArtista, SUM(c.numeroReproducciones) as totalReps " +
            "FROM Cancion c JOIN c.artista a " +
            "GROUP BY a.idArtista, a.nombreArtista " +
            "ORDER BY totalReps DESC")
    List<Object[]> topArtistas();
}
