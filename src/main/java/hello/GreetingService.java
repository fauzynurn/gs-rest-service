package hello;

import guest.Guest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class GreetingService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(Guest guest) {
        em.persist(guest);
    }

    public List<Guest> getAllGuests() {
        TypedQuery<Guest> query = em.createQuery(
                "SELECT g FROM Guest g", Guest.class);
        return query.getResultList();
    }
}
