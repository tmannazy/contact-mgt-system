package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;

public interface ContactService {
    Contact saveContact(Contact contact);

    int getNumberOfContacts();

}
