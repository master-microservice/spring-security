package nitesh.spring.springsecurity.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static nitesh.spring.springsecurity.authentication.ApplicationUserPermission.*;
import static nitesh.spring.springsecurity.authentication.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index","/welcome", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
//                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
       UserDetails student = User.builder()
               .username("student")
               .password(passwordEncoder.encode("admin"))
//               .roles(STUDENT.name())
               .authorities(STUDENT.getAuthorities())
               .build();

       UserDetails admin = User.builder()
               .username("admin")
               .password(passwordEncoder.encode("admin"))
//               .roles(ADMIN.name())
               .authorities(ADMIN.getAuthorities())
               .build();

       UserDetails tom = User.builder()
               .username("tom")
               .password(passwordEncoder.encode("admin"))
//               .roles(ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE
               .authorities(ADMINTRAINEE.getAuthorities())
               .build();

       UserDetails linda = User.builder()
               .username("linda")
               .password(passwordEncoder.encode("admin"))
//               .roles(ADMIN.name())
               .authorities(ADMIN.getAuthorities())
               .build();


       return new InMemoryUserDetailsManager(
               admin,
               student,
               tom,
               linda
       );
    }
}
