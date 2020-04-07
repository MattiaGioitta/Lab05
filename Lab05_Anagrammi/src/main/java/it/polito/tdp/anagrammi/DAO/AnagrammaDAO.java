package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.DAO.ConnectDB;

public class AnagrammaDAO {
	public boolean isCorrect(String anagramma) {
		final String sql = "SELECT * FROM parola WHERE nome=?";
		boolean trovata = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				trovata = true;
			}
			
			
			
			conn.close();
		}catch(SQLException e) {
			throw new RuntimeException("Errore nel database!");
		}
		return trovata;
	}

}
