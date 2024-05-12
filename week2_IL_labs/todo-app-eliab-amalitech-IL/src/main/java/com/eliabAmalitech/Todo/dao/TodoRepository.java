package com.eliabAmalitech.Todo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliabAmalitech.Todo.entity.TodoItemEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoItemEntity, Integer>{
	
	List<TodoItemEntity> findByComplete(boolean complete);

	TodoItemEntity findById(Integer id);

}
