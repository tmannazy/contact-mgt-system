package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.User;
import africa.semicolon.cms.data.repositories.UserRepository;
import africa.semicolon.cms.data.repositories.UserRepositoryImpl;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.exceptions.UserExistException;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();
    private RegisterUserResponse uResponse = new RegisterUserResponse();


    @Override
    public RegisterUserResponse register(RegisterRequest registerRequest) throws UserExistException {
        var savedUser = userRepository.findByEmail(registerRequest.getEmail());
        if (savedUser != null) {
            throw new UserExistException(registerRequest.getEmail() + " user already exists");
        }
        User newUserToAdd = new User();
        newUserToAdd.setEmail(registerRequest.getEmail());
        newUserToAdd.setLastName(registerRequest.getLastName());
        newUserToAdd.setFirstName(registerRequest.getFirstName());
        newUserToAdd.setPin(registerRequest.getPin());
        userRepository.saveUser(newUserToAdd);
        System.out.println(uResponse.getMessage());
        return uResponse;
    }

    @Override
    public int numberOfUsers() {
        return userRepository.count();
    }
}
