package com.practice.service.impl;

import com.practice.entity.Venta;
import com.practice.entity.VentaDetalle;
import com.practice.exceptions.SalesNotFoundException;
import com.practice.repository.VentaDetalleRepository;
import com.practice.repository.VentaRepository;
import com.practice.service.VentaService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final VentaDetalleRepository ventaDetalleRepository;

    public VentaServiceImpl(VentaRepository ventaRepository, VentaDetalleRepository ventaDetalleRepository) {
        this.ventaRepository = ventaRepository;
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta actualizarVenta(Integer id, Venta venta) {
        Venta ventaExistente = ventaRepository.findById(id)
                .orElseThrow(() -> new SalesNotFoundException("Venta no encontrada con ID: " + id));

        // Actualizar los campos permitidos
        if (venta.getIdCliente() != null) {
            ventaExistente.setIdCliente(venta.getIdCliente());
        }
        if (venta.getFeVenta() != null) {
            ventaExistente.setFeVenta(venta.getFeVenta());
        }
        if (venta.getImTotal() != null) {
            ventaExistente.setImTotal(venta.getImTotal());
        }
        if (venta.getNuItems() != null) {
            ventaExistente.setNuItems(venta.getNuItems());
        }
        if (venta.getIdUsuario() != null) {
            ventaExistente.setIdUsuario(venta.getIdUsuario());
        }

        return ventaRepository.save(ventaExistente);
    }

    @Override
    public void eliminarVenta(Integer id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public List<VentaDetalle> obtenerDetallesDeVenta(Integer idVenta) {
        return ventaDetalleRepository.findByVentaIdVenta(idVenta);
    }

    @Override
    public Optional<VentaDetalle> obtenerDetalleEspecifico(Integer idVenta, Integer idVentaDet) {
        return ventaDetalleRepository.findByIdVentaDetAndVenta_IdVenta(idVentaDet, idVenta);
    }

    @Override
    public VentaDetalle guardarDetalle(VentaDetalle detalle) {
        return ventaDetalleRepository.save(detalle);
    }

    @Override
    public void eliminarDetalle(Integer idVentaDet) {
        ventaDetalleRepository.deleteById(idVentaDet);
    }
}
