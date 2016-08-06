package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.Person;
import javax.persistence.EntityManager;

public class PersonDAO extends EntityManagerHelper{
	
	/*public  void create(List<Person> persons){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			for (Person p:persons){
				em.persist(p);
			}
			commit();
		}catch(Exception re)
		{
			System.out.println("create<List<Person>> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}*/
	
	public  void create(Person person){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(person);
			commit();
		}catch(Exception re)
		{
			System.out.println("create<Person> went wrong");
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
			System.out.println("retrieveAll<Person> went wrong");
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
			System.out.println("retrieve<Person>ById went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}
	
	public void update(Person p){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.merge(p);
			commit();
		}catch(Exception re)
		{
			System.out.println("update<Person> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public void delete(Person p){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.remove(p);
			commit();
		}catch(Exception re)
		{
			System.out.println("delete<Person> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public void deleteById(int id){
		delete(retrieveById(id));
	}
}