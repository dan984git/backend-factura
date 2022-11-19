package com.factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, String>{

}
