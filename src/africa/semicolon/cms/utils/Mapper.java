package africa.semicolon.cms.utils;

import africa.semicolon.cms.data.models.Contact;
import africa.semicolon.cms.data.models.User;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import africa.semicolon.cms.dtos.responses.AllContactResponse;

public class Mapper {
    public static void map(RegisterRequest registerRequest, User newUserToAdd) {
        newUserToAdd.setEmail(registerRequest.getEmail());
        newUserToAdd.setLastName(registerRequest.getLastName());
        newUserToAdd.setFirstName(registerRequest.getFirstName());
        newUserToAdd.setPin(registerRequest.getPin());
    }

    public static void map(Contact contact, Contact newContact) {
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setEmail(contact.getEmail());
        newContact.setPhoneNumber(contact.getPhoneNumber());
    }

    public static void map(ContactRequest contactRequest, Contact newContact) {
        newContact.setFirstName(contactRequest.getFirstName());
        newContact.setLastName(contactRequest.getLastName());
        newContact.setEmail(contactRequest.getEmail());
        newContact.setPhoneNumber(contactRequest.getPhoneNumber());
    }

    public static void map(AllContactResponse singleResponse, Contact contact) {
        singleResponse.setFirstName(contact.getFirstName());
        singleResponse.setLastName(contact.getLastName());
        singleResponse.setId(contact.getId() + "");
    }
}
