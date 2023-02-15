package com.example.week6_hw28.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // @Column(unique = true, columnDefinition = "not null")
    @Column(unique = true)
    private String username;
    //@Column(columnDefinition ="varchar(30) not null")
    private String password;

    @Column(columnDefinition = "varchar(30) not null check (role= 'CUSTOMER' or role='ADMIN')")
    private String role;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myUser")
    private Set<Orders> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
