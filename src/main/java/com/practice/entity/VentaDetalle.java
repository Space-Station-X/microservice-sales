package com.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ventas_det")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVentaDet;
    
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    @JsonBackReference
    private Venta venta;
    
    @Column(nullable = false)
    private Integer idVideoJuego;
    
    @Column(nullable = false)
    private Integer nuCantidad;
    
    @Column(nullable = false)
    private Double imPrecioVenta;
    
    @Column(nullable = false)
    private Double imTotal;
}