package africa.semicolon.cms.data.repositories;

import africa.semicolon.cms.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);

    void delete(Contact contact);

    void delete(int id);

    Contact findById(int id);

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByLastName(String lastName);

    int count();
}
