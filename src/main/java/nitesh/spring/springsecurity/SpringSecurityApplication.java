package nitesh.spring.springsecurity;

import nitesh.spring.springsecurity.authentication.ApplicationUserPermission;
import nitesh.spring.springsecurity.authentication.ApplicationUserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
