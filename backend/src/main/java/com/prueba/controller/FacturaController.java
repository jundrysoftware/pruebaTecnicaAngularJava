package com.prueba.controller;

import com.prueba.model.Factura;
import com.prueba.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FacturaController {
    @Autowired
    FacturaRepository facturaRepository;

    @GetMapping("/factura")
    public List<Factura> getAllFactura() {
        return facturaRepository.findAll();
    }

    @PostMapping("/factura")
    public Factura createFactura(@Valid @RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }
}
