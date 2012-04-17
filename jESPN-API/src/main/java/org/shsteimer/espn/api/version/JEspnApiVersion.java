package org.shsteimer.espn.api.version;

public enum JEspnApiVersion {
	VERSION1("v1");
	
	private String value;
	JEspnApiVersion(String value) {
		this.value=value;
	}
	
	public String value(){
		return value;
	}

}
