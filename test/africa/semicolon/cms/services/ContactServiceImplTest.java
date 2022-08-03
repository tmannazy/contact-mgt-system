package africa.semicolon.cms.services;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.repositories.ContactRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactServiceImplTest {

    @Test
    void testThatContactIsAdded() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        ContactService contactService = new ContactServiceImpl(contactRepository);
        Contact contact = new Contact();
        contact.setFirstName("Semicolon");
        contact.setLastName("Alarm");
        contact.setEmail("read@gmail.com");
        contact.setPhoneNumber("1234567890");
        contactService.saveContact(contact);
        assertEquals(1,contactService.getNumberOfContacts());
        assertEquals(1, contact.getId());
    }

}