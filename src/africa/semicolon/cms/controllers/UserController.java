package africa.semicolon.cms.controllers;

import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.AllContactResponse;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.exceptions.UserExistsException;
import africa.semicolon.cms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
@Autowired
    public UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            var serviceResponse = userService.register(registerRequest);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (UserExistsException err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/user")
    public ContactResponse addContact(@RequestBody ContactRequest contactRequest) {
        return userService.addContact(contactRequest);
    }

    @GetMapping("/user/{emails}")
    public List<AllContactResponse> findContactsBelongingTo(@PathVariable("emails") String email) {
        return userService.findContactsBelongingTo(email);
    }
}
