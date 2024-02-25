package com.wtmrio.api.createuser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CreateUserController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createUser(@RequestBody @Valid NewUserRequest request) {
        UserEntity user = request.toModel();
        entityManager.persist(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
