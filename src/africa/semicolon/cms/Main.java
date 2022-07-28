package africa.semicolon.cms;

import africa.semicolon.cms.controllers.UserController;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;

import java.util.Scanner;

public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static UserController userController = new UserController();
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        String prompt = """
                
                WELCOME TO FAKE CALLER
                1 -> Create an Account
                2 -> Add contact to a user
                3 -> Find contact belonging to user
                """;
        String userInput = input(prompt);
        switch (userInput.charAt(0)) {
            case '1'-> createAccount();
            case '2'-> addContactToAUser();
            case '3' -> findContactBelongingToUser();

        }
    }

    private static String input(String prompt) {
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }

    private static void findContactBelongingToUser() {
        var contacts = userController.findContactBelongingTo(input("Enter your email: "));
        contacts.forEach(contact -> System.out.println(contact.toString()));
        displayMainMenu();
    }

    private static void addContactToAUser() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setEmail(input("Enter contact email: "));
        contactRequest.setUserEmail(input("Enter your email: "));
        contactRequest.setFirstName(input("Enter your first name: "));
        contactRequest.setLastName(input("Enter your last name: "));
        contactRequest.setPhoneNumber(input("Enter phone: "));
        userController.addContact(contactRequest);
        displayMainMenu();
    }

    private static void createAccount() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter first name "));
        request.setLastName(input("Enter last name: "));
        request.setPin(input("Enter password: "));
        request.setEmail(input("Enter email: "));
        userController.registerUser(request);
        System.out.println("done");
        displayMainMenu();
    }
}