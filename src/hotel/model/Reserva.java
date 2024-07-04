/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Reserva {
    private int id_quarto;
    private int id_reserva;
    private int id_hospede;
    private int id_pagamento;
    private int id_funcionario;
    private Date dataCheckin;
    private Date dataCheckout;
    private Date dataReserva = new Date(new java.util.Date().getTime());
    private String statusPagamento;
    private int numeroReserva;
    private int numeroHospedes;
    private BigDecimal valor;
    

    

    
    public Date getDataCheckin() {
        return dataCheckin;
    }

    /**
     * @param dataCheckin the dataCheckin to set
     */
    public void setDataCheckin(Date dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    /**
     * @return the dataCheckout
     */
    public Date getDataCheckout() {
        return dataCheckout;
    }

    /**
     * @param dataCheckout the dataCheckout to set
     */
    public void setDataCheckout(Date dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    /**
     * @return the dataReserva
     */
    public Date getDataReserva() {
        return dataReserva;
    }

    /**
     * @param dataReserva the dataReserva to set
     */
    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    /**
     * @return the status
     */
    public String getStatusPagamento() {
        return statusPagamento;
    }

    /**
     * @param statusPagamento
     */
    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    /**
     * @return the numeroReserva
     */
    public int getNumeroReserva() {
        return numeroReserva;
    }

    /**
     * @param numeroReserva the numeroReserva to set
     */
    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    /**
     * @return the numeroHospedes
     */
    public int getNumeroHospedes() {
        return numeroHospedes;
    }

    /**
     * @param numeroHospedes the numeroHospedes to set
     */
    public void setNumeroHospedes(int numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the id_reserva
     */
    public int getId_reserva() {
        return id_reserva;
    }

    /**
     * @param id_reserva the id_reserva to set
     */
    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    /**
     * @return the id_hospede
     */
    public int getId_hospede() {
        return id_hospede;
    }

    /**
     * @param id_hospede the id_hospede to set
     */
    public void setId_hospede(int id_hospede) {
        this.id_hospede = id_hospede;
    }

    /**
     * @return the id_pagamento
     */
    public int getId_pagamento() {
        return id_pagamento;
    }

    /**
     * @param id_pagamento the id_pagamento to set
     */
    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the metodoPagamento
     */
    
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
