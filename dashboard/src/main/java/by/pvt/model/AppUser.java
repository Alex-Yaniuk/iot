package by.pvt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *Simple JavaBean object that represent an User.
 *
 * @author Alex Yaniuk
 * @version 1.0
 */

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Transient
    private String confirmedPassword;

}
