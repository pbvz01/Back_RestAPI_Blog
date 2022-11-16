package ua.zakharov.applicateion.rest_application.exception_handling.exception;

public class InvalidFormRegistration extends RuntimeException{
    public InvalidFormRegistration(String message) {
        super(message);
    }
}
