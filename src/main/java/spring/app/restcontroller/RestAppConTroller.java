package spring.app.restcontroller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import spring.app.model.EmployeeRequest;
import spring.app.model.Task;
import spring.app.service.TaskService;

@RestController
@RequestMapping("/api")
public class RestAppConTroller {
	
	@Autowired
	private TaskService taskService;
    private static final Logger logger = LogManager.getLogger(RestAppConTroller.class);
	@GetMapping("/")
	
	public String getmessage()
	{
		logger.info("*****starting / is called****");
		return "springboot app";
	}
	
	@GetMapping("/taskAllData")
	public String findAll()
	{
		logger.info("*****findAll method called****");
		return taskService.findAll().toString();
	}
	@GetMapping("/getSingleTask/{id}")
	public String getOne(@PathVariable Integer id)
	{
		logger.info("*****getOne method called****");
		return taskService.findTask(id).toString();
	}
	
	@GetMapping("/findByIdAndName/{id}/{name}")
	public Task getEmployeeByidandName(@PathVariable Integer id,@PathVariable String name)
	{
		logger.info("*****getOne method called****");
		
 Task list=taskService.getEmployeeByidandName(id,name);
 return list;
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleting(@PathVariable Integer id)
	{
		logger.info("*****deleting method called****");
		taskService.deleting(id);
		return "delete a record based on "+id;
	}
	
	@GetMapping("/getTaskId")
	public String findOne(@RequestParam Integer id)
	{
		logger.info("*****findOne method called****");
		
		return taskService.findTask(id).toString();
	}
	
	
	
	@PostMapping("/getAllTasksByIds")
	public List<Task> getAllIds(@RequestBody EmployeeRequest employeeRequest)
	{
		logger.info("**getOne method called*");//{"employeeIds":[1,2]}
		List<Task> list=taskService.findAllByIds(employeeRequest);
		return list;
	}
	
	
	
	@PostMapping("/insertTask/{name}/{addrs}")
	public String insert(@PathVariable String name,@PathVariable String addrs)
	{
		logger.info("*****insert method called****");
		taskService.inserting(name, addrs);
		return "insert a record";
	}
	
	
	@PutMapping("/updateTask/{name}/{addrs}/{finish}/{id}")
	public String update(@PathVariable String name,@PathVariable String addrs,@PathVariable String finish,@PathVariable Integer id)
	{
		logger.info("*****update method called****");
		
		taskService.update(name, addrs,finish,id);
		return "record is updated based on "+ id;
	}

	@PutMapping("/updateDefault/{id}")
	public String updateDefault(@PathVariable Integer id)
	{
		logger.info("*****update method called****");
		
		taskService.updateDefault(id);
		return "record is updated based on "+ id;
	}
	@PostMapping("/save")
	public String save(@RequestBody Task task)
	{
		logger.info("*****insert method called****");
		taskService.save(task);
		return "insert a record";
	}
}
