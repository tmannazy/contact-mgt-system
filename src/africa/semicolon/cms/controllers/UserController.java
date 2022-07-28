package africa.semicolon.cms.controllers;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.services.UserService;
import africa.semicolon.cms.services.UserServiceImpl;

import java.util.List;

public class UserController {

    public UserService userService = new UserServiceImpl();

    public RegisterUserResponse registerUser(RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    public ContactResponse addContact(ContactRequest contactRequest) {
        return userService.addContact(contactRequest);
    }

    public List<Contact> findContactBelongingTo(String email) {
        return userService.findContactsBelongingTo(email);
    }
}
