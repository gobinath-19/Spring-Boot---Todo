package com.todoapp.Todo.Repository.jpa;

import org.springframework.stereotype.Repository;
import com.todoapp.Todo.model.TodoJpa;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoJpa, Long> {
}
