package ua.zakharov.applicateion.rest_application.exception_handling.exception;

public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
