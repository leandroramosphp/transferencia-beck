package com.transferencia.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transferencia")
public class Transferencia {


    public Transferencia(String contaDeOrigem, String contaDeDestino, String valorTrasferencia, String dataTrasferencia, String dataAgendamento, String taxa) {
        this.contaDeOrigem = contaDeOrigem;
        this.contaDeDestino = contaDeDestino;
        this.valorTrasferencia = valorTrasferencia;
        this.dataTrasferencia = dataTrasferencia;
        this.dataAgendamento = dataAgendamento;
        this.taxa = taxa;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "conta_origem")
    private String contaDeOrigem;

    @Column(name = "conta_destino")
    private String contaDeDestino;

    @Column(name = "valor_transferencia")
    private String valorTrasferencia;

    @Column(name = "data_transferencia")
    private String dataTrasferencia;

    @Column(name = "data_agendamento")
    private String dataAgendamento;



    @Column(name = "taxa_transferencia")
    private String taxa;

    public Transferencia(){}
    public Transferencia(long id, String contaDeOrigem, String contaDeDestino, String valorTrasferencia, String dataTrasferencia, String dataAgendamento, String taxa) {
        this.id = id;
        this.contaDeOrigem = contaDeOrigem;
        this.contaDeDestino = contaDeDestino;
        this.valorTrasferencia = valorTrasferencia;
        this.dataTrasferencia = dataTrasferencia;
        this.dataAgendamento = dataAgendamento;
        this.taxa = taxa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContaDeOrigem() {
        return contaDeOrigem;
    }

    public void setContaDeOrigem(String contaDeOrigem) {
        this.contaDeOrigem = contaDeOrigem;
    }

    public String getContaDeDestino() {
        return contaDeDestino;
    }

    public void setContaDeDestino(String contaDeDestino) {
        this.contaDeDestino = contaDeDestino;
    }

    public String getValorTrasferencia() {
        return valorTrasferencia;
    }

    public void setValorTrasferencia(String valorTrasferencia) {
        this.valorTrasferencia = valorTrasferencia;
    }

    public String getDataTrasferencia() {
        return dataTrasferencia;
    }

    public void setDataTrasferencia(String dataTrasferencia) {
        this.dataTrasferencia = dataTrasferencia;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "contaDeOrigem='" + contaDeOrigem + '\'' +
                ", contaDeDestino='" + contaDeDestino + '\'' +
                ", valorTrasferencia='" + valorTrasferencia + '\'' +
                ", dataTrasferencia='" + dataTrasferencia + '\'' +
                ", dataAgendamento='" + dataAgendamento + '\'' +
                '}';
    }

}
