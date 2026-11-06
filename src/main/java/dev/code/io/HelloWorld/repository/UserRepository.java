package dev.code.io.HelloWorld.repository;

import dev.code.io.HelloWorld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//CRUD - Create Read Update Delete
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail (String email);

}
