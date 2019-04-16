package fr.formation.students.entities;

import fr.formation.students.enumeration.Role;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//permet d'emporter la classe.
@Embeddable
public class UserAccount {

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = false)
    @Convert(converter =  BooleanConverter.class)
    private boolean accountNonExpired = true;

    @Column(nullable = false)
    @Convert(converter =  BooleanConverter.class)
    private boolean accountNonLocked = true;

    @Column(nullable = false)
    @Convert(converter =  BooleanConverter.class)
    private boolean credentialsNonExpired = true;

    @Column(nullable = false)
    @Convert(converter =  BooleanConverter.class)
    private boolean enabled = true;

    @Column(nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    public UserAccount() {
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

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
