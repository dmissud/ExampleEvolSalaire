package org.dbs.business;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    @OneToMany(cascade = {CascadeType.ALL})
    protected Set<Role> roles;

    @ManyToOne(cascade = {CascadeType.ALL})
    PostalAdress postalAdress;

    // Get and Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public PostalAdress getPostalAdress() {
        return postalAdress;
    }

    public void setPostalAdress(PostalAdress postalAdress) {
        this.postalAdress = postalAdress;
    }
}
