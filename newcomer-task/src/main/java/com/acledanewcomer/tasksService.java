package com.acledanewcomer;

import java.util.List;

public interface tasksService {
	List<taskModel> getAllTasks();
	taskModel saveTask(taskModel taskModel);
	taskModel getTaskById(Long id);
	taskModel updateTask(taskModel taskModel);
	void deleteTask(Long id);
}
