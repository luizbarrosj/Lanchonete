/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;
import java.time.LocalDate;
/**
 *
 * @author luizb
 */
public class BEANproduto {
    private int idproduto;
    private String produto;
    private LocalDate datavenda;
    private LocalDate horavenda;
    private String valor;


    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public LocalDate getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(LocalDate datavenda) {
        this.datavenda = datavenda;
    }

    public LocalDate getHoravenda() {
        return horavenda;
    }

    public void setHoravenda(LocalDate horavenda) {
        this.horavenda = horavenda;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
