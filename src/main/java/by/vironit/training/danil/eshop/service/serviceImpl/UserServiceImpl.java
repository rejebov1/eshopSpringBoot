package by.vironit.training.danil.eshop.service.serviceImpl;

import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.repository.UserRepository;
import by.vironit.training.danil.eshop.service.UserService;
import by.vironit.training.danil.eshop.service.details.AppUserDetails;
import by.vironit.training.danil.eshop.service.details.DaoList;
import by.vironit.training.danil.eshop.service.dto.converterDTO.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DaoList daoList;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /*public boolean isEmailExist(String email){
        return userRepository.isEmailExist(email);
    }*/

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        User user = daoList.getUserRepository().getOne(id);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        User user = daoList.getUserRepository().getByEmail(email);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }


    @Override
    @Transactional
    public void blockUser(Long id){
        User user = daoList.getUserRepository().getOne(id);
        user.setIsActive(false);
    }

    @Override
    @Transactional
    public void unblockUser(Long id){
        User user = daoList.getUserRepository().getOne(id);
        user.setIsActive(true);
    }


    @Override
    @Transactional(readOnly = true)
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AppUserDetails) {
            Long userId = ((AppUserDetails) principal).getUserId();
            return getById(userId);
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AppUserDetails) {
            Long userId = ((AppUserDetails) principal).getUserId();
            return getById(userId).getFullName();
        } else {
            return principal.toString();
        }
    }

    @Override
    @Transactional
    public User updateUser(User userDTO){
        userDTO.setOrders(daoList.getUserRepository().getOne(userDTO.getId()).getOrders());
        return daoList.getUserRepository().save(userDTO);
    }

    @Override
    @Transactional
    public void addNewUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        daoList.getUserRepository().save(user);

    }


    @Override
    @Transactional
    public User updateUserProfile(User user) {
        daoList.getUserRepository().findById(user.getId());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setFullName(user.getFullName());

        return user;
    }

    @Override
    @Transactional
    public User updateUserPassword(User user) {
        daoList.getUserRepository().findById(user.getId());
        user.setPassword(user.getPassword());
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        daoList.getUserRepository().deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        List<User> users = daoList.getUserRepository().findAll();
        return new ArrayList<>(users);
    }

}
