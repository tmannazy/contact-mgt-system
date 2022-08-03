package africa.semicolon.cms.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@Document("Users")
public class User {
    @Id
    private String  id;
    @Getter
    @Setter
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String pin;
    @DBRef
    private List<Contact> contacts = new ArrayList<>();

}
