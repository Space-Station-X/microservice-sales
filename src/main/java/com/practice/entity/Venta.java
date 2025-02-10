package com.practice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("saleId")
    private Integer idVenta;
    
    @Column(nullable = false)
    @JsonProperty("customerId")
    private Integer idCliente;
    
    @Column(nullable = false)
    @JsonProperty("saleDate")
    private Date feVenta;
    
    @Column(nullable = false)
    @JsonProperty("totalAmount")
    private Double imTotal;
    
    @Column(nullable = false)
    @JsonProperty("itemCount")
    private Integer nuItems;
    
    @Column(nullable = false)
    @JsonProperty("userId")
    private Integer idUsuario;
    
    @OneToMany(mappedBy = "venta") /*, cascade = CascadeType.ALL, fetch = FetchType.LAZY*/
    @JsonManagedReference
    @JsonProperty("saleDetails")
    private List<VentaDetalle> detalles;
}