package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.repositories.ContactRepository;
import africa.semicolon.cms.dtos.responses.ContactResponse;
import africa.semicolon.cms.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
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
        return (int) contactRepository.count();
    }


}
