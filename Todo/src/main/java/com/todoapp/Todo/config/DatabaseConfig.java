package com.todoapp.Todo.config;

import com.todoapp.Todo.Repository.dal.TodoRepository;
import com.todoapp.Todo.Repository.dal.JpaRepositoryWrapper;
import com.todoapp.Todo.Repository.dal.EntityManagerRepositoryWrapper;
import com.todoapp.Todo.Repository.dal.HibernateRepositoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${app.database.method}")
    private String databaseMethod;

    @Autowired
    private JpaRepositoryWrapper jpaRepositoryWrapper;

    @Autowired
    private EntityManagerRepositoryWrapper entityManagerRepositoryWrapper;

    @Autowired
    private HibernateRepositoryWrapper hibernateRepositoryWrapper;

    public void init() {
        System.out.println("Database method: " + databaseMethod); // Log the value
    }

    @Bean
    public TodoRepository todoRepository() {
        switch (databaseMethod.trim().toLowerCase()) { // Trim and convert to lowercase
            case "jpa":
                return jpaRepositoryWrapper;
            case "entitymanager":
                return entityManagerRepositoryWrapper;
            case "hibernate":
                return hibernateRepositoryWrapper;
            default:
                throw new IllegalArgumentException("Invalid database method: " + databaseMethod);
        }
    }
}