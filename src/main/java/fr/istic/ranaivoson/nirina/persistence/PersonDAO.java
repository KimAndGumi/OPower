package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.*;
import javax.persistence.EntityManager;
//import fr.istic.ranaivoson.nirina.persistence.EntityManageHelper;

public class PersonDAO extends EntityManagerHelper{
	
	//private EntityManagerHelper emh;
	public  void createPerson(List<Person> persons){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			for (Person p:persons){
				em.persist(p);
			}
			commit();
		}catch(Exception re)
		{
			//if(tx!=null)
				//System.out.println("Something went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public  void createPerson(Person person){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(person);
			commit();
		}catch(Exception re)
		{
			//if(tx!=null)
				//System.out.println("Something went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public  List<Person> retrieveAll(){
		List<Person> res = new ArrayList<Person>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select p from Person p").getResultList();
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}

	public  Person retrieveById(int id){
		Person res = new Person();
		EntityManager em = getEntityManager();
		try{
			res = em.find(Person.class,id);
			return res;
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}
	//pas de delete, pas d'update pour le moment ?
}