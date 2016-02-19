package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.BadmintonMatch;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "BadmintonJPA" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );

	      BadmintonMatch match = new BadmintonMatch( ); 
	      
	      match.setMatchName("Arm Kengpohnsakul");
	      match.setMatchHcolR(0);
	      match.setMatchHcolG(0);
	      match.setMatchHcolB(0);
	      match.setMatchLcolR(0);
	      match.setMatchLcolG(0);
	      match.setMatchLcolB(0);
	      match.setMatchId(1);
	      entitymanager.persist( match );
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	      emfactory.close( );
		
	}

}
