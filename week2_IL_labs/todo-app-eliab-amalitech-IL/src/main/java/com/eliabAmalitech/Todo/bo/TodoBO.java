package com.eliabAmalitech.Todo.bo;

import java.util.List;

import com.eliabAmalitech.Todo.controller.model.TodoItem;

public interface TodoBO {

	List<TodoItem> getTodoItems();

	TodoItem addTodoItem(TodoItem todoItem);

	void deleteTodoItem(Integer id);

	List<TodoItem> getTodoItems(boolean complete);

	void changeTodoItemStatus(Integer id, String status);

}
