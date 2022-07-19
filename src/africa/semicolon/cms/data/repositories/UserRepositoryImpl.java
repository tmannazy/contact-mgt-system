package africa.semicolon.cms.data.repositories;

import africa.semicolon.cms.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int counter;
    private List<User> users = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        counter++;
        user.setId(counter);
        users.add(user);
        return user;
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void delete(User userToDelete) {
        users.removeIf(user -> user.getId() == userToDelete.getId());
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public User findById(int id) {
        for (var user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByLastName(String name) {
        return null;
    }

    @Override
    public List<User> findByFirstName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
