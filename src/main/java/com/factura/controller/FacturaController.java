package com.factura.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.factura.dto.FacturaDTO;
import com.factura.model.Factura;
import com.factura.service.FacturaService;


@RestController
@RequestMapping("/api/factura/")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("factura")
    public List<FacturaDTO> listarPersonaLugar() {
        return facturaService.getFactura();
    }

    @PostMapping("/add")
    private ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
        Factura factura2 = facturaService.create(factura);

        try {
            return ResponseEntity.created(new URI("/api/factura" + factura2.getIdFactura())).body(factura2);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/list")
    private ResponseEntity<List<Factura>> listarFacturas() {
        return ResponseEntity.ok(facturaService.listarFacturas());

    }

    @DeleteMapping("/delete/{numFac}")
    private ResponseEntity<Void> eliminarFactura(@PathVariable("numFac") String numeroFactura) {
        Factura f = facturaService.buscarNumeroFactura(numeroFactura);
        facturaService.eliminarFactura(f);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{numFac}")
    private ResponseEntity<List<Factura>> buscarFactura(@PathVariable("numFac") String numeroFactura) {
        List<Factura> lista = facturaService.listarFacturas();
        List<Factura> listaConsulta = new ArrayList<>();
        for(Factura f: lista){
            if(f.getNumeroFactura().equals(numeroFactura)){
                listaConsulta.add(f);
            }
        }
        return ResponseEntity.ok(listaConsulta);

    }

    @PutMapping("/put/{numFac}")
    public Factura editar(@PathVariable("numFac") String numeroFactura,@RequestBody Factura factura){
        factura.setNumeroFactura(numeroFactura);
        return facturaService.create(factura);
    }

}
