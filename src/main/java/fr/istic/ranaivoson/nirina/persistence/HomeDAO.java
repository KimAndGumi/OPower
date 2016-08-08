package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.Home;
import fr.istic.ranaivoson.nirina.persistence.EntityManagerHelper;
import javax.persistence.EntityManager;

public class HomeDAO extends EntityManagerHelper{
	
	/*public void create(List<Home> homes){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			for (Home p:homes){
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
	}*/
	
	public void create(Home home){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(home);
			commit();
		}catch(Exception re)
		{
			System.out.println("create<Home> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public List<Home> retrieveAll(){
		List<Home> res = new ArrayList<Home>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select h from Home h").getResultList();
		}catch(Exception re)
		{
			System.out.println("retrieveAll<Home> went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}

	public Home retrieveById(int id){
		Home res = new Home();
		EntityManager em = getEntityManager();
		try{
			res = em.find(Home.class,id);
		}catch(Exception re)
		{
			System.out.println("retrieve<Home>ById went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}

	public void update(Home h){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.merge(h);
			commit();
		}catch(Exception re)
		{
			System.out.println("update<Home> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public void delete(Home h){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.remove(h);
			commit();
		}catch(Exception re)
		{
			System.out.println("delete<Home> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
}