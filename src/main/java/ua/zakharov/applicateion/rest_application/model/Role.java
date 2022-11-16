package ua.zakharov.applicateion.rest_application.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "role")
    @Transient
    private Set<User> userSet;

    @Override
    public String getAuthority() {
        return getName();
    }
}


