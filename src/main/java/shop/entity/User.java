package shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    private String password;

    @Transient
    private String matchingPassword;

    @OneToMany
    private Set<Role> roles;
}
