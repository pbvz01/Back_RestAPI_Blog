package ua.zakharov.applicateion.rest_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.zakharov.applicateion.rest_application.exception_handling.exception.LoginException;
import ua.zakharov.applicateion.rest_application.model.Role;
import ua.zakharov.applicateion.rest_application.model.User;
import ua.zakharov.applicateion.rest_application.repository.RoleRepository;
import ua.zakharov.applicateion.rest_application.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        if(findByLogin(user.getLogin()) == null) {
            Role role = roleRepository.findByName("ROLE_USER");
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        throw new LoginException("An user was created with this login");
    }
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        return passwordEncoder.matches(password, user.getPassword()) ? user : null;
    }

}


