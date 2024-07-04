/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controle;

import hotel.dao.Conexao;
import hotel.model.QuartoReserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuartoReservaControle {

    public void inserir(QuartoReserva quartoDaReserva) throws SQLException {
        String sql = "INSERT INTO quarto (numero, tipo, andar, ocupacao_maxima) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quartoDaReserva.getNumeroQuarto());
            stmt.setString(2, quartoDaReserva.getTipo());
            stmt.setInt(3, quartoDaReserva.getAndarQuarto());
            stmt.setInt(4, quartoDaReserva.getOcupacaoMaxima());
            stmt.executeUpdate();
        }
    }

    public void atualizar(QuartoReserva quartoDaReserva) throws SQLException {
        String sql = "UPDATE quarto SET numero = ?, tipo = ?, andar = ?, ocupacao_maxima = ? WHERE id_quarto = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quartoDaReserva.getNumeroQuarto());
            stmt.setString(2, quartoDaReserva.getTipo());
            stmt.setInt(3, quartoDaReserva.getAndarQuarto());
            stmt.setInt(4, quartoDaReserva.getOcupacaoMaxima());
            stmt.setInt(5, quartoDaReserva.getId_quarto());
            stmt.executeUpdate();
        }
    }

    public List<QuartoReserva> listar() throws SQLException {
        List<QuartoReserva> quartosDaReserva = new ArrayList<>();
        String sql = "SELECT * FROM quarto";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                QuartoReserva quartoDaReserva = new QuartoReserva();
                quartoDaReserva.setId_quarto(rs.getInt("id_quarto"));
                quartoDaReserva.setNumeroQuarto(rs.getInt("numero"));
                quartoDaReserva.setTipo(rs.getString("tipo"));
                quartoDaReserva.setAndarQuarto(rs.getInt("andar"));
                quartoDaReserva.setOcupacaoMaxima(rs.getInt("ocupacao_maxima"));
                quartosDaReserva.add(quartoDaReserva);
            }
        }
        return quartosDaReserva;
    }

    public void apagar(int id_quarto) throws SQLException {
        String sql = "delete from quarto where id_quarto = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_quarto);
            stmt.executeUpdate();
        }
    }

}
