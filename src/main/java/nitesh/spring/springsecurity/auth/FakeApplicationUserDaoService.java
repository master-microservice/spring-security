package nitesh.spring.springsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static nitesh.spring.springsecurity.security.ApplicationUserRole.*;

@Repository("Fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
              new ApplicationUser(
                      "student",
                      passwordEncoder.encode("admin"),
                      STUDENT.getAuthorities(),
                      true,
                      true,
                      true,
                      true
              ),
              new ApplicationUser(
                      "admin",
                      passwordEncoder.encode("admin"),
                      ADMIN.getAuthorities(),
                      true,
                      true,
                      true,
                      true
              ),
              new ApplicationUser(
                      "trainee",
                      passwordEncoder.encode("admin"),
                      ADMINTRAINEE.getAuthorities(),
                      true,
                      true,
                      true,
                      true
              )
        );
        return applicationUsers;
    }
}
