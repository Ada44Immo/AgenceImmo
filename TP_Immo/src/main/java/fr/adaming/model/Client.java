package fr.adaming.model;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.fabric.xmlrpc.base.Array;

@Entity
@Table(name="clients")
public class Client extends Personne{

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	int id;
	
	//relation UML en JAVA	
	//relation client/visite
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Visite> listeVisite;
			
	//relation client/classe standard
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="client_cstd",joinColumns=@JoinColumn(name="client_id"),inverseJoinColumns=@JoinColumn(name="cstd_id"))
	private List<ClasseStandard> listeCStd=new ArrayList<ClasseStandard>();
	
	
			
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


	public List<ClasseStandard> getListeCStd() {
		return listeCStd;
	}


	public void setListeCStd(List<ClasseStandard> listeCStd) {
		this.listeCStd = listeCStd;
	}


	
	
	
	

}
