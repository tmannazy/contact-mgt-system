package africa.semicolon.cms.data.repositories;

import africa.semicolon.cms.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByEmailAddress(String emailAddress);
}
