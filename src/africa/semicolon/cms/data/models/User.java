package africa.semicolon.cms.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
public class User {
    private int id;
    @Getter
    @Setter
    private String firstName;
    private String lastName;
    private String email;
    private String pin;
//    private boolean setLock;
    private List<Contact> contacts = new ArrayList<>();

}
