package africa.semicolon.cms.data.models;

public class User {
    private String firstName;
    private String lastName;
    private String pin;
    private boolean isLocked = false;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
