package africa.semicolon.cms.data.repositories;

import africa.semicolon.cms.data.models.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    void delete(int id);

    void delete(User user);

    int count();

    User findById(int id);

    User find(String name);

    List<User> findByLastName(String name);

    List<User> findByFirstName(String name);

    List<User> findAll();

    User findByEmail(String email);
}
