package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.dtos.requests.ContactRequest;

import java.util.List;

public interface ContactService {
    Contact saveContact(ContactRequest contactRequest);

    int getNumberOfContacts();

}
