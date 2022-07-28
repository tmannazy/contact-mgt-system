package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.models.User;
import africa.semicolon.cms.data.repositories.ContactRepository;
import africa.semicolon.cms.data.repositories.ContactRepositoryImpl;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.responses.ContactResponse;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactRepository contactRepository = new ContactRepositoryImpl();
    ContactResponse contactResponse = new ContactResponse();

    @Override
    public Contact saveContact(ContactRequest contactRequest) {
        Contact contact = new Contact(
                contactRequest.getFirstName(), contactRequest.getLastName(),
                contactRequest.getEmail(), contactRequest.getPhoneNumber());
        contactRepository.save(contact);
        var response = contactResponse.getMessage();
        return contact;
    }


@Override
    public int getNumberOfContacts() {
        return contactRepository.count();
    }


}
