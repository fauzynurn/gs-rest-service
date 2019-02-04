package hello;

import guest.Guest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class GreetingService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(Guest guest) {
        em.persist(guest);
    }
}
