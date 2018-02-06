package fr.adaming.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Achat {

	
	// Transformation des associations UML en java
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_p")
	private Proprietaire proprietaire;

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	
	
	
}
