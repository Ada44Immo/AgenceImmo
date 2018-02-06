package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classestandard")
public class ClasseStandard {

	//les attributs de la classe
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCode;
	private String type;
	private boolean modeOffre;
	private double prixMax;
	private double surfaceMin;
	
	//Transformation des associations UML en java
	@ManyToMany(mappedBy="listeCStd")
	private List<Client> listeClient;	
	
	@OneToMany(mappedBy="location")
	private List<Location> listeLocation;
	
	@OneToMany(mappedBy="achat")
	private List<Achat> listeAchat;
	
	//constructeur vide
	public ClasseStandard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructeur avec arguments
	public ClasseStandard(String type, boolean modeOffre, double prixMax, double surfaceMin) {
		super();
		this.type = type;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.surfaceMin = surfaceMin;
	}

	public ClasseStandard(int idCode, String type, boolean modeOffre, double prixMax, double surfaceMin) {
		super();
		this.idCode = idCode;
		this.type = type;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.surfaceMin = surfaceMin;
	}

	//les getters et setters
	public int getIdCode() {
		return idCode;
	}

	public void setIdCode(int idCode) {
		this.idCode = idCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isModeOffre() {
		return modeOffre;
	}

	public void setModeOffre(boolean modeOffre) {
		this.modeOffre = modeOffre;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public double getSurfaceMin() {
		return surfaceMin;
	}

	public void setSurfaceMin(double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}



	public List<Location> getListeLocation() {
		return listeLocation;
	}

	public void setListeLocation(List<Location> listeLocation) {
		this.listeLocation = listeLocation;
	}

	public List<Achat> getListeAchat() {
		return listeAchat;
	}

	public void setListeAchat(List<Achat> listeAchat) {
		this.listeAchat = listeAchat;
	}	
	
	
	
	
	
	
	
}
