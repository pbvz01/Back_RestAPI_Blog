package ua.zakharov.applicateion.rest_application.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ua.zakharov.applicateion.rest_application.model.User;
import ua.zakharov.applicateion.rest_application.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);
        if(user == null) {
            throw new UsernameNotFoundException("username not found exp");
        }
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}


