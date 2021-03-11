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
@Table(name = "detalle")
public class Detalle  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_detalle;

    @ManyToOne
    @JoinColumn(columnDefinition = "num_factura", nullable = false)
    private Factura num_factura;

    @ManyToOne
    @JoinColumn(columnDefinition = "id_producto", nullable = false)
    private Producto id_producto;

    @Column(nullable = false)
    private Long cantidad;

    @Column(nullable = false)
    private Double precio;
}
