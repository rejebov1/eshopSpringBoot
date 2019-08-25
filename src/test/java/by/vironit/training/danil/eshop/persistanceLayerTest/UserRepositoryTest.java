package by.vironit.training.danil.eshop.persistanceLayerTest;

import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@ActiveProfiles("persistance-test")
//@DataJpaTest
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void whenNewUserPersisted_thenTheUserRetrieved(){
        User newUser = User.builder()
                .role(User.UserRole.USER)
                .email("test@mail.com")
                .phoneNumber("+375447649200")
                .password(passwordEncoder.encode("stub"))
                .build();

        userRepository.saveAndFlush(newUser);

        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers.contains(newUser)).isTrue();

    }
}
