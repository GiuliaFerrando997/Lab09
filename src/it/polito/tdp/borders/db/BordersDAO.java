package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries(Map<Integer, Country> paesi) {

		String sql = "SELECT ccode, StateAbb, StateNme FROM country ORDER BY StateAbb";
		List<Country> result = new ArrayList<Country>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				if(paesi.get(rs.getInt("ccode"))==null) {
				Country c = new Country(rs.getInt("ccode"),
						rs.getString("StateAbb"),
						rs.getString("StateNme"));
				paesi.put(rs.getInt("ccode"), c);
				}
				result.add(paesi.get(rs.getInt("ccode")));
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		List<Border> borders = new ArrayList<>();
		String sql = "SELECT state1no, state2no, year FROM contiguity WHERE YEAR <=? && conttype='1'";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Border c = new Border(rs.getInt("state1no"),
						rs.getInt("state2no"),
						rs.getInt("year"));
				if(!borders.contains(c)) {
				borders.add(c);
				}
			}
			
			conn.close();
			return borders;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}
}
