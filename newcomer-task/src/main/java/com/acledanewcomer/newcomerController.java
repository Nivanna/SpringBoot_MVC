package com.acledanewcomer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class newcomerController {
	
	private tasksService tasksService;
	
	
	public newcomerController(com.acledanewcomer.tasksService tasksService) {
		super();
		this.tasksService = tasksService;
	}

	
	@GetMapping("/tasks")
	public String tasks(Model model) {
		
		model.addAttribute("tasks", tasksService.getAllTasks() );
		return "taskpage";
	}
	
	@GetMapping("/tasks/new")
	public String newTask(Model model) {
		taskModel task = new taskModel();
		model.addAttribute("task_re", task);
		return "create_task";
		
	}
	
	@PostMapping("/tasks")
	public String saveTask(@ModelAttribute("task_re") taskModel Task) {
		tasksService.saveTask(Task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks/edit/{id}")
	public String editTask(@PathVariable Long id, Model model) {
		model.addAttribute("task_re", tasksService.getTaskById(id));
		return "edit_task";
	}
	
	@PostMapping("/tasks/{id}")
	public String updateTask(@PathVariable Long id, @ModelAttribute("task_re") taskModel task, Model model) {
		//get exiting task
		taskModel existingTask = tasksService.getTaskById(id);
		existingTask.setTask(task.getTask());
		existingTask.setDescription(task.getDescription());
		existingTask.setIssue(task.getIssue());
		tasksService.updateTask(existingTask);
		return "redirect:/tasks";
	}
   
	
	//delete Post
	@GetMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Long id) {
		tasksService.deleteTask(id);
		return "redirect:/tasks";
	}
}
