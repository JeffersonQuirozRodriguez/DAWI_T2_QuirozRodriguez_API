package com.i202404259.dawi_t2_quiroz_api.controller;

import com.i202404259.dawi_t2_quiroz_api.service.EstadisticasService;
import com.i202404259.dawi_t2_quiroz_api.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;
    @Autowired
    private EstadisticasService estadisticasService;

    // Parte A:  Servicio de Consulta por Género
    @GetMapping("/genero/{genero}")
    public Map<String, Object> cancionesPorGenero(@PathVariable String genero) {
        return reporteService.cancionesPorGenero(genero);
    }
    // Parte B:  Servicio de Estadísticas Generales
    @GetMapping("/estadisticas")
    public Map<String, Object> estadisticasGenerales() {
        return estadisticasService.obtenerEstadisticas();
    }
    // Parte C:  Servicio de Top Artistas
    @GetMapping("/top-artistas/{limite}")
    public List<Map<String, Object>> topArtistas(@PathVariable int limite) {
        return reporteService.topArtistas(limite);
    }
}
