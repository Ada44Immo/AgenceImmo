package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * La classe Propietaire herite de la classe personne et ajoute comme attribut un entier id. 
 * C'est une classe persistante. 
 * 
 * @author intiformation
 *
 */
@Entity
@Table(name="proprietaires")
public class Proprietaire extends Personne {

	@Id
	@Column(name="id_p")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public Proprietaire() {
		super();
	}

	public Proprietaire(Adresse adresse, int tel, String nom) {
		super(adresse, tel, nom);
	}

	public Proprietaire(Adresse adresse, int tel, String nom, int id) {
		super(adresse, tel, nom);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Proprietaire [id=" + id + "]";
	}
	
}
