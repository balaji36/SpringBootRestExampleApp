package spring.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


import spring.app.model.EmployeeRequest;
import spring.app.model.Task;
import spring.app.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
	
	private final TaskRepository taskRepository;
    private static final Logger logger = LogManager.getLogger(TaskService.class);
	public TaskService(TaskRepository taskRepository) {
		super();
		 logger.info("*****TaskRepository obj is created****");
		this.taskRepository = taskRepository;
		
		
	}
	
	public List<Task> findAll()
	{
		 logger.info("*****findAll method is called****");
		List<Task> tasks=new ArrayList<>();
		for(Task task:taskRepository.findAll())
		{
			tasks.add(task);
		}
		
		return tasks;
	}
	
	public List<Task> findAllByIds(EmployeeRequest employeeRequest)
	{
		Set<Integer> emptIds = employeeRequest.getEmployeeIds();
				
		Iterable<Task> employeeIterable = taskRepository.findAll(emptIds);
				List<Task> employees = new ArrayList<Task>();
				employeeIterable.forEach(employees::add);
		return  employees;
		
	}
	
	 
	 public Task getEmployeeByidandName(int id, String name)
	 {
	 Task employee=taskRepository.findByIdAndName(id, name);
	 return employee;
	 
	 }
	public Task findTask(int id) {
		logger.info("*****findTask id method is called****");
		return taskRepository.findOne(id);
	}
	
	
	public void inserting(String name, String addrs) {
		logger.info("*****inserting method is called****");
		Task task = new Task(name, addrs, "false", new Date());
		taskRepository.save(task);
	}
	
	public void deleting(int id) {
		logger.info("*****deleting method is called****");
		taskRepository.delete(id);
	}
	public void update(String name, String addrs,String finished,int id) {
		logger.info("*****update method is called****");
		Task task = new Task();
		Date d=new Date();
	task.setId(id);
	task.setName(name);
	task.setAddrs(addrs);
	task.setFinished(finished);
	task.setDate(d);
		taskRepository.save(task);
	}
	
	public void updateDefault(int id) {
		logger.info("*****update method is called****");
		Task task = new Task();
		Date d=new Date();
	task.setId(id);
	task.setName("kiran");
	task.setAddrs("chennai");
	task.setFinished("true");
	task.setDate(d);
		taskRepository.save(task);
	}
	public Task save(Task task)
	{
		logger.info("*****save method is called****");
		 return taskRepository.save(task);
	}
	
	

}
