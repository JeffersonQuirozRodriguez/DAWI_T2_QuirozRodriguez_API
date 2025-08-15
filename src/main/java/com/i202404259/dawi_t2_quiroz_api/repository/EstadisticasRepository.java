package com.i202404259.dawi_t2_quiroz_api.repository;

import com.i202404259.dawi_t2_quiroz_api.entity.Artista;
import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadisticasRepository extends CrudRepository<Cancion, Integer> {

    @Query("SELECT c FROM Cancion c ORDER BY c.numeroReproducciones DESC LIMIT 1")
    Cancion cancionMasReproducida();


    @Query("SELECT a FROM Artista a ORDER BY SIZE(a.canciones) DESC LIMIT 1")
    Artista artistaConMasCanciones();


    @Query("SELECT a.generoMusical, AVG(c.duracionSegundos) " +
            "FROM Cancion c JOIN c.artista a GROUP BY a.generoMusical")
    List<Object[]> promedioDuracionPorGenero();


    @Query("SELECT a.paisOrigen, SUM(c.numeroReproducciones) " +
            "FROM Cancion c JOIN c.artista a GROUP BY a.paisOrigen")
    List<Object[]> totalReproduccionesPorPais();
}

