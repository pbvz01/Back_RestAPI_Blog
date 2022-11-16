package ua.zakharov.applicateion.rest_application.contoller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.zakharov.applicateion.rest_application.configuration.jwt.TokenProvider;
import ua.zakharov.applicateion.rest_application.contoller.request.AuthorizationRequest;
import ua.zakharov.applicateion.rest_application.contoller.request.RegistrationRequest;
import ua.zakharov.applicateion.rest_application.contoller.response.AuthorizationResponse;
import ua.zakharov.applicateion.rest_application.exception_handling.exception.InvalidFormRegistration;
import ua.zakharov.applicateion.rest_application.model.User;
import ua.zakharov.applicateion.rest_application.service.UserService;

@RestController
@CrossOrigin
public class AuthorizationController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/registration")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest,
                             BindingResult bindingResult) {
        System.out.println(registrationRequest);
        if (bindingResult.hasErrors()) {
            throw new InvalidFormRegistration("Trouble with validation for fields");
        }
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setLogin(registrationRequest.getLogin());
        userService.save(user);
        return "Ok";
    }

    @PostMapping("/sign-in")
    public AuthorizationResponse auth(@RequestBody AuthorizationRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = tokenProvider.generateToken(user.getLogin());
        return new AuthorizationResponse(token);
    }
}


