package spring.app.repository;

import org.springframework.data.repository.CrudRepository;

import spring.app.model.Task;

public interface TaskRepository extends CrudRepository<Task,Integer>{

	
	
	public Task  findByIdAndName(int id, String name);
}
