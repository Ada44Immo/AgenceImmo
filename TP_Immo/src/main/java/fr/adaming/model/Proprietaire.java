package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Proprietaire extends Personne implements Serializable {

	@Id
	@Column(name="id_p")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// Transformation des associations UML en Java
	@OneToMany(mappedBy="propietaire")
	private List<Achat> listeAchat;
	
	@OneToMany(mappedBy="propietaire")
	private List<Location> listeLocation;

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
	
	public List<Achat> getListeAchat() {
		return listeAchat;
	}

	public void setListeAchat(List<Achat> listeAchat) {
		this.listeAchat = listeAchat;
	}

	public List<Location> getListeLocation() {
		return listeLocation;
	}

	public void setListeLocation(List<Location> listeLocation) {
		this.listeLocation = listeLocation;
	}

	@Override
	public String toString() {
		return "Proprietaire [id=" + id + "]";
	}
	
}
