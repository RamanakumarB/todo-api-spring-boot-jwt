package dev.code.io.HelloWorld.repository;
import dev.code.io.HelloWorld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD - Create Read Update Delete
public interface TodoRepository extends JpaRepository<Todo,Integer> {

}
