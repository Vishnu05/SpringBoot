package data.jpa.Entity;

import javax.persistence.*;
import java.lang.reflect.Type;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
