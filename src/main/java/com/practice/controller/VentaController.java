package com.practice.controller;

import com.practice.entity.Venta;
import com.practice.entity.VentaDetalle;
import com.practice.service.VentaService;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ventas")
@Tag(name = "Ventas", description = "Ventas  API")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Operation(summary = "Obtener todo las venta", description = "Devuelve todo las venta")
    @ApiResponse(responseCode = "200", description = "Ventas obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron ventas")
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @Operation(summary = "Obtener  venta por ID", description = "Devuelve venta por ID")
    @ApiResponse(responseCode = "200", description = "Venta obtenidas correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró la venta")
    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Integer id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @Operation(summary = "Crear una venta", description = "Crea  una  venta")
    @ApiResponse(responseCode = "200", description = "Venta creado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo crear la venta")
    @PostMapping
    public Venta guardarVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @Operation(summary = "Actualiza una venta", description = "Actualiza  una venta por ID")
    @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo actualizar la venta")
    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        Venta ventaActualizada = ventaService.actualizarVenta(id, venta);
        return ResponseEntity.ok(ventaActualizada);
    }

    @Operation(summary = "Elimina una venta por ID", description = "Elimina una venta por ID")
    @ApiResponse(responseCode = "200", description = "Venta eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró la venta")
    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Integer id) {
        ventaService.eliminarVenta(id);
    }

    @Operation(summary = "Obtener  detalle de venta por ID", description = "Devuelve detalle de venta por ID")
    @ApiResponse(responseCode = "200", description = "Detalle de venta obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el detalle de venta")
    @GetMapping("/{id}/detalles")
    public List<VentaDetalle> obtenerDetallesDeVenta(@PathVariable Integer id) {
        return ventaService.obtenerDetallesDeVenta(id);
    }

    @Operation(summary = "Obtener  detalle de venta por ID", description = "Devuelve el detalle de venta por ID")
    @ApiResponse(responseCode = "200", description = "Detalle de venta obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el detalle de venta")
    @GetMapping("/{id}/detalles/{detalleId}")
    public Optional<VentaDetalle> obtenerDetalleEspecifico(@PathVariable Integer id, @PathVariable Integer detalleId) {
        return ventaService.obtenerDetalleEspecifico(id, detalleId);
    }

    @Operation(summary = "Crear un detalle de venta", description = "Crea  un  detalle de venta")
    @ApiResponse(responseCode = "200", description = "Detalle de venta creado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo crear el detalle de venta")
    @PostMapping("/{id}/detalles")
    public VentaDetalle agregarDetalle(@PathVariable Integer id, @RequestBody VentaDetalle detalle) {
        detalle.setVenta(new Venta(id, null, null, null, null, null, null));
        return ventaService.guardarDetalle(detalle);
    }

    @Operation(summary = "Actualiza el detalle de venta", description = "Actualiza  un detalle de venta por ID")
    @ApiResponse(responseCode = "200", description = "Detalle de venta actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo actualizar el detalle de venta")
    @PutMapping("/{id}/detalles/{detalleId}")
    public VentaDetalle actualizarDetalle(@PathVariable Integer id, @PathVariable Integer detalleId, @RequestBody VentaDetalle detalle) {
        detalle.setIdVentaDet(detalleId);
        detalle.setVenta(new Venta(id, null, null, null, null, null, null));
        return ventaService.guardarDetalle(detalle);
    }

    @Operation(summary = "Elimina un detalle de venta por ID", description = "Elimina un detalle de venta por ID")
    @ApiResponse(responseCode = "200", description = "Detalle de venta eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró el cliente")
    @DeleteMapping("/{id}/detalles/{detalleId}")
    public void eliminarDetalle(@PathVariable Integer detalleId) {
        ventaService.eliminarDetalle(detalleId);
    }
}
