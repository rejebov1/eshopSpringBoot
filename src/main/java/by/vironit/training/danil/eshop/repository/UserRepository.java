package by.vironit.training.danil.eshop.repository;

import by.vironit.training.danil.eshop.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByEmail(String email);
    /*boolean isEmailExist(String email);*/
}
