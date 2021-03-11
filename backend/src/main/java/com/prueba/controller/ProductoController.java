package com.prueba.controller;

import com.prueba.exception.ResourceNotFoundException;
import com.prueba.model.Producto;
import com.prueba.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductoController {
    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/producto")
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @PostMapping("/producto")
    public Producto createProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/producto/{id}")
    public Producto updateProducto(@PathVariable(value = "id") Long productoId,
                                 @Valid @RequestBody Producto productoetails) {

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("producto", "id_producto", productoId));

        producto.setPrecio(productoetails.getPrecio());
        producto.setNombre(productoetails.getNombre());
        producto.setStock(productoetails.getStock());
        Producto updatedProducto = productoRepository.save(producto);
        return updatedProducto;
    }
}
