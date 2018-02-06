package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="achats")
public class Achat extends Bien implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double prix;
	private String etat;
	
	public Achat() {
		super();
	}
	
	
	

	public Achat(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, byte[] photo, double prix, String etat,
			Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface, photo);
		this.prix = prix;
		this.etat = etat;
		this.proprietaire = proprietaire;
	}




	public Achat(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, byte[] photo, int id, double prix, String etat,
			Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface, photo);
		this.id = id;
		this.prix = prix;
		this.etat = etat;
		this.proprietaire = proprietaire;
	}
	
	




	public Achat(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, int id, double prix, String etat, Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface);
		this.id = id;
		this.prix = prix;
		this.etat = etat;
		this.proprietaire = proprietaire;
	}


	public Achat(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, double prix, String etat, Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface);
		this.prix = prix;
		this.etat = etat;
		this.proprietaire = proprietaire;
	}

	// Transformation des associations UML en java
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_p")
	private Proprietaire proprietaire;
	
	@OneToOne
	@JoinColumn(name="acquereur_id", referencedColumnName="id_a")
	private Acquereur acquereur;
	
	@OneToMany(mappedBy="achat")
	private List<Visite> listeVisite;
	
	@ManyToOne
	@JoinColumn(name="cStd_id", referencedColumnName="idCode")
	private ClasseStandard cStd;
	
	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	


	public Acquereur getAcquereur() {
		return acquereur;
	}




	public void setAcquereur(Acquereur acquereur) {
		this.acquereur = acquereur;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public double getPrix() {
		return prix;
	}




	public void setPrix(double prix) {
		this.prix = prix;
	}




	public String getEtat() {
		return etat;
	}




	public void setEtat(String etat) {
		this.etat = etat;
	}




	public List<Visite> getListeVisite() {
		return listeVisite;
	}




	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}




	public ClasseStandard getcStd() {
		return cStd;
	}




	public void setcStd(ClasseStandard cStd) {
		this.cStd = cStd;
	}
	
	
	
	
}
