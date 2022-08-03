package africa.semicolon.cms.data.repositories;

import africa.semicolon.cms.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
