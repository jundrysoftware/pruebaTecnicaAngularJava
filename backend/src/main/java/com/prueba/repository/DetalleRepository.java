package com.prueba.repository;

import com.prueba.model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository  extends JpaRepository<Detalle,Long> {
}
