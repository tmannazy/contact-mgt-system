package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.models.User;
import africa.semicolon.cms.data.repositories.UserRepository;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.exceptions.UserExistsException;
import africa.semicolon.cms.utils.Mapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private RegisterUserResponse uResponse = new RegisterUserResponse();
    private final ContactService contactService;

    public UserServiceImpl(UserRepository userRepository, ContactService contactService) {
        this.userRepository = userRepository;
        this.contactService = contactService;
    }

    @Override
    public RegisterUserResponse register(RegisterRequest registerRequest) throws UserExistsException {
        validateUser(registerRequest);
        User newUserToAdd = new User();
        Mapper.map(registerRequest, newUserToAdd);
        userRepository.saveUser(newUserToAdd);
        uResponse.getMessage();
        return uResponse;
    }

    private void validateUser(RegisterRequest registerRequest) {
        var savedUser = userRepository.findByEmail(registerRequest.getEmail());
        if (savedUser != null) {
            throw new UserExistsException("User with " + registerRequest.getEmail() + " already exists.");
        }
    }

    @Override
    public int numberOfUsers() {
        return userRepository.count();
    }

    @Override
    public ContactResponse addContact(ContactRequest contactRequest) {
        var user = userRepository.findByEmail(contactRequest.getUserEmail());
        if (user == null) {
            throw new UserExistsException("User with " + contactRequest.getUserEmail() + " not found.");
        }
        var savedContact = contactService.saveContact(contactRequest);
        user.getContacts().add(savedContact);
        userRepository.saveUser(user);
        return null;
    }

    @Override
    public void deleteContact(String contact) {
    }

    @Override
    public List<Contact> findContactsBelongingTo(String email) {
        var user = userRepository.findByEmail(email);
        return user.getContacts();
    }


}
