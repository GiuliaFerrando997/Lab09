package it.polito.tdp.borders.model;

public class Country {
	
	private int CCode;
	private String StateAbb;
	private String StateName;
	public Country(int cCode, String stateAbb, String stateName) {
		super();
		CCode = cCode;
		StateAbb = stateAbb;
		StateName = stateName;
	}
	public int getCCode() {
		return CCode;
	}
	public void setCCode(int cCode) {
		CCode = cCode;
	}
	public String getStateAbb() {
		return StateAbb;
	}
	public void setStateAbb(String stateAbb) {
		StateAbb = stateAbb;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CCode;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (CCode != other.CCode)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return this.StateName;
	}
	
	

}
