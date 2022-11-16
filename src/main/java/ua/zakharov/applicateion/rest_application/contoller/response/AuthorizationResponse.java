package ua.zakharov.applicateion.rest_application.contoller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationResponse {
    private String token;
}
