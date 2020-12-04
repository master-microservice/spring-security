package nitesh.spring.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class Welcome {

    @GetMapping
    public String message() {
        return "Welcome to Spring Security";
    }
}
