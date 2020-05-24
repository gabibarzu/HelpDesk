package project.company.organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.company.Person;
import project.company.support.ITGuy;
import project.helpDesk.Request;
import project.helpDesk.Status;
import project.helpDesk.StatusEnum;

public class Manager extends Person {
	public List<Employee> Employees;

	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
		this.Employees = new ArrayList<Employee>();
	}

	public Manager(String firstName, String lastName, Date hirindDate) {
		super(firstName, lastName, hirindDate);
		this.Employees = new ArrayList<Employee>();
	}

	public void AddEmployeeToManager(Manager manager, Employee employee) throws Exception {
		if (employee.Manager == null) {
			this.Employees.add(employee);
			employee.Manager = manager;
		} else {
			throw new Exception("Sorry, the employee already has a manager");
		}
	}

	public void ApproveRequest(Manager manager, Request request, ITGuy itGuy) throws Exception {
		if (request.CreatedBy.Manager == manager) {
			if (request.CurrentStatus().Value == StatusEnum.WAITINGAPPROVEL) {
				request.Statuses.add(new Status(StatusEnum.APPROVED));
				request.Statuses.add(new Status(StatusEnum.RESOLVING, itGuy));
			} else {
				throw new Exception("Sorry, this request does not need approvel");
			}
		} else {
			throw new Exception("Sorry, this is not your request for approvel");
		}
	}

	public void RejectRequest(Manager manager, Request request, ITGuy itGuy) throws Exception {
		if (request.CurrentStatus().Value == StatusEnum.WAITINGAPPROVEL) {
			if (request.CurrentStatus().Value == StatusEnum.WAITINGAPPROVEL) {
				request.Statuses.add(new Status(StatusEnum.REJECTED));
			} else {
				throw new Exception("Sorry, this request does not need approvel");
			}
		} else {
			throw new Exception("Sorry, this is not your request for approvel");
		}

	}
}
