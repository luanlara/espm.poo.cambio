package br.espm.cambio;

import java.util.Date;
import java.util.UUID;

public class Cotacao {
    
    private UUID id;
    private UUID idMoeda;
    private Date data;
    private double valor;

    public Cotacao(){
    }

    public Cotacao(UUID idMoeda, Date data, double valor){
        this.idMoeda = idMoeda;
        this.data = data;
        this.valor = valor;
    }

    public Cotacao(double valor) {
        this.valor = valor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setIdMoeda(UUID idMoeda) {
        this.idMoeda = idMoeda;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdMoeda() {
        return idMoeda;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}