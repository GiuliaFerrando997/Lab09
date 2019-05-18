package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private BordersDAO dao;
	private Map<Integer, Country> countryMap;
	private Graph<Country, DefaultEdge> grafo;
	private List<Country> paesi;
	private List<Border> borders;
	

	public Model() {
	 this.dao=new BordersDAO();
	 this.countryMap=new HashMap<>();
	 this.borders=new ArrayList<>();
	 this.paesi=new ArrayList<>();
	 
	}
	
	public void creaGrafo(int anno) {
		this.grafo=new SimpleGraph<>(DefaultEdge.class);
		this.paesi=dao.loadAllCountries(countryMap);
		Graphs.addAllVertices(this.grafo, this.paesi);
		this.borders=dao.getCountryPairs(anno);
		for(Border b : borders) {
			this.grafo.addEdge(countryMap.get(b.getState1no()), countryMap.get(b.getState2no()));
		}
		
	}

	public Map<Country, Integer> getConfini() {
		Map<Country, Integer> statiConfinanti = new HashMap<>();
		for(Country c : this.grafo.vertexSet()) {
			statiConfinanti.put(c, grafo.degreeOf(c));
		}
		return statiConfinanti;
	}
	
	public int componentiConnesse() {
		ConnectivityInspector ci = new ConnectivityInspector(this.grafo);
		return ci.connectedSets().size();
	}

}
