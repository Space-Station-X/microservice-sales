package com.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("saleDetailId")
    private Integer idVentaDet;
    
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    @JsonBackReference
    @JsonProperty("sale")
    private Venta venta;
    
    @Column(nullable = false)
    @JsonProperty("videoGameId")
    private Integer idVideoJuego;
    
    @Column(nullable = false)
    @JsonProperty("quantity")
    private Integer nuCantidad;
    
    @Column(nullable = false)
    @JsonProperty("salePrice")
    private Double imPrecioVenta;
    
    @Column(nullable = false)
    @JsonProperty("totalAmount")
    private Double imTotal;
}
