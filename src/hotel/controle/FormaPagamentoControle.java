
package hotel.controle;
import hotel.dao.Conexao;
import hotel.model.FormaPagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class FormaPagamentoControle {
     public void inserir(FormaPagamento formaPagamento) throws SQLException {
        String sql = "INSERT INTO forma_pagamento (metodo_pagamento) VALUES (?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, formaPagamento.getMetodoPagamento());
            stmt.executeUpdate();
        }
     }
     public void atualizar(FormaPagamento formaPagamento) throws SQLException {
        String sql = "UPDATE forma_pagamento SET metodo_pagamento = ?  WHERE id_pagamento = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, formaPagamento.getMetodoPagamento());
           
            stmt.executeUpdate();
        }
    }
     public List<FormaPagamento> listar() throws SQLException {
        List<FormaPagamento> formaPagamentos = new ArrayList<>();
        String sql = "SELECT * FROM forma_pagamento";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setMetodoPagamento(rs.getString("metodo_pagamento"));
                
                formaPagamentos.add(formaPagamento);
            }
        }
        return formaPagamentos;
    }
     public void apagar(int id_pagamento) throws SQLException {
        String sql = "delete from forma_pagamento where id_pagamento = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_pagamento);
            stmt.executeUpdate();
        }
    }
}

