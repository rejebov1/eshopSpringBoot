package by.vironit.training.danil.eshop.service.serviceImpl;

import by.vironit.training.danil.eshop.model.User;
import by.vironit.training.danil.eshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    @Autowired
    UserService userService;


    public User getUserByEmail(String email) {
        return userService.getByEmail(email);
    }

    public Set<GrantedAuthority> getRole(User user) {
        Set<GrantedAuthority> roles = new HashSet<>();
        if (user instanceof User) {
            roles.add(new SimpleGrantedAuthority("USER"));
        }
        return roles;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getUserByEmail(email);
        if (user == null) {
            logger.info("user with email " + email + " not found");
            throw new UsernameNotFoundException("user with email" + email + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getRole(user));
    }
}
