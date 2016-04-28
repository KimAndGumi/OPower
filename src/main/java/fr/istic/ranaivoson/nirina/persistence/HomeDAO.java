package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.*;
import javax.persistence.EntityManager;
//import static fr.istic.ranaivoson.nirina.persistence.EntityManageHelper;

public class HomeDAO /*extends EntityManagerHelper*/{
	
	private EntityManagerHelper emh;
	public void createHome(List<Home> homes){
		EntityManager em = emh.getEntityManager();
		try{
			emh.beginTransaction();
			for (Home p:homes){
				em.persist(p);
			}
			emh.commit();
		}catch(Exception re)
		{
			//if(tx!=null)
				//System.out.println("Something went wrong");
			emh.rollback();
		}finally{
			emh.closeEntityManager();
		}
	}
	
	public void createHome(Home home){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = emh.getEntityManager();
		try{
			emh.beginTransaction();
			em.persist(home);
			emh.commit();
		}catch(Exception re)
		{
			//if(tx!=null)
				//System.out.println("Something went wrong");
			emh.rollback();
		}finally{
			emh.closeEntityManager();
		}
	}
	
	public List<Home> retrieveAll(){
		List<Home> res = new ArrayList<Home>();
		EntityManager em = emh.getEntityManager();
		try{
			res = em.createQuery("select p from Home p").getResultList();
			
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
		}finally{
			emh.closeEntityManager();
		}
		return res;
	}

	public Home retrieveById(int id){
		Home res = new Home();
		EntityManager em = emh.getEntityManager();
		try{
			res = em.find(Home.class,id);
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
		}finally{
			emh.closeEntityManager();
		}
		return res;
	}
	//pas de delete, pas d'update pour le moment ?
}