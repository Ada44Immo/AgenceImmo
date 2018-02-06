package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends Personne{

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	int id;
	
	//relation UML en JAVA	
	//relation client/visite
	@OneToMany(mappedBy="client")
	private List<Visite> listeVisite;
			
	//relation client/classe standard
	@ManyToMany
	@JoinTable(name="client_classestd",joinColumns=@JoinColumn(name="visite_id"),inverseJoinColumns=@JoinColumn(name="client_id"))
	private List<ClasseStandard> listeCs;
			
	//constructeur
	public Client() {
		super();
	}

		
	public Client(Adresse adresse, int tel, String nom) {
		super(adresse, tel, nom);
	}



	public Client(Adresse adresse, int tel, String nom, int id) {
		super(adresse, tel, nom);
		this.id = id;
	}



	//getter et setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Visite> getListeVisite() {
		return listeVisite;
	}

	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}

	public List<ClasseStandard> getListeCs() {
		return listeCs;
	}

	public void setListeCs(List<ClasseStandard> listeCs) {
		this.listeCs = listeCs;
	}
	
	
	
	

}
