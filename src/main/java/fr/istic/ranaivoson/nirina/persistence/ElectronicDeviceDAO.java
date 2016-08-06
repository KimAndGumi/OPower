package fr.istic.ranaivoson.nirina.persistence;

import java.util.List;
import java.util.ArrayList;
import fr.istic.ranaivoson.nirina.metier.ElectronicDevice;
import javax.persistence.EntityManager;

public class ElectronicDeviceDAO extends EntityManagerHelper{
	
	/*public  void createElectronicDevice(List<ElectronicDevice> electronicDevices){
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
	}*/
	
	public  void create(ElectronicDevice electronicDevice){ //cas où il n'y a qu'un seul nouvel utilisateur
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.persist(electronicDevice);
			commit();
		}catch(Exception re)
		{
			System.out.println("create<ElectronicDevice> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public  List<ElectronicDevice> retrieveAll(){
		List<ElectronicDevice> res = new ArrayList<ElectronicDevice>();
		EntityManager em = getEntityManager();
		try{
			res = em.createQuery("select ed from electronicDevice ed").getResultList();
		}catch(Exception re)
		{
			System.out.println("retrieveAll<ElectronicDevice> went wrong");
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
			System.out.println("retrieve<ElectronicDevice>ById went wrong");
		}finally{
			closeEntityManager();
		}
		return res;
	}
	
	public void update(ElectronicDevice ed){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.merge(ed);
			commit();
		}catch(Exception re)
		{
			System.out.println("update<ElectronicDevice> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
	
	public void delete(ElectronicDevice ed){
		EntityManager em = getEntityManager();
		try{
			beginTransaction();
			em.remove(ed);
			commit();
		}catch(Exception re)
		{
			System.out.println("delete<ElectronicDevice> went wrong");
			rollback();
		}finally{
			closeEntityManager();
		}
	}
}