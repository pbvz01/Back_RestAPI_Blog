package ua.zakharov.applicateion.rest_application.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.zakharov.applicateion.rest_application.exception_handling.exception.InvalidFormRegistration;
import ua.zakharov.applicateion.rest_application.exception_handling.exception.LoginException;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handlerException(LoginException exp) {
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exp.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handlerException(InvalidFormRegistration exp) {
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exp.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
