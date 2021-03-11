package com.prueba.controller;

import com.prueba.model.Detalle;
import com.prueba.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DetalleController {
    @Autowired
    DetalleRepository detalleRepository;

    @GetMapping("/detalle")
    public List<Detalle> getAllDetalle() {
        return detalleRepository.findAll();
    }

    @PostMapping("/detalle")
    public Detalle createDetalle(@Valid @RequestBody Detalle detalle) {
        return detalleRepository.save(detalle);
    }
}
