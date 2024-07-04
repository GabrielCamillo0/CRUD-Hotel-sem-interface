/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controle;

import hotel.dao.Conexao;
import hotel.model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioControle {
    
   
    
       public void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, data_nascimento, cargo, salario,turno) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setDate(2,(Date) funcionario.getDataNascimento());
            stmt.setString(3, funcionario.getCargo());             
            stmt.setBigDecimal(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getTurno()); 
            stmt.executeUpdate();
        }
    }

    public void atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, data_nascimento = ?, cargo = ?, salario = ?, turno = ? WHERE id_funcionario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setDate(2,(Date) funcionario.getDataNascimento());
            stmt.setString(3, funcionario.getCargo());             
            stmt.setBigDecimal(4, funcionario.getSalario());
            stmt.setString(5, funcionario.getTurno()); 
            stmt.setInt(6, funcionario.getId_fucionario());
            stmt.executeUpdate();
        }
    }

    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_fucionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDataNascimento(rs.getDate("data_nascimento"));          
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getBigDecimal("salario"));
                funcionario.setTurno(rs.getString("turno"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
    
        public void apagar(int id_funcionario) throws SQLException {
        String sql = "delete from funcionario where id_funcionario = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_funcionario);
            stmt.executeUpdate();
        }
    }
}