/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.model;

import java.math.BigDecimal;

public class QuartoReserva {
    private int id_quarto;
    
   
    private String tipo;
    
    private int tipoQuartoId;
    private int quantidade;
    private BigDecimal precoTotal;
    private int numeroQuarto;
    private int andarQuarto;
    private int ocupacaoMaxima;

   

   
    
    public int getTipoQuartoId() {
        return tipoQuartoId;
    }

    public void setTipoQuartoId(int tipoQuarto) {
        this.tipoQuartoId = tipoQuarto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    /**
     * @return the numeroQuarto
     */
    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    /**
     * @param numeroQuarto the numeroQuarto to set
     */
    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    /**
     * @return the andarQuarto
     */
    public int getAndarQuarto() {
        return andarQuarto;
    }

    /**
     * @param andarQuarto the andarQuarto to set
     */
    public void setAndarQuarto(int andarQuarto) {
        this.andarQuarto = andarQuarto;
    }

    /**
     * @return the ocupacaoMaxima
     */
    public int getOcupacaoMaxima() {
        return ocupacaoMaxima;
    }

    /**
     * @param ocupacaoMaxima the ocupacaoMaxima to set
     */
    public void setOcupacaoMaxima(int ocupacaoMaxima) {
        this.ocupacaoMaxima = ocupacaoMaxima;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id_quarto
     */
    public int getId_quarto() {
        return id_quarto;
    }

    /**
     * @param id_quarto the id_quarto to set
     */
    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }
    
    
}
