package com.transferencia.spring.jpa.h2.repository;

import com.transferencia.spring.jpa.h2.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
      //  List<Transferencia> findById(long id);

        List<Transferencia> findBycontaDeOrigemContainingIgnoreCase(String contaDeOrigem);


    }

