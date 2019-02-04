package hello;

import java.util.concurrent.atomic.AtomicLong;

import guest.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService service;

    @PostMapping("/greeting")
    public String saveSomething(HttpServletResponse res, @RequestBody String name) {
        service.persist(new Guest(name));
        return "Hello, "+name;
    }
}
