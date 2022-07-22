package africa.semicolon.cms.services;

import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.responses.ContactResponse;

public interface ContactService {
    ContactResponse saveContact(ContactRequest contactRequest);

    int getNumberOfContacts();
}
