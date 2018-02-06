package fr.adaming.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Lob;

public abstract class Bien {
	
	//attribut
	private String statut;
	private Date dateDispo;
	private Date dateMiseEnGerance;
	@Embedded 
	private Adresse adresse;
	private String description;
	private double revenuCasdastral;
	private double surface;
	@Lob
	private byte[] photo;
	
	//constructeur
	public Bien() {
		super();
	}

	public Bien(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface, byte[] photo) {
		super();
		this.statut = statut;
		this.dateDispo = dateDispo;
		this.dateMiseEnGerance = dateMiseEnGerance;
		this.adresse = adresse;
		this.description = description;
		this.revenuCasdastral = revenuCasdastral;
		this.surface = surface;
		this.photo = photo;
	}

	public Bien(String statut, Date dateDispo, Date dateMiseEnGerance, Adresse adresse, String description,
			double revenuCasdastral, double surface) {
		super();
		this.statut = statut;
		this.dateDispo = dateDispo;
		this.dateMiseEnGerance = dateMiseEnGerance;
		this.adresse = adresse;
		this.description = description;
		this.revenuCasdastral = revenuCasdastral;
		this.surface = surface;
	}
	
	//getter et setter
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	public Date getDateMiseEnGerance() {
		return dateMiseEnGerance;
	}

	public void setDateMiseEnGerance(Date dateMiseEnGerance) {
		this.dateMiseEnGerance = dateMiseEnGerance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRevenuCasdastral() {
		return revenuCasdastral;
	}

	public void setRevenuCasdastral(double revenuCasdastral) {
		this.revenuCasdastral = revenuCasdastral;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	

}
