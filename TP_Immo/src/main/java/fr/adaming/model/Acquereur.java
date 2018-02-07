package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="acquereurs")
public class Acquereur extends Personne implements Serializable {

	@Id
	@Column(name="id_a")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private double prix;
	
	@Temporal(TemporalType.DATE)
	private Date dateAchat;
	
	// Transformation des associations UML en java
	@OneToOne(mappedBy="acquereur")
	private Achat achat;
	
	@OneToOne(mappedBy="acquereur")
	private Location location;
	
	// Constructeurs
	public Acquereur() {
		super();
	}

	public Acquereur(Adresse adresse, int tel, String nom, double prix, Date dateAchat) {
		super(adresse, tel, nom);
		this.prix = prix;
		this.dateAchat = dateAchat;
	}

	public Acquereur(Adresse adresse, int tel, String nom, int id, double prix, Date dateAchat) {
		super(adresse, tel, nom);
		this.id = id;
		this.prix = prix;
		this.dateAchat = dateAchat;
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

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	public Achat getAchat() {
		return achat;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Acquereur [id=" + id + ", prix=" + prix + ", dateAchat=" + dateAchat + "]";
	}
	
}
