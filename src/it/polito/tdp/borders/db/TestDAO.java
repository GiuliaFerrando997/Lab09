package it.polito.tdp.borders.db;

import java.util.List;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Border;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();

		System.out.println("Lista dei confini:");
		List<Border> borders = dao.getCountryPairs(2002);
		for (Border c : borders)
		System.out.println(c.getState1no()+" "+c.getState2no());
	}
}
