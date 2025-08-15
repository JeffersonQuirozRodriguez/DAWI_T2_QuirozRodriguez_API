package com.i202404259.dawi_t2_quiroz_api.repository;

import com.i202404259.dawi_t2_quiroz_api.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

}
