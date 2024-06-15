package com.progra.examen.repositories;
import com.progra.examen.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long> {
}
