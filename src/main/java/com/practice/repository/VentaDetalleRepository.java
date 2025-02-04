package com.practice.repository;
import com.practice.entity.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Integer> {
    List<VentaDetalle> findByVentaIdVenta(Integer idVenta);
    Optional<VentaDetalle> findByIdVentaDetAndVenta_IdVenta(Integer idVentaDet, Integer idVenta);
}
