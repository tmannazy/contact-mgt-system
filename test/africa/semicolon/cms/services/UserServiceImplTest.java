package africa.semicolon.cms.services;

import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.exceptions.UserExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserServiceImplTest {
    UserService userCreated;

    @BeforeEach
    void setUp() {
        userCreated = new UserServiceImpl();
    }


    @Test
    void testThatNewAccountIsCreated() {
        RegisterRequest userReq = new RegisterRequest();
        RegisterUserResponse res = new RegisterUserResponse();
        userReq.setEmail("tee@gmail.com");
        userReq.setFirstName("Tman");
        userReq.setLastName("Acesochi");
        userReq.setPin("7685");
        userCreated.register(userReq);
        assertEquals(1, userCreated.numberOfUsers());
        assertEquals("User created", res.response());
    }

    @Test
    void testThatDuplicateEmailThrowsException() {
        RegisterUserResponse res = new RegisterUserResponse();
        RegisterRequest userReq = new RegisterRequest();
        userReq.setEmail("tee@gmail.com");
        userReq.setFirstName("Tman");
        userReq.setLastName("Acesochi");
        userReq.setPin("7685");
        userCreated.register(userReq);

        RegisterRequest userReq2 = new RegisterRequest();
        userReq2.setEmail("tee@gmail.com");
        userReq2.setFirstName("Fash");
        userReq2.setLastName("Perception");
        userReq2.setPin("4567");
        assertEquals(1, userCreated.numberOfUsers());
        assertThrows(UserExistException.class, () -> userCreated.register(userReq2));
    }

}