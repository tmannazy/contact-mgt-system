package africa.semicolon.cms.services;

import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterRequest registerRequest);

    int numberOfUsers();
}
