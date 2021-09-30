package spring.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Entity(name="tbltask")
public class Task implements Serializable{
	
    private static final Logger logger = LogManager.getLogger(Task.class);
	
	public Task() {
		
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}
	public Date getDate() {
		return date;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public void setDate(Date date) {
		this.date = date;
	}
	private String name;
	private String addrs;
	
	private String finished;
	private Date date;
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", addrs=" + addrs + ", finished=" + finished + ", date=" + date
				+ "]";
	}
	public Task(String name, String addrs, String finished, Date date) {
		
		
		super();
		logger.info("Task constructor called......");
		this.name = name;
		this.addrs = addrs;
		this.finished = finished;
		this.date = date;
	}
}
