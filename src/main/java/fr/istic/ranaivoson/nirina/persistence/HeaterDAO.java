package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.Heater;
import fr.istic.ranaivoson.nirina.persistence.EntityManagerHelper;
import javax.persistence.EntityManager;

public class HeaterDAO extends EntityManagerHelper{
	
	/*public  void createHeater(List<Heater> heaters){
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
	}*/
	
	public  void create(Heater heater){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(heater);
			commit();
		}catch(Exception re)
		{
			System.out.println("create<Heater> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public  List<Heater> retrieveAll(){
		List<Heater> res = new ArrayList<Heater>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select h from Heater h").getResultList();
		}catch(Exception re)
		{
			System.out.println("retrieveAll<Heater> went wrong");
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
			System.out.println("retrieve<Heater>ById went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}
	
	public void update(Heater h){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.merge(h);
			commit();
		}catch(Exception re)
		{
			System.out.println("update<Heater> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public void delete(Heater h){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.remove(h);
			commit();
		}catch(Exception re)
		{
			System.out.println("delete<Heater> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
}