package ch.hevs.bookshelf;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
public class BookBean {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED, name = "BookPU")
	private EntityManager em; 

}
