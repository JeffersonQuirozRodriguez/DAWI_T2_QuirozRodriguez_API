package com.i202404259.dawi_t2_quiroz_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cancion")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion")
    private Integer idCancion;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "duracion_segundos")
    private Integer duracionSegundos;

    @Column(name = "fecha_lanzamiento")
    private LocalDate fechaLanzamiento;

    @Column(name = "numero_reproducciones")
    private Integer numeroReproducciones;


    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(Integer duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getNumeroReproducciones() {
        return numeroReproducciones;
    }

    public void setNumeroReproducciones(Integer numeroReproducciones) {
        this.numeroReproducciones = numeroReproducciones;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
