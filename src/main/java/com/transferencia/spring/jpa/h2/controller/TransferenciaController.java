package com.transferencia.spring.jpa.h2.controller;

import com.transferencia.spring.jpa.h2.dominio.CalculoTaxas;
import com.transferencia.spring.jpa.h2.model.Transferencia;
import com.transferencia.spring.jpa.h2.repository.TransferenciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
// @CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TransferenciaController {

    Logger logger = LoggerFactory.getLogger(TransferenciaController.class);

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @GetMapping("/transferencias")
    public ResponseEntity<List<Transferencia>> getAllTransferencia(@RequestParam(required = false) String contaDeOrigem) {
        try {
            List<Transferencia> transferencias = new ArrayList<Transferencia>();
            // List<Transferencia> tutorials = transferenciaRepository.findAll();

            // logger.info("An before "+ tutorials.toString());
            if (contaDeOrigem == null) {
                logger.info("An before find");
                transferenciaRepository.findAll().forEach(transferencias::add);
                logger.info(transferencias.toString());
                System.out.println(transferencias);
            } else {
                transferenciaRepository.findBycontaDeOrigemContainingIgnoreCase(contaDeOrigem).forEach(transferencias::add);
                //     transferenciaRepository.findAll().forEach(transferencias::add);
            }
            if (transferencias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            logger.info("An INFO Message");
            System.out.println(transferencias);
            return new ResponseEntity<>(transferencias, HttpStatus.OK);
        } catch (Exception e) {
            logger.info(String.valueOf(e));
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/transferencia/{id}")
    public ResponseEntity<Transferencia> getTransferencaById(@PathVariable("id") long id) {
        Optional<Transferencia> transferencaData = transferenciaRepository.findById(id);

        if (transferencaData.isPresent()) {
            return new ResponseEntity<>(transferencaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees") /* teste de busca*/
    public List<Transferencia> getAllEmployees() {
        return transferenciaRepository.findAll();
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Transferencia> createTransferencia(@RequestBody Transferencia transferencia) {
        var teste = new CalculoTaxas();
        var result = teste.CalculoTaxas(Float.parseFloat(transferencia.getValorTrasferencia()), transferencia.getDataTrasferencia().substring(0, 2));
        System.out.println(result);
        try {
            Transferencia _transferencia = transferenciaRepository.save(new Transferencia(transferencia.getContaDeOrigem(), transferencia.getContaDeDestino(), transferencia.getValorTrasferencia(), transferencia.getDataTrasferencia(), transferencia.getDataAgendamento(), String.valueOf(result)));
            return new ResponseEntity<>(_transferencia, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/transferencia/{id}")
    public ResponseEntity<Transferencia> deleteTransferencia(@PathVariable("id") long id) {
        try {
            transferenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/transferencia/{id}")
    Transferencia replaceTransferencia(@RequestBody Transferencia newTransferencia, @PathVariable Long id) {

        var teste = new CalculoTaxas();
        var result = teste.CalculoTaxas(Float.parseFloat(newTransferencia.getValorTrasferencia()), newTransferencia.getDataTrasferencia().substring(0, 2));

        return transferenciaRepository.findById(id).map(transferencia -> {
            transferencia.setContaDeOrigem(newTransferencia.getContaDeOrigem());
            transferencia.setContaDeDestino(newTransferencia.getContaDeOrigem());
            transferencia.setValorTrasferencia(newTransferencia.getValorTrasferencia());
            transferencia.setTaxa(String.valueOf(result));
            return transferenciaRepository.save(transferencia);
        }).orElseGet(() -> {
            newTransferencia.setId(id);
            return transferenciaRepository.save(newTransferencia);
        });
    }
}
