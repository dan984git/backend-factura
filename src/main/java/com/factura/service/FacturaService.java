package com.factura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factura.dto.FacturaDTO;
import com.factura.model.Factura;
import com.factura.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<FacturaDTO> getFactura(){
        return facturaRepository.findAll().stream().map(this::convertirEntidadToDTO).collect(Collectors.toList());
    }

    private FacturaDTO convertirEntidadToDTO(Factura factura){
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setFacturaId(factura.getIdFactura());
        facturaDTO.setFacturaNumero(factura.getNumeroFactura());

        return facturaDTO;
    }

    public Factura create(Factura factura){
        return facturaRepository.save(factura);
    }

    public List<Factura> listarFacturas(){
        return facturaRepository.findAll();
    }

    public void eliminarFactura(Factura factura){
        facturaRepository.delete(factura);
    }


    public Factura buscarNumeroFactura(String numFactura){
        List<Factura> lista = facturaRepository.findAll();
        Factura facturaEncontrada = null;
        for(Factura f : lista){
            if(f.getNumeroFactura().equals(numFactura)){
                facturaEncontrada = f;
            }
        }
        return facturaEncontrada;
    }
}
