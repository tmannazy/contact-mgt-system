package africa.semicolon.cms.data.repositories;

import africa.semicolon.cms.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    @Test
    void testThatUserIsAdded() {
        UserRepository userRepository = new UserRepositoryImpl();
        User newUser = new User();
        newUser.setFirstName("Eden");
        newUser.setLastName("Praise");
        newUser.setPin("1234");
        userRepository.saveUser(newUser);
        assertEquals(1, userRepository.count());
    }

    @Test
    void addUser_deleteUserById() {
        UserRepository userRepository = new UserRepositoryImpl();
        User newUser = new User();
        newUser.setFirstName("Eden");
        newUser.setLastName("Praise");
        newUser.setPin("1234");
        userRepository.saveUser(newUser);
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
        assertNull(userRepository.findById(1));
    }

    @Test
    void addUser_deleteUser() {
        UserRepository userRepository = new UserRepositoryImpl();
        User newUser = new User();
        newUser.setFirstName("Eden");
        newUser.setLastName("Praise");
        newUser.setPin("1234");
        userRepository.saveUser(newUser);
        userRepository.delete(newUser);
        assertEquals(0, userRepository.count());
        assertNull(userRepository.findById(1));
    }

    @Test
    void addUser_testThatPinIsCorrect() {
        UserRepository userRepository = new UserRepositoryImpl();
        User newUser = new User();
        newUser.setFirstName("Eden");
        newUser.setLastName("Praise");
        newUser.setPin("1234");
        userRepository.saveUser(newUser);

    }
}
