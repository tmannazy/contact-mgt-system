package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.repositories.ContactRepository;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.utils.Mapper;

public class ContactServiceImpl implements ContactService {
    ContactRepository contactRepository;
    ContactResponse contactResponse = new ContactResponse();


    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact saveContact(Contact contact) {
        Contact addNewContact = new Contact();
        Mapper.map(contact, addNewContact);
        contactRepository.save(addNewContact);
        var response = contactResponse.getMessage();
        return addNewContact;
    }


@Override
    public int getNumberOfContacts() {
        return contactRepository.count();
    }


}
