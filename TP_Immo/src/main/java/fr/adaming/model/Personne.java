package fr.adaming.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Personne {

	@Embedded 
	private Adresse adresse;
	
	private int tel;
	private String nom;
	
	public Personne() {
		super();
	}

	public Personne(Adresse adresse, int tel, String nom) {
		super();
		this.adresse = adresse;
		this.tel = tel;
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
