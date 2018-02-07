package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="visites")
public class Visite implements Serializable {
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	//relation UML en JAVA
	//relation client/visite
	@ManyToOne
	@JoinColumn(name="c_id",referencedColumnName="id")
	private Client client;
	
	//relation visite/bien
	@ManyToOne
	@JoinColumn(name="visite_id_loc",referencedColumnName="id")	
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="visite_id_achat",referencedColumnName="id")		
	private Achat achat;
	
	//relation visite/agent
	@ManyToOne
	@JoinColumn(name="a_id",referencedColumnName="id")
	private Agent agent;
	
	//constructeur
	public Visite() {
		super();
	}


	public Visite(Date date) {
		super();
		this.date = date;
	}


	public Visite(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	//getter et setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public Achat getAchat() {
		return achat;
	}


	public void setAchat(Achat achat) {
		this.achat = achat;
	}



	
	
}
