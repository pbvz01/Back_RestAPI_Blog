package ua.zakharov.applicateion.rest_application.contoller.request;

import lombok.Data;

@Data
public class AuthorizationRequest {
    private String login;
    private String password;
}
