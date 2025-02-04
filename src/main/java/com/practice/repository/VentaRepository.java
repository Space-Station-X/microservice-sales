package com.practice.repository;
import com.practice.entity.Venta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByIdCliente(Integer idCliente);
    List<Venta> findByFeVenta(Date feVenta);
}
