package company.organization;

import java.util.Date;
import java.util.List;

import company.Person;
import helpDesk.Request;
import helpDesk.Status;
import helpDesk.StatusEnum;

public class Employee extends Person {
	public Manager Manager;
	public List<Request> Requests;

	public Employee(String firstName, String lastName, Manager manager) {
		super(firstName, lastName);
		this.Manager = manager;
	}

	public Employee(String firstName, String lastName, Date hiredDate, Manager manager) {
		super(firstName, lastName, hiredDate);
		this.Manager = manager;
	}

	public void CreateNewRequest(Employee employee) {
		this.Requests.add(new Request(employee));
	}

	public void AcceptRequestSolution(Employee employee, Request request) throws Exception {
		if (request.CreatedBy == employee) {
			request.AddStatus(new Status(StatusEnum.RESOLVED));
		} else {
			throw new Exception("Sorry, this request is not yours");
		}
	}
	
	public void RejectRequestSolution(Employee employee, Request request) throws Exception {
		if (request.CreatedBy == employee) {
			request.AddStatus(new Status(StatusEnum.ADDNEWINFO));
		} else {
			throw new Exception("Sorry, this request is not yours");
		}
	}


	public void AddNewInfoForRequest(Employee employee, Request request) throws Exception {
		if (request.CreatedBy == employee && request.CurrentStatus().Value == StatusEnum.ADDNEWINFO) {
			request.AddStatus(new Status(StatusEnum.ANALYZE));
		} else {
			throw new Exception("Sorry, this request is not yours");
		}
	}
}