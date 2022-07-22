package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.repositories.ContactRepository;
import africa.semicolon.cms.data.repositories.ContactRepositoryImpl;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.responses.ContactResponse;

public class ContactServiceImpl implements ContactService {
    ContactRepository contactRepository = new ContactRepositoryImpl();
    ContactResponse contactResponse = new ContactResponse();

    @Override
    public ContactResponse saveContact(ContactRequest contactRequest) {
        Contact contact = new Contact(contactRequest.getFirstName(), contactRequest.getLastName(),
                contactRequest.getEmail(), contactRequest.getPhoneNumber());
        contactRepository.save(contact);
        System.out.println(contactResponse.getMessage());
        return contactResponse;
    }

    @Override
    public int getNumberOfContacts() {
        return contactRepository.count();
    }
}
