package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.*;
import javax.persistence.EntityManager;
//import static fr.istic.ranaivoson.nirina.persistence.EntityManageHelper;

public class HomeDAO extends EntityManagerHelper{
	
	//private EntityManagerHelper emh;
	public void createHome(List<Home> homes){
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
	}
	
	public void createHome(Home home){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(home);
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
	
	public List<Home> retrieveAll(){
		List<Home> res = new ArrayList<Home>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select p from Home p").getResultList();
			
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
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
			//System.out.println("Something went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}
	//pas de delete, pas d'update pour le moment ?
}