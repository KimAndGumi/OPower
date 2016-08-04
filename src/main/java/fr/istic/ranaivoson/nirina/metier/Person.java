package fr.istic.ranaivoson.nirina.metier;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="PERSON")
@XmlRootElement(name = "person")
public class Person implements Serializable{
	
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private List<Home> homes;
	
	//Constructeur
	public Person(){
		
	}
	public Person(String nom, String prenom, String mail){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		homes = new ArrayList<Home>();
	}
	
	public void setId(int id){
		this.id = id;
	}	
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public void setHomes(List<Home> homes){
		this.homes = new ArrayList<Home>(homes);
	}
	public void addHome(Home home){
		this.homes.add(home);
	}
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSON_ID")
	@XmlElement
	public int getId(){
		return this.id;
	}
	@Column(name="LAST_NAME")
	@XmlElement
	public String getNom(){
		return this.nom;
	}
	@Column(name="FIRST_NAME")
	@XmlElement
	public String getPrenom(){
		return this.prenom;
	}
	@Column(name="MAIL")
	@XmlElement
	public String getMail(){
		return this.mail;
	}
	//@OneToMany(mappedBy="Person")
	@ManyToMany
	@JoinTable(name="Person_home",
	joinColumns=@JoinColumn(name="Person_id", referencedColumnName="Person_id"),
	inverseJoinColumns=@JoinColumn(name="Home_id",referencedColumnName="Home_id"))
	@XmlElement(type=Home.class)
	public List<Home> getHomes(){
		return this.homes;
	}
	
	
}