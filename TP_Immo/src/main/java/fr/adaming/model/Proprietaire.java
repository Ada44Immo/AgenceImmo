package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proprietaires")
public class Proprietaire extends Personne {

	@Id
	@Column(name="id_p")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
}
