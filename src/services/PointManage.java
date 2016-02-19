package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.BadmintonDetail;
import models.BadmintonEvent;
import models.BadmintonMatch;

public class PointManage {
	
	public void addWinPoint(BadmintonDetail dt){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BadmintonJPA" );
	      
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction().begin();
	    BadmintonMatch match = entitymanager.find(BadmintonMatch.class, 1);
	    BadmintonEvent event = entitymanager.find(BadmintonEvent.class, 1);
	    BadmintonDetail detail = new BadmintonDetail();
	    
	    detail.setDetailScrFoeman(0);
	    detail.setDetailScrUs(1);
	    detail.setDetailTime(dt.getDetailTime());
	    detail.setBadmintonMatch(match);
	    detail.setBadmintonEvent(event);
	    
	    entitymanager.persist(detail);
	    entitymanager.getTransaction().commit();

	    entitymanager.close();
	    emfactory.close();

	}
	
	public void addLostPoint(BadmintonDetail dt){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BadmintonJPA" );
	      
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction().begin();
	    BadmintonMatch match = entitymanager.find(BadmintonMatch.class, 1);
	    BadmintonEvent event = entitymanager.find(BadmintonEvent.class, 2);
	    BadmintonDetail detail = new BadmintonDetail();
	    
	    detail.setDetailScrFoeman(1);
	    detail.setDetailScrUs(0);
	    detail.setDetailTime(dt.getDetailTime());
	    detail.setBadmintonMatch(match);
	    detail.setBadmintonEvent(event);
	    
	    entitymanager.persist(detail);
	    entitymanager.getTransaction().commit();

	    entitymanager.close();
	    emfactory.close();

	}
    
}