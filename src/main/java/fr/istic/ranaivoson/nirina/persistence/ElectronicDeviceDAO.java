package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.*;
import javax.persistence.EntityManager;
//import fr.istic.ranaivoson.nirina.persistence.EntityManageHelper;

public class ElectronicDeviceDAO extends EntityManagerHelper{
	
	//private EntityManagerHelper emh;
	public  void createElectronicDevice(List<ElectronicDevice> electronicDevices){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			for (ElectronicDevice p:electronicDevices){
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
	
	public  void createElectronicDevice(ElectronicDevice electronicDevice){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(electronicDevice);
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
	
	public  List<ElectronicDevice> retrieveAll(){
		List<ElectronicDevice> res = new ArrayList<ElectronicDevice>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select p from electronicDevice p").getResultList();
		}catch(Exception re)
		{
			//System.out.println("Something went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}

	public  ElectronicDevice retrieveById(int id){
		ElectronicDevice res = new ElectronicDevice();
		EntityManager em = getEntityManager();
		try{
			res = em.find(ElectronicDevice.class,id);
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