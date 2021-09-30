package spring.app.model;

import java.util.Set;

public class EmployeeRequest {
	private Set<Integer> employeeIds;

	public Set<Integer> getEmployeeIds() {
		return employeeIds;
	}

	public void setEmployeeIds(Set<Integer> employeeIds) {
		this.employeeIds = employeeIds;
	}

}
