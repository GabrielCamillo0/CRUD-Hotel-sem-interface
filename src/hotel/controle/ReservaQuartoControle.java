
package hotel.controle;
import hotel.dao.Conexao;
import hotel.model.ReservaQuarto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReservaQuartoControle {
    public void inserir(ReservaQuarto reservaQuarto) throws SQLException {
        String sql = "INSERT INTO reserva_quarto (id_quarto) VALUES (?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservaQuarto.getId_Quarto());
            stmt.executeUpdate();
        }
     }
     public void atualizar(ReservaQuarto reservaQuarto) throws SQLException {
        String sql = "UPDATE reserva_quarto SET id_quarto = ?  WHERE id_quarto = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservaQuarto.getId_Quarto());
           
            stmt.executeUpdate();
        }
    }
     public List<ReservaQuarto> listar() throws SQLException {
        List<ReservaQuarto> reservaQuarto = new ArrayList<>();
        String sql = "SELECT * FROM reserva_quarto";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ReservaQuarto ReservaaQuarto = new ReservaQuarto();
                ReservaaQuarto.setId_Quarto(rs.getInt("id_quarto"));
                
                ReservaaQuarto.add(reservaQuarto);
            }
        }
        return reservaQuarto;
    }
     public void apagar(int id_quarto) throws SQLException {
        String sql = "delete from reserva_quarto where id_quarto = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id_quarto);
            stmt.executeUpdate();
        }
    }

    
    
}
