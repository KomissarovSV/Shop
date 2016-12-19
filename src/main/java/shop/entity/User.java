package shop.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import shop.common.PasswordMatches;
import shop.common.ValidEmail;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "UserTable")
@PasswordMatches
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String password;

    @ValidEmail
    private String email;

    @Transient
    private String matchingPassword;

    @ManyToMany
    private Set<Role> roles;
}
