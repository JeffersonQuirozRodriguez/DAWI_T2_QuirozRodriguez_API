package com.i202404259.dawi_t2_quiroz_api.service;

import com.i202404259.dawi_t2_quiroz_api.entity.Artista;
import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import com.i202404259.dawi_t2_quiroz_api.repository.EstadisticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EstadisticasService {

    @Autowired
    private EstadisticasRepository estadisticasRepository;

    public Map<String, Object> obtenerEstadisticas() {
        Map<String, Object> resultado = new HashMap<>();

        Cancion masReproducida = estadisticasRepository.cancionMasReproducida();
        Artista artistaMasCanciones = estadisticasRepository.artistaConMasCanciones();
        List<Object[]> promedioPorGenero = estadisticasRepository.promedioDuracionPorGenero();
        List<Object[]> totalPorPais = estadisticasRepository.totalReproduccionesPorPais();

        resultado.put("cancion_mas_reproducida", masReproducida);
        resultado.put("artista_mas_canciones", artistaMasCanciones);

        Map<String, Double> promediosMap = new HashMap<>();
        for (Object[] fila : promedioPorGenero) {
            promediosMap.put((String) fila[0], (Double) fila[1]);
        }
        resultado.put("promedio_duracion_por_genero", promediosMap);

        Map<String, Long> reproduccionesPorPais = new HashMap<>();
        for (Object[] fila : totalPorPais) {
            reproduccionesPorPais.put((String) fila[0], (Long) fila[1]);
        }
        resultado.put("total_reproducciones_por_pais", reproduccionesPorPais);

        return resultado;
    }
}