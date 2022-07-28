package africa.semicolon.cms.services;

import africa.semicolon.cms.dtos.requests.ContactRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactServiceImplTest {

    @Test
    void testThatContactIsAdded() {
        ContactService contactService = new ContactServiceImpl();
        ContactRequest contactRequest = new ContactRequest("Semicolon","Alarm","read@gmail.com","1234567890");
        contactService.saveContact(contactRequest);
        assertEquals(1,contactService.getNumberOfContacts());
    }

}