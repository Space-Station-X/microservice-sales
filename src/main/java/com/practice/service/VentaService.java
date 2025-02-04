package com.practice.service;

import com.practice.entity.Venta;
import com.practice.entity.VentaDetalle;
import java.util.List;
import java.util.Optional;

public interface VentaService {
    public List<Venta> listarVentas();
    public Venta obtenerVentaPorId(Integer id);
    public Venta guardarVenta(Venta venta);
    public Venta actualizarVenta(Integer id, Venta venta);
    public void eliminarVenta(Integer id);
    public List<VentaDetalle> obtenerDetallesDeVenta(Integer idVenta);
    public Optional<VentaDetalle> obtenerDetalleEspecifico(Integer idVenta, Integer idVentaDet);
    public VentaDetalle guardarDetalle(VentaDetalle detalle);
    public void eliminarDetalle(Integer idVentaDet);
}
