package africa.semicolon.cms.data.models;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public void setFirstName(String firstNme) {
        this.firstName = firstNme;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int idNum) {
        id = idNum;
    }

    public int getId() {
        return id;
    }
}
