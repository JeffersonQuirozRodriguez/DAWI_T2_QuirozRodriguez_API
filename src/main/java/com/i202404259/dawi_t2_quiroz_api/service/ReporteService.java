package com.i202404259.dawi_t2_quiroz_api.service;

import com.i202404259.dawi_t2_quiroz_api.entity.Cancion;
import com.i202404259.dawi_t2_quiroz_api.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    // Parte A
    public Map<String, Object> cancionesPorGenero(String genero) {
        List<Cancion> canciones = reporteRepository.findCancionesByGenero(genero);
        Long totalReproducciones = reporteRepository.totalReproduccionesByGenero(genero);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("genero", genero);
        respuesta.put("total_reproducciones", totalReproducciones != null ? totalReproducciones : 0);
        respuesta.put("canciones", canciones);

        return respuesta;
    }
    //Parte C
    public List<Map<String, Object>> topArtistas(int limite) {
        List<Object[]> datos = reporteRepository.topArtistas();
        List<Map<String, Object>> resultado = new ArrayList<>();

        for (int i = 0; i < Math.min(limite, datos.size()); i++) {
            Object[] fila = datos.get(i);
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("artista", fila[0]);
            mapa.put("total_reproducciones", fila[1]);
            resultado.add(mapa);
        }
        return resultado;
    }
}
