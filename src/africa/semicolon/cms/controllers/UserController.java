package africa.semicolon.cms.controllers;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.AllContactResponse;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.services.UserService;
import africa.semicolon.cms.services.UserServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    public UserService userService = new UserServiceImpl();

    @PostMapping("/user")
    public RegisterUserResponse registerUser(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    @PatchMapping("/user")
    public ContactResponse addContact(@RequestBody ContactRequest contactRequest) {
        return userService.addContact(contactRequest);
    }

    @GetMapping("/user/{emails}")
    public List<AllContactResponse> findContactBelongingTo(@PathVariable("emails") String email) {
        return userService.findContactsBelongingTo(email);
    }
}
