package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {

	@Id
	@Column(name="id_r")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String rolename;
	
	private int ag_id;
	
	public Role() {
		super();
	}

	public Role(int id, String rolename, int ag_id) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.ag_id = ag_id;
	}



	public int getAg_id() {
		return ag_id;
	}

	public void setAg_id(int ag_id) {
		this.ag_id = ag_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getRolename() {
		return rolename;
	}



	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	

}
