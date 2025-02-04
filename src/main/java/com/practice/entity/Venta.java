package com.practice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    
    @Column(nullable = false)
    private Integer idCliente;
    
    @Column(nullable = false)
    private Date feVenta;
    
    @Column(nullable = false)
    private Double imTotal;
    
    @Column(nullable = false)
    private Integer nuItems;
    
    @Column(nullable = false)
    private Integer idUsuario;
    
    @OneToMany(mappedBy = "venta") /*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/
    @JsonManagedReference
    private List<VentaDetalle> detalles;
}

