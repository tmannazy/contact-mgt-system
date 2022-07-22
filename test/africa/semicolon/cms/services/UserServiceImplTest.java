package africa.semicolon.cms.services;

import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.RegisterUserResponse;
import africa.semicolon.cms.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserServiceImplTest {
    UserService userCreated;
    RegisterRequest userReq;

    @BeforeEach
    void setUp() {
        userCreated = new UserServiceImpl();
        userReq = new RegisterRequest();
    }


    @Test
    void testThatNewAccountIsCreated() {
        userReq.setEmail("tee@gmail.com");
        userReq.setFirstName("Tman");
        userReq.setLastName("Acesochi");
        userReq.setPin("7685");
        userCreated.register(userReq);
        assertEquals(1, userCreated.numberOfUsers());
    }

    @Test
    void testThatDuplicateEmailThrowsException() {
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
        assertThrows(UserExistsException.class, () -> userCreated.register(userReq2));
    }

    @Test
    void testThatUserCanAddContacts() {
        userReq.setEmail("tee@gmail.com");
        userReq.setFirstName("Tman");
        userReq.setLastName("Acesochi");
        userReq.setPin("7685");
        userCreated.register(userReq);

    }

}