package it.polito.tdp.borders.model;

import java.util.Map;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("TestModel -- TODO");
		
		System.out.println("Creo il grafo relativo al 2002");
		model.creaGrafo(2002);
		
		Map<Country, Integer> statiConfinanti = model.getConfini();
		for(Country c : statiConfinanti.keySet()) {
			System.out.println(c.getStateName()+" "+statiConfinanti.get(c));
		}

		System.out.format("Numero componenti connesse: %d\n", model.componentiConnesse());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}
	
	// 713463

}
