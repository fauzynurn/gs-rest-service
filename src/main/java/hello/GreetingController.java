package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guest.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService service;

    @PostMapping("/greeting")
    public String saveSomething(HttpServletResponse res, @RequestBody String name) {
        service.persist(new Guest(name));
        return "Hello, "+name;
    }

    @GetMapping("/getAllGuests")
    public String getAllGuests() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Guest> list = service.getAllGuests();
        return mapper.writeValueAsString(list);
    }
}
