package com.practice.controller;

import com.practice.entity.Venta;
import com.practice.entity.VentaDetalle;
import com.practice.service.VentaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Integer id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @PostMapping
    public Venta guardarVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta ventaActualizada = ventaService.actualizarVenta(id, venta);
        return ResponseEntity.ok(ventaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Integer id) {
        ventaService.eliminarVenta(id);
    }

    @GetMapping("/{id}/detalles")
    public List<VentaDetalle> obtenerDetallesDeVenta(@PathVariable Integer id) {
        return ventaService.obtenerDetallesDeVenta(id);
    }

    @GetMapping("/{id}/detalles/{detalleId}")
    public Optional<VentaDetalle> obtenerDetalleEspecifico(@PathVariable Integer id, @PathVariable Integer detalleId) {
        return ventaService.obtenerDetalleEspecifico(id, detalleId);
    }

    @PostMapping("/{id}/detalles")
    public VentaDetalle agregarDetalle(@PathVariable Integer id, @RequestBody VentaDetalle detalle) {
        detalle.setVenta(new Venta(id, null, null, null, null, null, null));
        return ventaService.guardarDetalle(detalle);
    }

    @PutMapping("/{id}/detalles/{detalleId}")
    public VentaDetalle actualizarDetalle(@PathVariable Integer id, @PathVariable Integer detalleId, @RequestBody VentaDetalle detalle) {
        detalle.setIdVentaDet(detalleId);
        detalle.setVenta(new Venta(id, null, null, null, null, null, null));
        return ventaService.guardarDetalle(detalle);
    }

    @DeleteMapping("/{id}/detalles/{detalleId}")
    public void eliminarDetalle(@PathVariable Integer detalleId) {
        ventaService.eliminarDetalle(detalleId);
    }
}
