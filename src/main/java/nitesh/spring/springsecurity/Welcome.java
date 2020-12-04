package nitesh.spring.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/welcome")
@RestController
public class Welcome {

    @GetMapping
    public String message() {
        return "Welcome to Spring Security";
    }
}