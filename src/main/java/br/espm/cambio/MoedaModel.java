package br.espm.cambio;

import javax.persistence.Table;

import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;

@Entity
@Table(name = "moeda")
public class MoedaModel {

    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "tx_nome")
    private String txNome;

    @Column(name = "tx_simbolo")
    private String txSimbolo;


}