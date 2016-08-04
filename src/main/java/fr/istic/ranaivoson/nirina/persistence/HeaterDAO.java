package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.*;
import javax.persistence.EntityManager;
//import fr.istic.ranaivoson.nirina.persistence.EntityManageHelper;

public class HeaterDAO extends EntityManagerHelper{
	
	//private EntityManagerHelper emh;
	public  void createHeater(List<Heater> heaters){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			for (Heater p:heaters){
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
	
	public  void createHeater(Heater heater){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(heater);
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
	
	public  List<Heater> retrieveAll(){
		List<Heater> res = new ArrayList<Heater>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select p from Heater p").getResultList();
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}

	public  Heater retrieveById(int id){
		Heater res = new Heater();
		EntityManager em = getEntityManager();
		try{
			res = em.find(Heater.class,id);
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