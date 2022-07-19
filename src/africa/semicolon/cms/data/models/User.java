package africa.semicolon.cms.data.models;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String pin;
    private int id;
    private boolean setLock;

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

    public boolean isLocked(String pin) {
        if (Objects.equals(this.pin, pin)) {
            setLock = true;
            return true;
        }
        return false;
    }

    public void updatePin() {
        setPin(this.pin);
    }
}
