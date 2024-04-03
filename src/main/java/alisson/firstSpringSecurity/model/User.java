package alisson.firstSpringSecurity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;

    // Mapping a collection of roles associated with the User entity.
    // The roles are eagerly fetched when querying the User.
    @ElementCollection(fetch = FetchType.EAGER) //This annotation is used to map a collection of
    // elements associated with an entity.
    // In this case, we are mapping the list of roles for the user.
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id")) //Here, we specify the
    // intermediate table that will store the user’s roles.
    // The tab_user_roles table will be used to relate roles to the user.
    @Column(name = "role_id") //This indicates that the role_id field
    // in the tab_user_roles table will be used to store the values from the user’s roles list.
    private List<String> roles = new ArrayList<>();

    public User(String username){
        this.username = username;
    }

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
