/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controle;

import hotel.dao.Conexao;
import hotel.model.Funcionario;
import hotel.model.Hospede;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeControle {
     public void inserir(Hospede hospede) throws SQLException {
        String sql = "INSERT INTO hospede (nome, cpf, data_nascimento, telefone, email, endereco) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setDate(3, (Date) hospede.getDataNascimento());          
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());             
            stmt.setString(6, hospede.getEndereco());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Hospede hospede) throws SQLException {
        String sql = "UPDATE hospede SET nome = ?, cpf = ?, data_nascimento  = ?, telefone = ?, email = ?, endereco = ? WHERE id_hospede = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
           stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getCpf());
            stmt.setDate(3, (Date) hospede.getDataNascimento());          
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());             
            stmt.setString(6, hospede.getEndereco());
            stmt.setInt(7, hospede.getId_hospede());
            stmt.executeUpdate();
        }
    }

    public List<Hospede> listar() throws SQLException {
        List<Hospede> hospedes = new ArrayList<>();
        String sql = "SELECT * FROM hospede";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Hospede hospede = new Hospede();
                hospede.setId_hospede(rs.getInt("id_hospede"));
                hospede.setNome(rs.getString("nome"));
                hospede.setCpf(rs.getString("cpf"));
                hospede.setDataNascimento(rs.getDate("data_nascimento"));
                hospede.setTelefone(rs.getString("telefone"));
                hospede.setEmail(rs.getString("email"));
                hospede.setEndereco(rs.getString("endereco"));
                hospedes.add(hospede);
            }
        }
        return hospedes;
    }
    
    
    public void apagar(int id_hospede) throws SQLException {
        String sql = "delete from hospede where id_hospede = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_hospede);
            stmt.executeUpdate();
        }
    }
    
}
