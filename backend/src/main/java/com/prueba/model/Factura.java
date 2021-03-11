package com.prueba.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_factura;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_cliente", nullable = false)
    private Cliente id_cliente;

    @Column(nullable = false)
    private String fecha;
}
