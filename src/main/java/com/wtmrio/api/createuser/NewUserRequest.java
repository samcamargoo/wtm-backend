package com.wtmrio.api.createuser;

import com.wtmrio.api.shared.Unique;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record NewUserRequest(@Email(message = "Email invalido")
                             @NotBlank(message = "Campo email nao pode estar em branco")
                             @Unique(domainClass = UserEntity.class, fieldName = "email")
                             String email,
                             @Length(message = "Senha deve conter no minimo 3 caracteres", min = 3)
                             String password) {

    public UserEntity toModel() {
        return new UserEntity(email, new CleanPassword(password));
    }
}
