package com.practice.service;

import com.practice.entity.Venta;
import com.practice.entity.VentaDetalle;
import java.util.List;
import java.util.Optional;

public interface VentaService {
    List<Venta> listarVentas();
    Venta obtenerVentaPorId(Integer id);
    Venta guardarVenta(Venta venta);
    Venta actualizarVenta(Integer id, Venta venta);
    void eliminarVenta(Integer id);
    List<VentaDetalle> obtenerDetallesDeVenta(Integer idVenta);
    Optional<VentaDetalle> obtenerDetalleEspecifico(Integer idVenta, Integer idVentaDet);
    VentaDetalle guardarDetalle(VentaDetalle detalle);
    void eliminarDetalle(Integer idVentaDet);
}
