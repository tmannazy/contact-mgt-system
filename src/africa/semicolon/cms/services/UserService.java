package africa.semicolon.cms.services;

import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.AllContactResponse;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse register(RegisterRequest registerRequest);

    int numberOfUsers();

    ContactResponse addContact(ContactRequest contactRequest);

    void deleteContact(String contact);

    List<AllContactResponse> findContactsBelongingTo(String email);
}
