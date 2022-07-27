package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;

import java.util.List;

public interface ContactService {
    Contact saveContact(Contact contact);

    int getNumberOfContacts();

    List<Contact> findContactByEmail(String email);

}
