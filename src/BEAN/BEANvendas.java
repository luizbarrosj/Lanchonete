/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author luizb
 */
public class BEANvendas {
    private int iditens;
    private String tipopag;
    private Timestamp datavenda;
    private int numeropedido;
    private String itensvenda;
    private Double valor;
    private Double valortotal;
    private int vendaqtd;
    private String entregador;
    private int idproduto;

    public int getIditens() {
        return iditens;
    }

    public void setIditens(int iditens) {
        this.iditens = iditens;
    }

    public String getTipopag() {
        return tipopag;
    }

    public void setTipopag(String tipopag) {
        this.tipopag = tipopag;
    }

    public Timestamp getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Timestamp datavenda) {
        this.datavenda = datavenda;
    }

    public int getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(int numeropedido) {
        this.numeropedido = numeropedido;
    }

    public String getItensvenda() {
        return itensvenda;
    }

    public void setItensvenda(String itensvenda) {
        this.itensvenda = itensvenda;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public int getVendaqtd() {
        return vendaqtd;
    }

    public void setVendaqtd(int vendaqtd) {
        this.vendaqtd = vendaqtd;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    
}
