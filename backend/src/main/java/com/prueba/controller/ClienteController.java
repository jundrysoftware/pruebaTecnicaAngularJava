package com.prueba.controller;

import com.prueba.exception.ResourceNotFoundException;
import com.prueba.model.Cliente;
import com.prueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @PostMapping("/cliente")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    public Cliente updateCliente(@PathVariable(value = "id") Long clienteId,
                                   @Valid @RequestBody Cliente clienteDetails) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("cliente", "id_cliente", clienteId));

        cliente.setApellido(clienteDetails.getApellido());
        cliente.setDireccion(clienteDetails.getDireccion());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setNombre(clienteDetails.getNombre());
        Cliente updatedCliente = clienteRepository.save(cliente);
        return updatedCliente;
    }
}
