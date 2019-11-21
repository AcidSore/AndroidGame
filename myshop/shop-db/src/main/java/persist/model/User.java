package persist.model;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String userName, String login, String password, String email ) {
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String userName, String password, String email, Collection<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", password='" + "*********" + '\''
                + ", firstName='" + '\'' + ", email='" + email + '\''
                + ", roles=" + roles + '}';
    }

}
