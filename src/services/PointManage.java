package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.BmtDetail;
import models.BmtEvent;
import models.BmtMatch;

public class PointManage {
	
	public void addWinPoint(BmtDetail dt){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BadmintonJPA" );
	      
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction().begin();
	    BmtMatch match = entitymanager.find(BmtMatch.class, 1);
	    BmtEvent event = entitymanager.find(BmtEvent.class, 1);
	    BmtDetail detail = new BmtDetail();
	    
	    detail.setDetailScrFoeman(0);
	    detail.setDetailScrUs(1);
	    detail.setDetailTime(dt.getDetailTime());
	    detail.setBmtMatch(match);
	    detail.setBmtEvent(event);
	    
	    entitymanager.persist(detail);
	    entitymanager.getTransaction().commit();

	    entitymanager.close();
	    emfactory.close();

	}
	
	public void addLostPoint(BmtDetail dt){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BadmintonJPA" );
	      
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction().begin();
	    BmtMatch match = entitymanager.find(BmtMatch.class, 1);
	    BmtEvent event = entitymanager.find(BmtEvent.class, 2);
	    BmtDetail detail = new BmtDetail();
	    
	    detail.setDetailScrFoeman(1);
	    detail.setDetailScrUs(0);
	    detail.setDetailTime(dt.getDetailTime());
	    detail.setBmtMatch(match);
	    detail.setBmtEvent(event);
	    
	    entitymanager.persist(detail);
	    entitymanager.getTransaction().commit();

	    entitymanager.close();
	    emfactory.close();

	}
    
}