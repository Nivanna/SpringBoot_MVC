package com.acledanewcomer;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class tasksServiceImpl implements tasksService {

	private taskRepository taskRepository;
	
	public tasksServiceImpl(com.acledanewcomer.taskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<taskModel> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public taskModel saveTask(taskModel Task) {
		return taskRepository.save(Task);
	}

	@Override
	public taskModel getTaskById(Long id) {
		
		return taskRepository.findById(id).get();
	}

	@Override
	public taskModel updateTask(taskModel Task) {
		return taskRepository.save(Task);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}

}
