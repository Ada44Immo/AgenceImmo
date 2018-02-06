package fr.adaming.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String rue;
	private String num;
	private int cp;
	private String localite;
	private String pays;
	
	public Adresse() {
		super();
	}

	public Adresse(String rue, String num, int cp, String localite, String pays) {
		super();
		this.rue = rue;
		this.num = num;
		this.cp = cp;
		this.localite = localite;
		this.pays = pays;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
}
