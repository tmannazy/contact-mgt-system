package africa.semicolon.cms.utils;

import africa.semicolon.cms.data.models.User;
import africa.semicolon.cms.dtos.requests.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest registerRequest, User newUserToAdd) {
        newUserToAdd.setEmail(registerRequest.getEmail());
        newUserToAdd.setLastName(registerRequest.getLastName());
        newUserToAdd.setFirstName(registerRequest.getFirstName());
        newUserToAdd.setPin(registerRequest.getPin());
    }
}
