package entties;

import lombok.Data;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_privilege")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}