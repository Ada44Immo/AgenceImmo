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
@Table(name = "locations")
public class Location extends Bien implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double caution;
	private double loyer;
	private double charge;
	private String bail;
	private boolean garniture;

	public Location() {
		super();
	}

	public Location(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, byte[] photo, double caution, double loyer, double charge,
			String bail, boolean garniture, Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface, photo);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
		this.proprietaire = proprietaire;
	}

	public Location(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, double caution, double loyer, double charge, String bail,
			boolean garniture, Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
		this.proprietaire = proprietaire;
	}

	public Location(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, int id, double caution, double loyer, double charge, String bail,
			boolean garniture, Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface);
		this.id = id;
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
		this.proprietaire = proprietaire;
	}

	public Location(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, byte[] photo, int id, double caution, double loyer, double charge,
			String bail, boolean garniture, Proprietaire proprietaire) {
		super(statut, dateDispo, dateMiseEnGerance, adresse, description, revenuCasdastral, surface, photo);
		this.id = id;
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
		this.proprietaire = proprietaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getBail() {
		return bail;
	}

	public void setBail(String bail) {
		this.bail = bail;
	}

	public boolean isGarniture() {
		return garniture;
	}

	public void setGarniture(boolean garniture) {
		this.garniture = garniture;
	}

	// Transformation des associations UML en java
	@ManyToOne
	@JoinColumn(name = "proprietaire_id", referencedColumnName = "id_p")
	private Proprietaire proprietaire;

	@OneToOne
	@JoinColumn(name = "acquereur_id", referencedColumnName = "id_a")
	private Acquereur acquereur;

	@OneToMany(mappedBy="location")
	private List<Visite> listeVisite;
	
	@ManyToOne
	@JoinColumn(name="cStd_id", referencedColumnName="idCode")
	private ClasseStandard cStd;
	
	
	
	public ClasseStandard getcStd() {
		return cStd;
	}

	public void setcStd(ClasseStandard cStd) {
		this.cStd = cStd;
	}

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

	public List<Visite> getListeVisite() {
		return listeVisite;
	}

	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}
	
	
}
