package by.vironit.training.danil.eshop.service;

import by.vironit.training.danil.eshop.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional(readOnly = true)
    User getById(Long id);

    @Transactional(readOnly = true)
    User getByEmail(String email);

    @Transactional(readOnly = true)
    User getCurrentUser();

    @Transactional
    User updateUser(User userDTO);

    @Transactional(readOnly = true)
    String getCurrentUsername();

    @Transactional
    void addNewUser(User user);

    @Transactional
    User updateUserProfile(User user);


    User updateUserPassword(User user);

    @Transactional
    void deleteUser(Long id);

    @Transactional(readOnly = true)
    List<User> getAll();

    @Transactional
    void blockUser(Long id);

    @Transactional
    void unblockUser(Long id);


    /*boolean isEmailExist(String email);*/
}
