package africa.semicolon.cms;

import africa.semicolon.cms.controllers.UserController;
import africa.semicolon.cms.dtos.requests.ContactRequest;
import africa.semicolon.cms.dtos.requests.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static UserController userController = new UserController();
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        displayMainMenu();
    }

    private static void displayMainMenu() {
        String prompt = """
                
                WELCOME TO FAKE CALLER
                1 -> Create an Account
                2 -> Add contact to a user
                3 -> Find contact belonging to user
                4 -> List all users
                """;
        String userInput = input(prompt);
        switch (userInput.charAt(0)) {
            case '1'-> createAccount();
            case '2'-> addContactToAUser();
            case '3' -> findContactBelongingToUser();
            case '4' -> listAllUsers();

        }
    }

    private static void listAllUsers() {
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
