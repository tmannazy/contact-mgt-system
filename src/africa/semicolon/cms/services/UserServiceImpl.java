package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.models.User;
import africa.semicolon.cms.data.repositories.ContactRepository;
import africa.semicolon.cms.data.repositories.ContactRepositoryImpl;
import africa.semicolon.cms.data.repositories.UserRepository;
import africa.semicolon.cms.data.repositories.UserRepositoryImpl;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.AllContactResponse;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.exceptions.UserExistsException;
import africa.semicolon.cms.utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private RegisterUserResponse uResponse = new RegisterUserResponse();
    private final ContactService contactService;

    public UserServiceImpl(UserRepository userRepository, ContactService contactService) {
        this.userRepository = userRepository;
        this.contactService = contactService;
    }

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        ContactRepository contactRepository = new ContactRepositoryImpl();
        this.contactService = new ContactServiceImpl(contactRepository);

    }

    @Override
    public RegisterUserResponse register(RegisterRequest registerRequest) throws UserExistsException {
        validateUser(registerRequest);
        User newUserToAdd = new User();
        Mapper.map(registerRequest, newUserToAdd);
        userRepository.saveUser(newUserToAdd);
        uResponse.setMessage("New user " + registerRequest.getFirstName()  + " " + registerRequest.getLastName() + " successfully registered.");
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
        Contact newContact = new Contact();
        Mapper.map(contactRequest, newContact);
        var savedContact = contactService.saveContact(newContact);
        User user = userRepository.findByEmail(contactRequest.getUserEmail());
        user.getContacts().add(savedContact);
        userRepository.saveUser(user);
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setMessage(String.format("%s successfully added.", contactRequest.getFirstName()));
        return contactResponse;
    }

    @Override
    public void deleteContact(String contact) {
    }

    @Override
    public List<AllContactResponse> findContactsBelongingTo(String email) {
        var user = userRepository.findByEmail(email);
        List<Contact> allUserContacts = user.getContacts();
        List<AllContactResponse> response = new ArrayList<>();
        allUserContacts.forEach(contact -> {
        AllContactResponse singleResponse = new AllContactResponse();
            Mapper.map(singleResponse, contact);
            response.add(singleResponse);
        });
        return response;
    }


}
