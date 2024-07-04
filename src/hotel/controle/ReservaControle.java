/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controle;

import hotel.dao.Conexao;
import hotel.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaControle {
   
    public void inserir(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reserva ( numero, check_in, check_out, data_reserva, numero_hospedes, status_pagamento, valor, id_hospede, id_pagamento, id_funcionario) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getNumeroReserva());
            stmt.setDate(2, reserva.getDataCheckin());
            stmt.setDate(3, reserva.getDataCheckout());
            stmt.setDate(4, reserva.getDataReserva());
            stmt.setInt(5, reserva.getNumeroHospedes());
            stmt.setString(6, reserva.getStatusPagamento());
            stmt.setBigDecimal(7, reserva.getValor());
            stmt.setInt(8, reserva.getId_hospede());
            stmt.setInt(9, reserva.getId_pagamento());
            stmt.setInt(10, reserva.getId_funcionario());
            
            stmt.executeUpdate();
        }
        
    }
   

    public void atualizar(Reserva reserva) throws SQLException {
        String sql = "UPDATE reserva SET numero = ?, check_in = ?, check_out = ?, data_reserva = ?, numero_hospedes = ?, status_pagamento = ?, valor = ?, id_hospede = ?, id_pagamento = ?, id_funcionario = ? WHERE id_reserva = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getNumeroReserva());
            stmt.setDate(2, reserva.getDataCheckin());
            stmt.setDate(3, reserva.getDataCheckout());
            stmt.setDate(4, reserva.getDataReserva());
            stmt.setInt(5, reserva.getNumeroHospedes());
            stmt.setString(6, reserva.getStatusPagamento());
            stmt.setBigDecimal(7, reserva.getValor());
            stmt.setInt(8, reserva.getId_hospede());
            stmt.setInt(9, reserva.getId_pagamento());
            stmt.setInt(10,reserva.getId_funcionario() );
            stmt.setInt(11, reserva.getId_reserva());
            stmt.executeUpdate();
        }
    }

    public List<Reserva> listar() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId_reserva(rs.getInt("id_reserva"));
                reserva.setNumeroReserva(rs.getInt("numero"));
                reserva.setDataCheckin(rs.getDate("check_in"));
                reserva.setDataCheckout(rs.getDate("check_out"));
                reserva.setDataReserva(rs.getDate("data_reserva"));
                reserva.setNumeroHospedes(rs.getInt("numero_hospedes"));
                reserva.setStatusPagamento(rs.getString("status_pagamento"));
                reserva.setValor(rs.getBigDecimal("valor"));
                reserva.setId_hospede(rs.getInt("id_hospede"));
                reserva.setId_pagamento(rs.getInt("id_pagamento"));
                reserva.setId_funcionario(rs.getInt("id_funcionario"));
                reservas.add(reserva);
            }
        }
        return reservas;
    }
    public int verificaQuantidadeReservas() throws SQLException {
        int quantidade = 0;
        String sql = "SELECT COUNT(*) AS quantidade_reservas FROM reserva WHERE DATE(data_reserva) = CURRENT_DATE;";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
               
                quantidade = rs.getInt("quantidade_reservas");
              
            }
        }
        return quantidade;
    }
        
    
    
    public void apagar(int id_reserva) throws SQLException {
        String sql = "delete from reserva where id_reserva = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_reserva);
            stmt.executeUpdate();
        }
    }

}
