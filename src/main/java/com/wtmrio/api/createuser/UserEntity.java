package com.wtmrio.api.createuser;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;

    @Deprecated
    public UserEntity() {

    }
    public UserEntity(String email, CleanPassword password) {
        this.email = email;
        this.password = password.encrypt();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
